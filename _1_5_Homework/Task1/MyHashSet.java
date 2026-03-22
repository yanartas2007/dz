package _1_5_Homework.Task1;

public class MyHashSet<E>{
    private static final Object PRESENT = new Object();
    private MyHashMap<E, Object> map;

    public MyHashSet() {
        this.map = new MyHashMap<>();
    }


    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    public boolean remove(Object o) {
        if (map.containsKey((E) o)) {
            map.remove((E) o);
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        return map.containsKey((E) o);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void clear() {
        map.clear();
    }
}
