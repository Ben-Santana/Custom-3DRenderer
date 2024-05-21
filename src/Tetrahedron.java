import java.awt.Color;

public class Tetrahedron extends Polyhedron {
    Tetrahedron() {
        super();
        this.mesh.add(new Triangle(new Vertex(100, 100, 100),
            new Vertex(-100, -100, 100),
            new Vertex(-100, 100, -100),
            Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(100, 100, 100),
            new Vertex(-100, -100, 100),
            new Vertex(100, -100, -100),
            Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-100, 100, -100),
            new Vertex(100, -100, -100),
            new Vertex(100, 100, 100),
            Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-100, 100, -100),
            new Vertex(100, -100, -100),
            new Vertex(-100, -100, 100),
            Color.WHITE));
    }
    Tetrahedron(Vertex position) {
        super(position);
        this.mesh.add(new Triangle(new Vertex(100, 100, 100),
            new Vertex(-100, -100, 100),
            new Vertex(-100, 100, -100),
            Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(100, 100, 100),
            new Vertex(-100, -100, 100),
            new Vertex(100, -100, -100),
            Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-100, 100, -100),
            new Vertex(100, -100, -100),
            new Vertex(100, 100, 100),
            Color.WHITE));
        this.mesh.add(new Triangle(new Vertex(-100, 100, -100),
            new Vertex(100, -100, -100),
            new Vertex(-100, -100, 100),
            Color.WHITE));
    }
    Tetrahedron(Vertex position, Color color) {
        super(position);
        this.mesh.add(new Triangle(new Vertex(100, 100, 100),
            new Vertex(-100, -100, 100),
            new Vertex(-100, 100, -100),
            color));
        this.mesh.add(new Triangle(new Vertex(100, 100, 100),
            new Vertex(-100, -100, 100),
            new Vertex(100, -100, -100),
            color));
        this.mesh.add(new Triangle(new Vertex(-100, 100, -100),
            new Vertex(100, -100, -100),
            new Vertex(100, 100, 100),
            color));
        this.mesh.add(new Triangle(new Vertex(-100, 100, -100),
            new Vertex(100, -100, -100),
            new Vertex(-100, -100, 100),
            color));
    }
}
