package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App004 {
    public static void main(String[] args) {
        String dirName = System.getProperty("user.dir") + File.separator + "files" + File.separator;

        try {
            BufferedImage bufferedImage = ImageIO.read(new File(dirName + "cat.jpg"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
            byte[] imageInByte = byteArrayOutputStream.toByteArray();
            ImageFrame imageFrame = new ImageFrame(imageInByte);
        } catch (Exception exception) {
            Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
