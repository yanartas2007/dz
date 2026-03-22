package _1_5_Homework.Task1;

public interface MyMap<K, V> {
    V put(K key, V value);
    V get(K key);
    V remove(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    int size();
    boolean isEmpty();
    void clear();

}