package de.theunycraft.sfs;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DelFirstChar {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader reader = new FileReader(new File("src/main/resources/test.txt"))) {
            int data = reader.read();
            while (data != -1) {
                stringBuilder.append((char) data);
                data = reader.read();
            }

            System.out.println(stringBuilder.toString());
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

            String replaced = "error";
            ArrayList<String> ints = new ArrayList<>();
            for (int i = 1; i < 30; i++) {
//                System.out.println("replace " + i);
//                replaced = stringBuilder.toString().replaceAll(i + " ", "");
                ints.add(String.valueOf(i));
            }

            for (String i : ints) {
                System.out.println("replace " + i);
                replaced = stringBuilder.toString().replace(i + " ", " ");
            }

            System.out.println(replaced);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
