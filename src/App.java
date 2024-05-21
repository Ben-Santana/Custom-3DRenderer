import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class App {
    private Player player;
    private Camera cam;
    private JPanel renderPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App().createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("3D Renderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        // slider to control horizontal rotation
        JSlider headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH);

        // slider to control vertical rotation
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);

        player = new Player(new Vertex(0, 0, -200), new Color(255, 255, 100));
        cam = new Camera();

        // panel to display render results
        renderPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                player.rotate(headingSlider.getValue(), pitchSlider.getValue());

                g2.translate(getWidth() / 2, getHeight() / 2);

                BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

                player.move();
                player.draw(img, cam);

                g2.drawImage(img, -getWidth() / 2, -getHeight() / 2, null);
            }
        };

        // if input of sliders change, redraw the 3D model
        headingSlider.addChangeListener(e -> renderPanel.repaint());
        pitchSlider.addChangeListener(e -> renderPanel.repaint());

        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setVisible(true);

        // Add KeyListener to the frame
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        // Ensure the render panel is focusable and request focus
        renderPanel.setFocusable(true);
        renderPanel.requestFocusInWindow();
    }
}
