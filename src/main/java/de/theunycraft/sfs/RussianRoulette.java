package de.theunycraft.sfs;

import java.util.Random;
import java.util.Scanner;

public class RussianRoulette {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type in how much Players: ");
        int players = scanner.nextInt();
        int bullet = random.nextInt(players);
        System.out.println("Press enter to shoot!");
        scanner.nextLine();
        for (int i = 0; i < players; i++) {
            System.out.println("Player " + i + " survived!");
            scanner.nextLine();
            if (i == bullet) {
                int player = i + 1;
                System.out.println("Player " + player + " is dead!");
                break;
            }
        }

    }

}