import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        // slider to control horizontal rotation
        JSlider headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH);

        // slider to control vertical rotation
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);

        Cube tet = new Cube(new Vertex(-50, 50, -200), 50);
        Cube tet2 = new Cube(new Vertex(-100, -100, -500), 50);
        Camera cam = new Camera();

        // panel to display render results
        JPanel renderPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                tet.rotate(headingSlider.getValue(), pitchSlider.getValue());
                tet2.rotate(headingSlider.getValue(), pitchSlider.getValue());

                g2.translate(getWidth() / 2, getHeight() / 2);

                BufferedImage img =
                        new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

                tet2.draw(img,cam);
                tet.draw(img, cam);

                

                g2.drawImage(img, -getWidth() / 2, -getHeight() / 2, null);
            }
        };
        // if input of sliders change, redraw the 3d model
        headingSlider.addChangeListener(e -> renderPanel.repaint());
        pitchSlider.addChangeListener(e -> renderPanel.repaint());

        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}