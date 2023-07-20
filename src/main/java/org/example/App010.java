package org.example;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App010 {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("lines.txt");
             FileWriter fileWriter = new FileWriter("lines_out.txt", true);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            int lineCounter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if ((lineCounter++) % 2 == 0) {
                    System.out.println(line);
                    fileWriter.write(line+System.getProperty("line.separator"));
                }
            }
        } catch (Exception exception) {
            Logger.getLogger(App010.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
