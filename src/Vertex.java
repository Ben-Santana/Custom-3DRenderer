public class Vertex {
    double x;
    double y;
    double z;
    Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Vertex project(Camera cam, double screenX, double screenY) {
        double viewWidth = Math.sin(Math.toRadians(cam.xFOV / 2)) * z;
        double viewHeight = Math.sin(Math.toRadians(cam.yFOV / 2)) * z;
        double px = ( x / viewWidth ) * screenX / 2;
        double py = ( y / viewHeight ) * screenY / 2;
        // System.out.println("{ x: " + px + " }");
        // System.out.println("{ y: " + py + " }");

        return new Vertex(px, py, z);
    }
}
