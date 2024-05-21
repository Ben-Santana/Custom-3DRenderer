import java.awt.*;
import java.awt.image.BufferedImage;

public class Triangle {
    Vertex v1;
    Vertex v2;
    Vertex v3;
    Color color;
    Triangle(Vertex v1, Vertex v2, Vertex v3, Color color) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }
    Triangle(Vertex v1, Vertex v2, Vertex v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = new Color(255);
    }

    public static Color getShade(Color color, double shade) {
        double redLinear = Math.pow(color.getRed(), 2.4) * shade;
        double greenLinear = Math.pow(color.getGreen(), 2.4) * shade;
        double blueLinear = Math.pow(color.getBlue(), 2.4) * shade;

        Color minColor = new Color(color.getRed()/255, color.getGreen()/255, color.getBlue()/255);

        int red = Math.max(minColor.getRed() * 50, (int) Math.pow(redLinear, 1/2.4));
        int green = Math.max(minColor.getGreen() * 50, (int) Math.pow(greenLinear, 1/2.4));
        int blue = Math.max(minColor.getBlue() * 50, (int) Math.pow(blueLinear, 1/2.4));

        return new Color(red, green, blue);
    }

    void draw(BufferedImage img, Camera cam, double[] zBuffer, Matrix3 transform, Vertex position) {
        Vertex v1 = transform.transform(this.v1);
        Vertex v2 = transform.transform(this.v2);
        Vertex v3 = transform.transform(this.v3);

        v1.x += position.x;
        v1.y += position.y;
        v1.z += position.z;
        v2.x += position.x;
        v2.y += position.y;
        v2.z += position.z;
        v3.x += position.x;
        v3.y += position.y;
        v3.z += position.z;

        //find normal of triangle for shading
        Vertex ab = new Vertex(v2.x - v1.x, v2.y - v1.y, v2.z - v1.z);
        Vertex ac = new Vertex(v3.x - v1.x, v3.y - v1.y, v3.z - v1.z);
        Vertex norm = new Vertex(
                ab.y * ac.z - ab.z * ac.y,
                ab.z * ac.x - ab.x * ac.z,
                ab.x * ac.y - ab.y * ac.x
        );
        double normalLength = Math.sqrt(norm.x * norm.x + norm.y * norm.y + norm.z * norm.z);
        norm.x /= normalLength;
        norm.y /= normalLength;
        norm.z /= normalLength;

        double angleCos = Math.abs(norm.z);

        v1 = v1.project(cam, img.getWidth(), img.getHeight());
        v2 = v2.project(cam, img.getWidth(), img.getHeight());
        v3 = v3.project(cam, img.getWidth(), img.getHeight());

        v1.x += img.getWidth() / 2;
        v1.y += img.getHeight() / 2;
        v2.x += img.getWidth() / 2;
        v2.y += img.getHeight() / 2;
        v3.x += img.getWidth() / 2;
        v3.y += img.getHeight() / 2;

        int minX = (int) Math.max(0, Math.ceil(Math.min(v1.x, Math.min(v2.x, v3.x))));
        int maxX = (int) Math.min(img.getWidth() - 1, Math.floor(Math.max(v1.x, Math.max(v2.x, v3.x))));
        int minY = (int) Math.max(0, Math.ceil(Math.min(v1.y, Math.min(v2.y, v3.y))));
        int maxY = (int) Math.min(img.getHeight() - 1, Math.floor(Math.max(v1.y, Math.max(v2.y, v3.y))));

        //find triangle area for coloring
        double triangleArea = (v1.y - v3.y) * (v2.x - v3.x) + (v2.y - v3.y) * (v3.x - v1.x);

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {

                double b1 = ((y - v3.y) * (v2.x - v3.x) + (v2.y - v3.y) * (v3.x - x)) / triangleArea;
                double b2 = ((y - v1.y) * (v3.x - v1.x) + (v3.y - v1.y) * (v1.x - x)) / triangleArea;
                double b3 = ((y - v2.y) * (v1.x - v2.x) + (v1.y - v2.y) * (v2.x - x)) / triangleArea;

                if (b1 >= 0 && b1 <= 1 && b2 >= 0 && b2 <= 1 && b3 >= 0 && b3 <= 1) {

                    double depth = b1 * v1.z + b2 * v2.z + b3 * v3.z;
                    int zIndex = y * img.getWidth() + x;
                    if (zBuffer[zIndex] < 0
                        && zBuffer[zIndex] < depth
                        && x < img.getWidth() && x > 0
                        && y < img.getHeight() && y > 0) {
                        zBuffer[zIndex] = depth;
                        img.setRGB(x, y, getShade(this.color, angleCos).getRGB());
                    }

                }

            }
        }
    }
}
