package org.example;

import java.io.ByteArrayInputStream;

public class App005 {
    public static void main(String[] args) {
        String string = "This is a sample string to be capitalized";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes());

        int ch;
        StringBuilder stringBuilder = new StringBuilder();
        while ((ch = byteArrayInputStream.read()) != -1) {
            stringBuilder.append(Character.toUpperCase((char) ch));
        }
        System.out.println("Capitalized string: " + stringBuilder);
    }
}
