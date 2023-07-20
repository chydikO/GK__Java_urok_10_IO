package org.example;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App046 {
    public static void main(String[] args) {
        FishEx fish = new FishEx("salmon",2.5,180);
        System.out.println("fish = " + fish);
        serializeEx(fish,"fishes.txt");
        FishEx fishEx =(FishEx)deserializeEx("fishes.txt");
        System.out.println("Read obj from file -> " + fishEx);
    }

    public static void serializeEx(FishEx obj, String fileName) {
        try (OutputStream outputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            obj.writeExternal(objectOutputStream);
        } catch (Exception exception) {
            Logger.getLogger(App046.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    public static Object deserializeEx(String fileName) {
        FishEx fishEx = new FishEx();
        try (InputStream inputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            fishEx.readExternal(objectInputStream);
        } catch (Exception exception) {
            Logger.getLogger(App046.class.getName()).log(Level.SEVERE, null, exception);
        }
        return fishEx;
    }
}
