package _1_3_Homework;

public class CustomsTerminal {
    public static void inspectCargo(CargoBay<?> c) {
        System.out.println(c.getMassive().getClass());
    }

    public static void loadHumanitarianApples(CargoBay<? super Fruit> c) {
        while (c.getSize() > 0) {
            c.add(new Fruit("яблоко"));
        }
    }

    public static void transferCargo(CargoBay<? extends Cargo> from, CargoBay<? extends Cargo> to) {
        for (Cargo i: from.getMassive()) {
            to.add(i);
        }
    }


}
