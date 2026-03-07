package Homework4;

import _1_3_Homework.Cargo;

public class CargoBay_withList<T extends Cargo> {
    private MyArrayList<T> massive;

    public CargoBay_withList(MyArrayList<T> massive) {
        setMassive(massive);
    }

    public void add(Cargo item) { // если заполнен, ничего не произойдет
        for (int i = 0; i < massive.size(); i++) {
            T[] newmassive = getMassive().getMassive();
            if (newmassive[i] == null) {
                newmassive[i] = (T) item;
                break;
            }
        }
    }

    public T get(int index) {
        return getMassive().getMassive()[index];
    }

    public T[] getAll() {
        return getMassive().getMassive();
    }

    public int getSize() {
        for (int i = 0; i < massive.size(); i++) {
            T[] newmassive = getMassive().getMassive();
            if (newmassive[i] == null) {
                return i;
            }
        }
        return getMassive().size();
    }

    public MyArrayList<T> getMassive() {
        return massive;
    }

    public void setMassive(MyArrayList<T> massive) {
        this.massive = massive;
    }
}
