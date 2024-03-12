package de.theunycraft.sfs;

public class TestInterfaceMain {

    public static void main(String[] args) {
        ITestInterface test = new Test();
        test.testMethod();

        System.out.println(test.getRandomInt());
        System.out.println(test.getRandomString(10));

    }

}
