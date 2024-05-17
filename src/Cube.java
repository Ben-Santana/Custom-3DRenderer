import java.awt.Color;

public class Cube extends Polyhedron {
    Cube() {
        super();
        this.mesh.add(new Triangle(new Vertex(100, 100, 100),
                                    new Vertex(100, -100, 100),
                                    new Vertex(-100, -100, 100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-100, -100, 100),
                                    new Vertex(-100, 100, 100),
                                    new Vertex(100, 100, 100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-100, 100, 100),
                                    new Vertex(-100, -100, 100),
                                    new Vertex(-100, -100, -100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-100, -100, -100),
                                    new Vertex(-100, 100, -100),
                                    new Vertex(-100, 100, 100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(100, 100, 100),
                                    new Vertex(100, 100, -100),
                                    new Vertex(-100, 100, -100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-100, 100, -100),
                                    new Vertex(-100, 100, 100),
                                    new Vertex(100, 100, 100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(100, 100, -100),
                                    new Vertex(100, -100, -100),
                                    new Vertex(-100, -100, -100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-100, -100, -100),
                                    new Vertex(-100, 100, -100),
                                    new Vertex(100, 100, -100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(100, 100, 100),
                                    new Vertex(100, -100, 100),
                                    new Vertex(100, -100, -100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(100, -100, -100),
                                    new Vertex(100, 100, -100),
                                    new Vertex(100, 100, 100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(100, -100, 100),
                                    new Vertex(100, -100, -100),
                                    new Vertex(-100, -100, -100),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-100, -100, -100),
                                    new Vertex(-100, -100, 100),
                                    new Vertex(100, -100, 100),
                                    Color.WHITE));
    }
    Cube(Vertex position, int length) {
        super(position);
        this.mesh.add(new Triangle(new Vertex(length, length, length),
                                    new Vertex(length, -length, length),
                                    new Vertex(-length, -length, length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-length, -length, length),
                                    new Vertex(-length, length, length),
                                    new Vertex(length, length, length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-length, length, length),
                                    new Vertex(-length, -length, length),
                                    new Vertex(-length, -length, -length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-length, -length, -length),
                                    new Vertex(-length, length, -length),
                                    new Vertex(-length, length, length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(length, length, length),
                                    new Vertex(length, length, -length),
                                    new Vertex(-length, length, -length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-length, length, -length),
                                    new Vertex(-length, length, length),
                                    new Vertex(length, length, length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(length, length, -length),
                                    new Vertex(length, -length, -length),
                                    new Vertex(-length, -length, -length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-length, -length, -length),
                                    new Vertex(-length, length, -length),
                                    new Vertex(length, length, -length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(length, length, length),
                                    new Vertex(length, -length, length),
                                    new Vertex(length, -length, -length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(length, -length, -length),
                                    new Vertex(length, length, -length),
                                    new Vertex(length, length, length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(length, -length, length),
                                    new Vertex(length, -length, -length),
                                    new Vertex(-length, -length, -length),
                                    Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-length, -length, -length),
                                    new Vertex(-length, -length, length),
                                    new Vertex(length, -length, length),
                                    Color.WHITE));
    }
}
