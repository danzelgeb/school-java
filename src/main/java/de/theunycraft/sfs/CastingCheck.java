package de.theunycraft.sfs;

public class CastingCheck {

    public static void main(String[] args) {
        String intString = "123";
        int i = Integer.parseInt(intString);
        System.out.println(i);

        //-----------------------
        System.out.println(" ");
        System.out.println(" ");
        //-----------------------

        String doubleString = "123.45";
        double d = Double.parseDouble(doubleString);
        double d2 = d + i;
        System.out.println(d2);

    }

}
