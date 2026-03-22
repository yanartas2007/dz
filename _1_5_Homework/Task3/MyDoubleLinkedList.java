package _1_5_Homework.Task3;

public class MyDoubleLinkedList<T> extends MyLinkedList<T>{
    private Node<T> last;
    public MyDoubleLinkedList(T first) {
        super(first);
        setLast(last);
    }

    public T get(int index) {
        if (index > getSize() || index < 0) {
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

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }
}
