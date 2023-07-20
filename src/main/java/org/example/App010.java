package org.example;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App010 {
    public static void main(String[] args) {
        try (InputStreamReader fileReader = new FileReader("lines.txt");
             OutputStreamWriter fileWriter = new FileWriter("lines_out.txt", true);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line = null;
            int lineCounter = 0;
//            while ((line = bufferedReader.readLine()) != null) {
//                if ((lineCounter++) % 2 == 0) {
//                    System.out.println(line);
//                    fileWriter.write(line+System.getProperty("line.separator"));
//                }
            char[] buffer = new char[(int)new File("lines.txt").length()];
            bufferedReader.read(buffer);
            //line.getChars(0, line.length(), buffer, 0);
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] == 'e')
                    fileWriter.write('E');
                else
                    fileWriter.write(buffer[i]);
            }
            fileWriter.write(System.getProperty("line.separator"));
        } catch (Exception exception) {
            Logger.getLogger(App010.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
