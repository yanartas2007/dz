package _4_2_Classwork;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<T> {
    private int capacity;
    private Queue<T> q;

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        q = new LinkedList<>();
    }

    public void put(T item){
        synchronized (q) {
            while (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            q.add(item);
            q.notifyAll();
        }
    }

    public T take(){
        synchronized (q) {
            while (q.size() == 0) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            T ret = q.remove();
            q.notifyAll();
            return ret;
        }
    }

    public int size() {
        synchronized (q) {
            return q.size();
        }
    }

    public void putAll(Collection<? extends T> items) {
        for (T i: items) {
                put(i);
        }
    }


}
