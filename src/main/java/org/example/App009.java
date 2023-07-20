package org.example;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App009 {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream("noteApp008.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(in);) {
            byte[] chars = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(chars);
            System.out.println(new String(chars, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception exception) {
            Logger.getLogger(App009.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
