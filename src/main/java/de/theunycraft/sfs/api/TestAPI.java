package de.theunycraft.sfs.api;

public class TestAPI {

    public static void main(String[] args) {
        IAPI iapi = new APIImpl();
        System.out.println("getA");
        System.out.println(iapi.getA());

        System.out.println("getB");
        System.out.println(iapi.getB());

        System.out.println("getC");
        System.out.println(iapi.getC());
    }

}
