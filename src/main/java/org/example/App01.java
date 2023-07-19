package org.example;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App01 {
    public static void main(String[] args) {
        byte[] buffer = null;

        try (InputStream in = new FileInputStream(new File("test.txt"));
             OutputStream out = new FileOutputStream(new File("outputFile.tmp"));) {
            buffer = new byte[in.available()];
            in.read(buffer);
            out.write(buffer);
        } catch (FileNotFoundException exception) {
            Logger.getLogger(App01.class.getName()).log(Level.SEVERE, null, exception);
        } catch (IOException exception) {
            Logger.getLogger(App01.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
