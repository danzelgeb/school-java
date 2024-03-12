package de.theunycraft.sfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CleanCodeMaker {

    public static void main(String[] args) {
        /*try (FileInputStream fileInputStream = new FileInputStream(file)) {
            char[] data = new char[(int) file.length()];
            for (int i = 0; i < file.length(); i++) {
                data[i] = (char) fileInputStream.read();
                if (Character.isDigit(data[i])) data[i] = ' ';
            }
            String string = new String(data);
            //check if it is a number at the first position of line
            *//*if (Character.isDigit(string.charAt(0))) {
                string = string.substring(1);
            }*//*
            System.out.println(string);

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        File file = new File("src/main/resources/test.txt");
        File out = new File("src/main/resources/out.txt");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            char[] data = new char[(int) file.length()];
            boolean clearNext = false;
            for (int i = 0; i < file.length(); i++) {
                data[i] = (char) fileInputStream.read();
                if (data[i] == '\n') data[i] = ' ';
                clearNext = true;
                if (clearNext) {
                    if (Character.isDigit(data[i])) data[i] = ' ';
                    clearNext = false;
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(out);
            fileOutputStream.write(new String(data).getBytes());
            fileOutputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
