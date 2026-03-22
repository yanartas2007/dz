package _1_3_Homework;

import Homework4.CargoBay_withList;

public class CustomsTerminal {
    public static void inspectCargo(CargoBay_withList<?> c) {
        System.out.println(c.getMassive().getClass());
    }

    public static void loadHumanitarianApples(CargoBay_withList<? super Fruit> c) {
        while (c.getSize() > 0) {
            c.add(new Fruit("яблоко"));
        }
    }

    public static void transferCargo(CargoBay_withList<? extends Cargo> from, CargoBay_withList<? extends Cargo> to) {
//        for (Cargo i: from.getMassive()) {
//            to.add(i);
//        }
    }


}
