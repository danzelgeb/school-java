package de.theunycraft.sfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Minesweeper {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int mines = random.nextInt(1, 3);
        Map<String, Mine> minePositions = new HashMap<>();
        for (int i = 0; i < mines; i++) {
            int raw = random.nextInt(10);
            int line = random.nextInt(10);
            Mine mine = new Mine(line, raw);
            String name = "mine-" + i;
        }
        AtomicBoolean noMine = new AtomicBoolean(true);
        while (noMine.get()) {
            System.out.println("Type in a line...");
            int line = scanner.nextInt();
            System.out.println("Type in a raw...");
            int raw = scanner.nextInt();
            Mine target = new Mine(line, raw);
            minePositions.forEach((key, value) -> {
                if (value.equals(target)) {
                    System.out.println("You hit a mine!");
                    noMine.set(false);
                    System.exit(0);
                } else {
                    System.out.println("NO MINE");
                }
            });
        }
    }

}
