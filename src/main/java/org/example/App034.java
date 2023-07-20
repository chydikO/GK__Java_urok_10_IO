package org.example;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App034 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputLine = bufferedReader.readLine();
        } catch (IOException exception) {
            Logger.getLogger(App034.class.getName()).log(Level.SEVERE, null, exception);
        }

        //Теперь метод println() будет направлять свой вывод не в консольное окно, а в указанный файл.
        try {
            System.setOut(new PrintStream(new FileOutputStream("out.txt")));
            System.out.println("The output is redirected into file now!");
        } catch(Exception e) {
            System.err.println("File opening error:");
            e.printStackTrace();
        }
    }
}
