package org.example;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Чтение и запись файла через буфер, порциями
 */
public class App02 {
    public static void main(String[] args) {
        byte[] buffer = new byte[8 * 1024];
        try (InputStream in = new FileInputStream(new File("input.txt"));
             OutputStream out = new FileOutputStream(new File("outputApp02.txt"));) {
            int bytesRead = 0;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0 ,bytesRead);
            }
        } catch (Exception exception) {
            Logger.getLogger(App02.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
