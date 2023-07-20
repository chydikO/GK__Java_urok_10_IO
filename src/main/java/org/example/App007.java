package org.example;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// чтение обьекта из файла
public class App007 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            inputStream = new FileInputStream("outputApp006.txt");
            objectInputStream = new ObjectInputStream(inputStream);
            App006.Car car = (App006.Car) objectInputStream.readObject();
            System.out.println("Read Obj: -= " + car + " =- from file");
        } catch (Exception exception) {
            Logger.getLogger(App007.class.getName()).log(Level.SEVERE, null, exception);

        } finally {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
