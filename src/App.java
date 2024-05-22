import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class App implements KeyListener{
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

        player = new Player(new Vertex(0, 0, -100), new Color(255, 155, 100));
        cam = new Camera();

        // panel to display render results
        renderPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                player.rotate();


                g2.translate(getWidth() / 2, getHeight() / 2);

                BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

                player.move();
                player.draw(img, cam);

                g2.drawImage(img, -getWidth() / 2, -getHeight() / 2, null);
            }
        };

        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setVisible(true);

        // Ensure the render panel is focusable and request focus
        renderPanel.addKeyListener(this);
        renderPanel.setFocusable(true);
        renderPanel.requestFocusInWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                player.velocity.z = -2;
                renderPanel.repaint();
                break;
            case KeyEvent.VK_S:
                player.velocity.z = 2;
                renderPanel.repaint();
                break;
            case KeyEvent.VK_A:
                player.velocity.x = 2;
                renderPanel.repaint();
                break;
            case KeyEvent.VK_D:
                player.velocity.x = -2;
                renderPanel.repaint();
                break;
            case KeyEvent.VK_SPACE:
                player.velocity.y = 2;
                renderPanel.repaint();
                break;
            case KeyEvent.VK_SHIFT:
                player.velocity.y = -2;
                renderPanel.repaint();
                break;
            case KeyEvent.VK_E:
                player.heading += 2;
                renderPanel.repaint();
                break;
            case KeyEvent.VK_Q:
                player.heading -= 2;
                renderPanel.repaint();
                break;
            case KeyEvent.VK_R:
                player.pitch -= 2;
                renderPanel.repaint();
                break;
            case KeyEvent.VK_F:
                player.pitch += 2;
                renderPanel.repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                if(player.velocity.z == -2) {
                    player.velocity.z = 0;
                    renderPanel.repaint();
                }
                break;
            case KeyEvent.VK_S:
                if(player.velocity.z == 2) {
                    player.velocity.z = 0;
                    renderPanel.repaint();
                }
                break;
            case KeyEvent.VK_A:
                if(player.velocity.x == 2) {
                    player.velocity.x = 0;
                    renderPanel.repaint();
                }
                break;
            case KeyEvent.VK_D:
                if(player.velocity.x == -2) {
                    player.velocity.x = 0;
                    renderPanel.repaint();
                }
                break;
            case KeyEvent.VK_SPACE:
                if(player.velocity.y == 2) {
                    player.velocity.y = 0;
                    renderPanel.repaint();
                }
                break;
            case KeyEvent.VK_SHIFT:
                if(player.velocity.y == -2) {
                    player.velocity.y = 0;
                    renderPanel.repaint();
                }
                break;
        }
    }
}
