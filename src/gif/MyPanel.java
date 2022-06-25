package gif;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class MyPanel extends JPanel implements ActionListener {
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image enemy;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int xVelocity1 = 2;
    int yVelocity1 = 1;
    int x = 0;
    int y = 0;
    int x1 = 0;
    int y1 = 50;
    int xVelocity2 = 1;
    int yVelocity2 = 1;
    int x2 = 0;
    int y2 = 100;
    Graphics2D graphics2D;
    Graphics2D g2D;
    AffineTransform at;

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        enemy = new ImageIcon(getClass().getResource("../image/raumShiff.png")).getImage();
        backgroundImage = new ImageIcon(getClass().getResource("../image/kos.jpg")).getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        //BufferedImage Image = LoadImage(getClass().getResource("../image/raumShiff.png"));
        graphics2D = (Graphics2D) g;
        g2D = (Graphics2D) g;
        graphics2D.drawImage(backgroundImage, 0, 0, null);
        graphics2D.drawImage(enemy, x, y, null);
        graphics2D.drawImage(enemy, x1, y1, null);
        g2D.rotate(110, 250, 300);
        g2D.drawImage(enemy, x2, y2, null);
    }

    private BufferedImage LoadImage(URL Filename) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(Filename.toURI()));
        } catch (IOException | URISyntaxException e) {

        }
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= PANEL_WIDTH - enemy.getWidth(null) || x < 0) {
            xVelocity = xVelocity * (-1);
            y += 10;
            if (y >= 300) {
                y = 50;
            }
        }

        if (x1 >= PANEL_WIDTH - enemy.getWidth(null) || x1 < 0) {
            xVelocity1 = xVelocity1 * (-1);
            y1 += 10;
            if (y1 >= 300) {
                y1 = 50;
            }
        }


        if (x2 >= PANEL_WIDTH - enemy.getWidth(null) || x2 < 0) {
            xVelocity2 = xVelocity2 * (-1);
            y2 += 10;
            if (y2 >= 300) {
                y2 = 100;
            }
        }
        x = x + xVelocity;
        x1 = x1 + xVelocity1;
        x2 = x2 + xVelocity2;
        repaint();
    }
}
