package Homework_OOP_base.src;

public class RationalFraction {
    private int a; // числитель
    private int b; // знаменатель



    public RationalFraction(int a, int b) {
        setA(a);
        setB(b);
        reduce();
    }

    public RationalFraction() {
        this(0, 1);
    }


    public void reduce() {
        while (true) {
            boolean flag = false;
            for (int i = 2; i < (a < b ? a : b); i++) {
                 if (a % i == 0 && b % i == 0) {
                     a = a / i;
                     b = b / i;
                     flag = true;
                     break;
                 }
            }
            if (!flag) {break;}
        }
    }

    public RationalFraction add(RationalFraction other) {
        return new RationalFraction(getA() * other.getB() + other.getA() * getB(), getB() * other.getB());
    }

    public void add2(RationalFraction other) {
        setA(getA() * other.getB() + other.getA() * getB());
        setB(getB() * other.getB());
        reduce();
    }

    public RationalFraction sub(RationalFraction other) {
        return new RationalFraction(getA() * other.getB() - other.getA() * getB(), getB() * other.getB());
    }

    public void sub2(RationalFraction other) {
        setA(getA() * other.getB() - other.getA() * getB());
        setB(getB() * other.getB());
        reduce();
    }

    public RationalFraction mult(RationalFraction other) {
        return new RationalFraction(getA() * other.getA(), getB() * other.getB());
    }

    public void mult2(RationalFraction other) {
        setA(getA() * other.getA());
        setB(getB() * other.getB());
        reduce();
    }

    public RationalFraction div(RationalFraction other) {
        return new RationalFraction(getA() * other.getB(), getB() * other.getA());
    }

    public void div2(RationalFraction other) {
        setA(getA() * other.getB());
        setB(getB() * other.getA());
        reduce();
    }

    public double value() {
        return ((double) getA()) /((double) getB());
    }

    public String toString() {
        return getA() + "/" + getB();
    }

    public boolean equals(RationalFraction other) {
        return getA() == other.getA() && getB() == other.getB();
    }

    public int numberPart() {
        return getA() / getB();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
        reduce();
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
        reduce();
    }
}
