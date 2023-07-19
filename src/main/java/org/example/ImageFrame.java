package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ImageFrame {
    private final BufferedImage bufferedImage;
    private final JFrame jFrame;

    public ImageFrame(byte[] imageInByte) throws IOException {
        bufferedImage = ImageIO.read(new ByteArrayInputStream(imageInByte));
        jFrame = new JFrame();
        jFrame.setSize(bufferedImage.getWidth(), bufferedImage.getHeight());
        jFrame.setAlwaysOnTop(true);
        JPanel jPanel = new JPanel() {
            @Override
            public void paint(Graphics graphics) {
                super.paint(graphics);
                graphics.drawImage(
                        bufferedImage,
                        0,
                        0,
                        bufferedImage.getWidth(),
                        bufferedImage.getHeight(),
                        null);
            }
        };
        jPanel.setSize(bufferedImage.getWidth(), bufferedImage.getHeight());
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
}
