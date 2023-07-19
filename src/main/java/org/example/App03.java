package org.example;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * побайтовое чтение и запись в файл
 */

public class App03 {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream(new File("input003.txt"));
             OutputStream out = new FileOutputStream(new File("output003.txt"))) {
            int c;
            while ((c = in.read()) != -1) {
                if (c < 65) {
                    out.write(c);
                }
            }
        } catch (Exception exception) {
            Logger.getLogger(App03.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
