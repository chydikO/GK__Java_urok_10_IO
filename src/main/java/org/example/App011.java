package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App011 {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("lines.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "windows-1251");
             FileOutputStream fileOutputStream = new FileOutputStream("lines_1251.txt");
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8)) {
            int c = 0;
            while ((c = inputStreamReader.read()) != -1) {
                System.out.println((char) c);
                outputStreamWriter.write(c);
            }
        } catch (Exception exception) {
            Logger.getLogger(App011.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    public static void readWriteFileWithBufferedReader() {
        try (FileInputStream fis = new FileInputStream("lines.txt");
             InputStreamReader reader = new InputStreamReader(fis, "windows-1251");
             BufferedReader br = new BufferedReader(reader);
             FileOutputStream fs = new FileOutputStream("lines2.txt");
             OutputStreamWriter writer = new OutputStreamWriter(fs, "UTF-8");
             BufferedWriter bw = new BufferedWriter(writer)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line + System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App011.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App011.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
