package org.example;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App008 {
    public static void main(String[] args) {
        String text = "This lines of text should be written in file\r\n"
                + "using buffered stream.\r\n"
                + "Just one more line.\r\n";
        try (OutputStream out = new FileOutputStream("noteApp008.txt");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);) {
            byte[] buffer = text.getBytes();
            bufferedOutputStream.write(buffer);
        } catch (Exception exception) {
            Logger.getLogger(App008.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
