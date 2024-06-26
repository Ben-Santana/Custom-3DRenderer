import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    private Cube body;
    public Vertex velocity;
    public int pitch;
    public int heading;
    public Vertex acceleration;
    private double maxSpeed;
    Player(Vertex position, Color color) {
        body = new Cube(position, 10, color);
        velocity = new Vertex(0, 0, 0);
        acceleration = new Vertex(0, 0, 0);
        maxSpeed = 10.0;
    }
    void move() {
        if(velocity.x + acceleration.x <= maxSpeed) {
            velocity.x += acceleration.x;
        }
        if(velocity.y + acceleration.y <= maxSpeed) {
            velocity.y += acceleration.y;
        }
        if(velocity.z + acceleration.z <= maxSpeed) {
            velocity.z += acceleration.z;
        }
        body.move(velocity.x, velocity.y, velocity.z);
    }
    void setBody(Cube body){
        this.body = body;
    }
    Cube getBody() {
        return body;
    }
    void rotate(){
        body.rotate(this.heading, this.pitch);
    }
    void draw(BufferedImage img, Camera cam){
        body.draw(img, cam);
    }
}
