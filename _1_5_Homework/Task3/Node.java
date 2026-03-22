package _1_5_Homework.Task3;

class Node<T>{
    private T a;
    private Node<T> next;
    private Node<T> last;

    public Node(T a) {
        setA(a);
    }

    public Node(T a, Node<T> next) {
        setA(a);
        setNext(next);
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
        next.setLast(last);
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }
}