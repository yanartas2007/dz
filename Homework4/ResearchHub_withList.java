package Homework4;

import _1_2_Homework.LaboratoryItem;
import _1_2_Homework.ResearchSample;

public class ResearchHub_withList<S extends LaboratoryItem> {
    private MyArrayList<S> storage;
    private int count;

    // есть ощущение, что это god object

    public ResearchHub_withList(MyArrayList<S> storage, int count) {
        setStorage(storage);
        setCount(count);
        update();
    }


    public void register(S item) {
        update();
        for (int i = 0; i < count; i++) {
            if (storage.getMassive()[i] == null) {
                storage.set(i, item);
                break;
            }
        }

    }

    public S release(int index) {
        S ans = null;
        try {
            S[] storage1 = getStorage().getMassive();
            ans = storage1[index];
            storage1[index] = null;
            storage.setMassive(storage1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("неверный индекс ");
            System.out.println(index);
        }
        return ans;
    }

    private void update() { // проверяет на заполненность и если заполнено, увеличивает storage
        for (int i = 0; i < getCount(); i++) {
            if (getStorage().getMassive()[i] == null) {
                return;
            }
        }
        int oldCount = getCount();
        setCount(getCount() * 2);
        S[] newStorage = (S[]) new LaboratoryItem[getCount()];
        for (int i = 0; i < oldCount; i++) {
            newStorage[i] = getStorage().getMassive()[i];
        }
        storage.setMassive(newStorage);
        update();
    }

    public int indexOf(S item) {
        for (int i = 0; i < count; i++) {
            if (storage.getMassive()[i] == item) {
                return i;
            }
        }
        System.out.println("ничкго не нашлось");
        return -1;
    }

    public void clearByHazardLevel(int limit) {
        for (S i: getStorage().getMassive()) {
            if (i != null) {
                if (i.getBiohazardLevel() > limit) {
                    release(indexOf(i));
                }
            }
        }
    }

    public void adjustRurity(Number offset, Number multipler) {
        for (S i: getStorage().getMassive()) {
            if (i instanceof ResearchSample) {
                ((ResearchSample<?>) i).setPurity((((ResearchSample) i).getPurity().doubleValue() + offset.doubleValue()) * multipler.doubleValue());
            }
        }
    }

    public double getAveragePurity() {
        double ans = 0;
        int count = 0;
        for (S i: getStorage().getMassive()) {
            if (i instanceof ResearchSample) {
                count++;
                ans += ((ResearchSample<?>) i).getPurity().doubleValue();
            }
        }
        return ans / (count != 0 ? count : 1);
    }


    public MyArrayList<S> getStorage() {
        return storage;
    }

    public void setStorage(MyArrayList<S> storage) {
        this.storage = storage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean checkSession(S item, Integer sessionId) {
        return item.getSessionId() == sessionId;
    }
}
