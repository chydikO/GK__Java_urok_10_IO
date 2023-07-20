package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App037 {
    public static void main(String[] args) {

    }

    /**
     *  Этот метод будет получать в качестве параметра объект, который надо сериализировать и имя файла, в который
     * надо записать сериализованный объект.
     * @param object объект, который надо сериализировать
     * @param fileName имя файла, в который надо записать сериализованный объект.
     */
    public static void serialize(Object object, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
        } catch (Exception exception) {
            Logger.getLogger(App037.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    public static Object deserialize(String filename) {
        Object object = null;
        try (FileInputStream inputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
             object = objectInputStream.readObject();
        } catch (Exception exception) {
            Logger.getLogger(App037.class.getName()).log(Level.SEVERE, null, exception);
        }
        return object;
    }
}
