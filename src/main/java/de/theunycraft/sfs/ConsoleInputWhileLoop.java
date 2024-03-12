package de.theunycraft.sfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleInputWhileLoop {

    public static void main(String[] args) {
        Command.register();
        Scanner scanner = new Scanner(System.in);
        String line;
        while ((line = scanner.nextLine()) != null) {
            System.out.println("You typed in: " + line);

            String[] split = line.split(" ");
            String command = split[0];
            String[] arguments = new String[split.length - 1];
            System.arraycopy(split, 1, arguments, 0, split.length - 1);

            if (Command.commands.containsKey(command)) {
                Command.commands.get(command).execute(arguments);
            } else {
                System.out.println("Command not found!");
            }
        }
    }

    public static abstract class Command {
        private static Map<String, Command> commands = new HashMap<>();

        public static void register() {
            registerCommand("test", new TestCommand());
            registerCommand("help", new HelpCommand());
            registerCommand("russianroulette", new RussianRoulette());
            registerCommand("rr", new RussianRoulette());
        }

        public abstract void execute(String[] args);

        public static void registerCommand(String name, Command command) {
            commands.put(name, command);
        }
    }

    public static class TestCommand extends Command {
        @Override
        public void execute(String[] args) {
            System.out.println("TestCommand executed!");

        }
    }

    public static class HelpCommand extends Command {
        @Override
        public void execute(String[] args) {
            System.out.println("HelpCommand executed!");
        }
    }

    public static class RussianRoulette extends Command {
        @Override
        public void execute(String[] args) {
            System.out.println("RussianRoulette started!");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            de.theunycraft.sfs.RussianRoulette.main(args);
        }
    }

}
