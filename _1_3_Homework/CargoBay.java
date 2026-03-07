package _1_3_Homework;

import SEM1.Classwork_Task_6_ООП.Car;

public class CargoBay<T extends Cargo> {
    private T[] massive;

    public CargoBay(T[] massive) {
        setMassive(massive);
    }

    public CargoBay(int size) {
        setMassive((T[]) new Cargo[size]);
    }

    public void add(Cargo item) { // если заполнен, ничего не произойдет
        for (int i = 0; i < massive.length; i++) {
            T[] newmassive = getMassive();
            if (newmassive[i] == null) {
                newmassive[i] = (T) item;
                break;
            }
        }
    }

    public T get(int index) {
        return getMassive()[index];
    }

    public T[] getAll() {
        return getMassive();
    }

    public int getSize() {
        for (int i = 0; i < massive.length; i++) {
            T[] newmassive = getMassive();
            if (newmassive[i] == null) {
                return i;
            }
        }
        return getMassive().length;
    }

    public T[] getMassive() {
        return massive;
    }

    public void setMassive(T[] massive) {
        this.massive = massive;
    }
}
