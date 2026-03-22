package _1_5_Homework.Task1;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private Node<K, V>[] buckets;
    private int size;
    private static int CAPACITY = 16;

    public MyHashMap() {
        buckets = (Node<K, V>[]) new Node[CAPACITY];
        size = 0;

    }

    private static final class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }


    @Override
    public boolean containsKey(K key) {
        Node<K, V> current = buckets[getBucketIndex(key)];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < CAPACITY; i++) {
            Node<K, V> current = buckets[i];
            while (buckets[i] != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public V put(K key, V value) {
        resize();
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
        return null;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> prev = null;
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = null;
        }
    }




    public void resize() {
        if (size != CAPACITY) {return;}
        int newCapacity = CAPACITY * 2;
        Node<K, V>[] newBuckets = (Node<K, V>[]) new Node[newCapacity];

        for (Node<K, V> head : buckets) {
            Node<K, V> current = head;
            while (current != null) {
                Node<K, V> next = current.next;
                int newIndex = Math.abs(current.key.hashCode() % newCapacity);
                current.next = newBuckets[newIndex];
                newBuckets[newIndex] = current;
                current = next;
            }
        }
        buckets = newBuckets;
        CAPACITY = newCapacity;

}}


