public class Camera {
    double xFOV;
    double yFOV;
    Vertex position;
    Vertex direction;
    
    Camera(double xFOV, double yFOV) {
        this.xFOV = xFOV;
        this.yFOV = yFOV;
        this.position = new Vertex(0, 0, 0);
        this.direction = new Vertex(0, 0, 1);
    }
    Camera() {
        this.xFOV = 90;
        this.yFOV = 90;
        this.position = new Vertex(0, 0, 0);
        this.direction = new Vertex(0, 0, 1);
    }
    
}
