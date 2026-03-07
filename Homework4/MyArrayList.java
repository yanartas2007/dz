package Homework4;

public class MyArrayList<T>{
    private T[] massive;
    private int size;
    private int capacity;

    public void set(int index, T item) {
        massive[index] = item;
    }


    public MyArrayList() {
        setMassive((T[]) new Object[10]);
        setCapacity(10);
        setSize(0);
        updateSize();
    }

    public void add(T elem) {
        massive[size] = elem;
        size++;
        updateSize();
    }

    public int size() {
        return getSize();
    }

    public void clear() {
        setMassive((T[]) new Object[10]);
        setCapacity(10);
        setSize(0);
        updateSize();
    }

    public boolean isEmpty() {
        return getMassive()[0] == null;
    }

    public void add(int index, T elem) {
        T[] massive2 = (T[]) new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            massive2[i] = getMassive()[i];
        }
        massive2[index] = elem;
        for (int i = index; i < capacity; i++) {
            massive2[i] = getMassive()[i - 1];
        }
        setMassive(massive2);
    }

    public T remove(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("ты что творишь???");
        }
        T[] massive2 = (T[]) new Object[capacity];
        T ans = massive[index];
        for (int i = 0; i < capacity; i++) {
            massive2[i] = getMassive()[i];
        }
        for (int i = index; i < capacity; i++) {
            massive2[i - 1] = getMassive()[i];
        }
        massive2[capacity] = null;
        setMassive(massive2);
        return ans;
    }

    public boolean remove(T item) {
        if (indexOf(item) == -1) {
            return false;
        }
        remove(indexOf(item));
        return true;
    }

    public int indexOf(T item) {
        for (int i = 0; i < capacity; i++) {
            if (massive[i] == null) {break;}
            if (massive[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    public T get(int index) {
        return getMassive()[index];
    }

    public T[] getMassive() {
        return massive;
    }

    public void setMassive(T[] massive) {
        this.massive = massive;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        updateSize();
    }

    private void updateSize() {
        if (size == capacity) {
            T[] massive2 = (T[]) new Object[capacity * 10 / 2];
            for (int i = 0; i < capacity; i++) {
                massive2[i] = getMassive()[i];
            }
            setMassive(massive);
            setCapacity(capacity * 10 / 2);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
