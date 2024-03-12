package de.theunycraft.sfs;

import java.util.Random;

public class Test implements ITestInterface {

    @Override
    public void testMethod() {
        System.out.println("This is a test method");
    }

    @Override
    public int getRandomInt() {
        return new Random().nextInt();
    }

    @Override
    public String getRandomString(int length) {
        String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++)
            stringBuilder.append(charset.charAt(new Random().nextInt(charset.length())));

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String text = "This is a text with 123 integers.";
        String replacedText = text.replaceAll("\\d", "\b");
        System.out.println("Original text: " + text);
        System.out.println("Replaced text: " + replacedText);
    }

}
