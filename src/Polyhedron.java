import java.awt.image.BufferedImage;
import java.util.*;

public class Polyhedron {
    ArrayList<Triangle> mesh = new ArrayList<Triangle>();
    Matrix3 transform;
    Vertex position;

    Polyhedron() {
        this.transform = new Matrix3(new double[9]);
        this.mesh = new ArrayList<Triangle>();
        this.position = new Vertex(0, 0, 0);
    }
    Polyhedron(Vertex position) {
        this.mesh = new ArrayList<Triangle>();
        this.transform = new Matrix3(new double[9]);
        this.position = position;
    }
    Polyhedron(ArrayList<Triangle> mesh) {
        this.mesh = mesh;
        this.transform = new Matrix3(new double[9]);
        this.position = new Vertex(0, 0, 0);
    }
    Polyhedron(ArrayList<Triangle> mesh, Vertex position) {
        this.mesh = mesh;
        this.transform = new Matrix3(new double[9]);
        this.position = position;
    }

    void rotate(int heading, int pitch) {
        double headingVal = Math.toRadians(heading);
        double pitchVal = Math.toRadians(pitch);

        Matrix3 headingTransform = new Matrix3(new double[]{
                Math.cos(headingVal), 0, Math.sin(headingVal),
                0, 1, 0,
                -Math.sin(headingVal), 0, Math.cos(headingVal)
        });

        Matrix3 pitchTransform = new Matrix3(new double[]{
                1, 0, 0,
                0, Math.cos(pitchVal), Math.sin(pitchVal),
                0, -Math.sin(pitchVal), Math.cos(pitchVal)
        });

        this.transform = headingTransform.multiply(pitchTransform);
    }


    void draw(BufferedImage img, Camera cam) {
        if(position.z < 0){
            double[] zBuffer = new double[img.getWidth() * img.getHeight()];
            for (int i = 0; i < zBuffer.length; i++) {
                zBuffer[i] = Double.NEGATIVE_INFINITY;
            }
            for (Triangle t : mesh) {
                t.draw(img, cam, zBuffer, transform, position);
            }
        }
    }

    void move(double dx, double dy, double dz) {
        position.x += dx;
        position.y += dy;
        position.z += dz;
    }

    void moveTo(double x, double y, double z){
        position.x = x;
        position.y = y;
        position.z = z;
    }
}
