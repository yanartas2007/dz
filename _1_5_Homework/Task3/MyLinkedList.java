package _1_5_Homework.Task3;

public class MyLinkedList<T> extends MyList<T> {
    protected Node<T> first;
    private int size;

    public MyLinkedList(T first) {
        setFirst(first);
        setSize(1);
    }

    public MyLinkedList() {
        setSize(0);
    }

    public int size() {
        return getSize();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        if (first == null) {
            setFirst(item);
        } else {
            Node<T> el = first;
            while (first.getNext() != null) {
                el = el.getNext();
            }
            el.setNext(new Node<>(item));
        }
        size++;
    }

    public void add(int index,T item) {
        if (index == 0) {
            Node<T> itemn = new Node<>(item);
            first.setLast(itemn);
            itemn.setNext(first);
            first = itemn;
            return;
        }
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("ты что творишь???");
        }
        int c = 0;
        Node<T> el = first;
        while (c < index - 1) {
            el = el.getNext();
            c++;
        }
        Node<T> newel = new Node<>(item);
        newel.setNext(el.getNext());
        el.setNext(newel);
    }

    public T remove(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("ты что творишь???");
        }
        int c = 0;
        Node<T> el = first;
        while (c < index - 2) {
            el = el.getNext();
            c++;
        }
        el.setNext(el.getNext().getNext());
        size--;
        return el.getA();
    }

    public boolean remove(T item) {
        int c = 0;
        Node<T> el = first;
        while (el.getNext() != item && el.getNext() != null) {
            c++;
            el = el.getNext();
        }
        if (el.getNext() == item) {
            c++;
            remove(c);
            return true;
        }
        return false;
    }

    public void clear() {
        setFirst(null);
    }

    public boolean contains(T item) {
        Node<T> el = first;
        while (el.getNext() != item && el.getNext() != null) {
            el = el.getNext();
        }
        return el.getNext() == item;
    }

    public int indexOf(T item) {
        int c = 0;
        Node<T> el = first;
        while (el.getNext() != item && el.getNext() != null) {
            c++;
            el = el.getNext();
        }
        if (el.getNext() == item) {
            c++;
            return c;
        }
        return -1;
    }



    public T get(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("ты что творишь???");
        }
        int c = 0;
        Node<T> el = first;
        while (c < index - 1) {
            el = el.getNext();
            c++;
        }
        return el.getA();
    }



    public T getFirst() {
        return first.getA();
    }

    public void setFirst(T first) {
        this.first = new Node<>(first);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


