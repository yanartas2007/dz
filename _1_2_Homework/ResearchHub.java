package _1_2_Homework;

import java.util.Objects;

public class ResearchHub<S extends LaboratoryItem> {
    private S[] storage;
    private int count;

    // есть ощущение, что это god object

    public ResearchHub(S[] storage, int count) {
        setStorage(storage);
        setCount(count);
        update();
    }


    public void register(S item) {
        update();
        for (int i = 0; i < count; i++) {
            if (storage[i] == null) {
                storage[i] = item;
                break;
            }
        }

    }

    public S release(int index) {
        S ans = null;
        try {
            S[] storage1 = getStorage();
            ans = storage1[index];
            storage1[index] = null;
            setStorage(storage1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("неверный индекс ");
            System.out.println(index);
        }
        return ans;
    }

    private void update() { // проверяет на заполненность и если заполнено, увеличивает storage
        for (int i = 0; i < getCount(); i++) {
            if (getStorage()[i] == null) {
                return;
            }
        }
        int oldCount = getCount();
        setCount(getCount() * 2);
        S[] newStorage = (S[]) new LaboratoryItem[getCount()];
        for (int i = 0; i < oldCount; i++) {
            newStorage[i] = getStorage()[i];
        }
        setStorage(newStorage);
        update();
    }

    public int indexOf(S item) {
        for (int i = 0; i < count; i++) {
            if (storage[i] == item) {
                return i;
            }
        }
        System.out.println("ничкго не нашлось");
        return -1;
    }

    public void clearByHazardLevel(int limit) {
        for (S i: getStorage()) {
            if (i != null) {
                if (i.getBiohazardLevel() > limit) {
                    release(indexOf(i));
                }
            }
        }
    }

    public void adjustRurity(Number offset, Number multipler) {
        for (S i: getStorage()) {
            if (i instanceof ResearchSample) {
                ((ResearchSample<?>) i).setPurity((((ResearchSample) i).getPurity().doubleValue() + offset.doubleValue()) * multipler.doubleValue());
            }
        }
    }

    public double getAveragePurity() {
        double ans = 0;
        int count = 0;
        for (S i: getStorage()) {
            if (i instanceof ResearchSample) {
                count++;
                ans += ((ResearchSample<?>) i).getPurity().doubleValue();
            }
        }
        return ans / (count != 0 ? count : 1);
    }


    public S[] getStorage() {
        return storage;
    }

    public void setStorage(S[] storage) {
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
