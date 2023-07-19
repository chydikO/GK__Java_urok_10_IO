package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String fileName = "test.txt";
        String dirName = System.getProperty("user.dir") + File.separator + "files";
        String fullName = dirName + File.separator + fileName;
        System.out.println("fullName = " + fullName);
        File file = new File(fullName);
    }
}