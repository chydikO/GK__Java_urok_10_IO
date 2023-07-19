package org.example;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileTest {
    public static void main(String[] args) {
        String fileName = "test.txt";
        String dirName = System.getProperty("user.dir") + File.separator + "files";
        String fullName = dirName + File.separator + fileName;
        System.out.println("fullName = " + fullName);
        File file = new File(fullName);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File " + fileName + " created!");
                } else {
                    System.out.println("Something wrong");
                }
            } catch (IOException exception) {
                Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, exception);
            }
        } else {
            System.out.println("File already exist !!!");
        }

        String dirTmp = dirName + File.separator + "tmp" + File.separator;
        File directoryTmp = new File(dirTmp);
        directoryTmp.mkdir();
    }
}