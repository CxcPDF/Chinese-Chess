package ¼ÆÊ±Æ÷;

import javax.swing.*;
import java.awt.*;

public class background extends JPanel {
    int width = time.WIDTH;
    int height = time.HEIGHT;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("src/img/bg1.jpg").getImage();
        g.drawImage(image, 0, 0, width, height, this);
    }
}
