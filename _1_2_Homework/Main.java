package _1_2_Homework;

import _1_1_Homework.Fraction;

public class Main {
    public static void main(String[] args) {
        System.out.println("!Тестирование");
        LaboratoryItem li1 = new LaboratoryItem("123", 1, 100);
        ResearchHub<LaboratoryItem> rh = new ResearchHub<>(new LaboratoryItem[2], 2);
        rh.register(li1);
        System.out.println(rh.checkSession(li1, 250)); // false, тк 100 не equals 250

        System.out.println("!1");
        ResearchSample<Double> rd = new ResearchSample<>("12", 10, 10, "уран", 10.1);
        ResearchHub<ResearchSample<Double>> rh1 = new ResearchHub<>(new ResearchSample[2], 2);
        rh1.register(rd);
        MedicalDevice md = new MedicalDevice("091911893649834", 10000, 1, "qqq", 1);
//        rh1.register(md); // тут ошибка компиляции, так как типы нельзя привести

        System.out.println("!2");
        ResearchHub<LaboratoryItem> rli = new ResearchHub<>(new LaboratoryItem[2], 2);
        rli.register(rd);
        rli.register(md);
        rli.register(li1);
        System.out.println(rli.getCount());
        rli.release(1);
        LabUnits.about(rli.getStorage());

        System.out.println("!3");
        ResearchSample<Double> rd1 = new ResearchSample<>("12", 10, 10, "уран", 0.5);
        ResearchSample<Integer> ri1 = new ResearchSample<>("12", 10, 10, "уран", 50);
        ResearchSample<Fraction> rf1 = new ResearchSample<>("12", 10, 10, "уран", new Fraction(1, 2));
        ResearchHub<ResearchSample<?>> rh2 = new ResearchHub<>(new ResearchSample[2], 2);
        rh2.register(rd1);
        rh2.register(ri1);
        rh2.register(rf1);
        rh2.adjustRurity(10, 0.5);
        System.out.println(rh2.getAveragePurity());
        // 0.5 + 50 + 1/2 = 51;      51 + 10 * 3 = 81;    81 * 0.5 = 40.5
        // сложностей не возникло

        System.out.println("!4");
        rd1.setSessionId(100);
        ri1.setSessionId(250);
        System.out.println(rh2.checkSession(rd1, 100));
        System.out.println(rh2.checkSession(ri1, 250));
        // результаты такие из за кэширования.

        System.out.println("!5");
        LaboratoryItem[] li3 = {new LaboratoryItem("1", 2, 1),
                new LaboratoryItem("1", 9, 1),
                new LaboratoryItem("1", 4, 1),
                new LaboratoryItem("1", 10, 1),
                new LaboratoryItem("1", 3, 1)};
        System.out.println(LabUnits.findMaxBiohazardLevel(li3));
        ResearchHub<LaboratoryItem> rh4 = new ResearchHub<>(li3, 5);
        rh4.clearByHazardLevel(5);
        LabUnits.about(rh4.getStorage());
        ResearchHub<MedicalDevice> rm  = new ResearchHub<>(new MedicalDevice[2], 2);
        System.out.println(LabUnits.checkResearchHubs(rm, rh4));
    }
}
