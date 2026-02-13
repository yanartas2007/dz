package _1_1_Homework;

import java.util.Objects;

public class Fraction extends Number {
    private int a; // числитель
    private int b; // знаменатель



    public Fraction(int a, int b) {
        try {
            setA(a);
            setB(b);
            reduce();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public int intValue() {
        return (int) value();
    }

    @Override
    public long longValue() {
        return (long) value();
    }

    @Override
    public float floatValue() {
        return (float) value();
    }

    @Override
    public double doubleValue() {
        return value();
    }

    public Fraction() {
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
        if (b < 0) {
            a = -a;
            b = -b;
        }
    }

    public Fraction add(Fraction other) {
        return new Fraction(getA() * other.getB() + other.getA() * getB(), getB() * other.getB());
    }

//    public void add2(Fraction other) {
//        setA(getA() * other.getB() + other.getA() * getB());
//        setB(getB() * other.getB());
//        reduce();
//    }

    public Fraction substract(Fraction other) {
        return new Fraction(getA() * other.getB() - other.getA() * getB(), getB() * other.getB());
    }

//    public void sub2(Fraction other) {
//        setA(getA() * other.getB() - other.getA() * getB());
//        setB(getB() * other.getB());
//        reduce();
//    }

    public Fraction multiple(Fraction other) {
        return new Fraction(getA() * other.getA(), getB() * other.getB());
    }

//    public void mult2(Fraction other) {
//        setA(getA() * other.getA());
//        setB(getB() * other.getB());
//        reduce();
//    }

    public Fraction divide(Fraction other) {
        try {
            if (other.getA() == 0) {
                throw new ArithmeticException();
            }
        }
        catch (ArithmeticException e) {
            System.out.println("Деление на 0. "); // вернется дробь со знаменателем 0, те IllegalArgumentException
        }
        return new Fraction(getA() * other.getB(), getB() * other.getA());
    }

//    public void div2(Fraction other) {
//        setA(getA() * other.getB());
//        setB(getB() * other.getA());
//        reduce();
//    }

    public double value() {
        return ((double) getA()) /((double) getB());
    }

    public Fraction negative() {
        return new Fraction(-getA(), -getB());
    }

    public boolean isProper() {
        if (getA() > 0) {
            return getA() > getB();
        }
        return -getA() > getB();
    }

    public String toString() {
        return getA() + "/" + getB();
    }

    public boolean equals(Fraction other) {
        return getA() == other.getA() && getB() == other.getB();
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
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
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        reduce();
    }
}
