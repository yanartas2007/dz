package _1_2_Homework;

public class LabUnits {
    public static LaboratoryItem findMaxBiohazardLevel(LaboratoryItem[] massive) {
        int maxbh = 0;
        LaboratoryItem maxli = null;
        for (LaboratoryItem i: massive) {
            if (i != null) {
                if (i.getBiohazardLevel() > maxbh) {
                    maxbh = i.getBiohazardLevel();
                    maxli = i;
                }
            }
        }
        return maxli;
    }

    public static void shuffle(Object[] massive) {
        int length = 0;
        for (Object i: massive) {
            length += 1;
        }
        double[] rmassive = new double[length];
        for (int i = 0; i < length; i++) {
            rmassive[i] = Math.random();
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (rmassive[j] > rmassive[j + 1]) {
                    double n = rmassive[j];
                    rmassive[j] = rmassive[i];
                    rmassive[i] = n;

                    Object n1 = massive[j];
                    massive[j] = massive[i];
                    massive[i] = n1;
                }
            }
        }

    }

    public static boolean checkResearchHubs(ResearchHub<?> r1, ResearchHub<?> r2) {
        return r1.getStorage().getClass().isInstance(r2.getStorage());
    }

    public static void about(LaboratoryItem[] massive) {
        for (LaboratoryItem i: massive) {
            if (i != null) {
            System.out.println(i.getClass() + " ID: " + i.getSessionId() + "| Имя: " + i.getSerialNumber());
        }}
    }
}
