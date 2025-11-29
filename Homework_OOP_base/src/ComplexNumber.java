package Homework_OOP_base.src;

public class ComplexNumber {
    private double a; // действительная часть
    private double b; // мнимая часть

    public ComplexNumber(double a, double b) {
        setA(a);
        setB(b);
    }

    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(getA() + other.getA(), getB() + other.getB());
    }

    public void add2(ComplexNumber other) {
        setA(getA() + other.getA());
        setB(getB() + other.getB());
    }

    public ComplexNumber sub(ComplexNumber other) {
        return new ComplexNumber(getA() - other.getA(), getB() - other.getB());
    }

    public void sub2(ComplexNumber other) {
        setA(getA() - other.getA());
        setB(getB() - other.getB());
    }

    public ComplexNumber mult(ComplexNumber other) {
        return new ComplexNumber(getA() * other.getA() - getB() * other.getB(), getB() * other.getA() + getA() * other.getB());
    }

    public void mult2(ComplexNumber other) {
        setA(getA() * other.getA() - getB() * other.getB());
        setB(getB() * other.getA() + getA() * other.getB());
    }

    public ComplexNumber multNumber(double c) {
        return mult(new ComplexNumber(c, 0));
    }

    public void multNumber2(double c) {
        ComplexNumber n = mult(new ComplexNumber(c, 0));
        setA(n.getA());
        setB(n.getB());
    }

    public ComplexNumber div(ComplexNumber other) {
        double a, b, c, d;
        a = getA();
        b = getB();
        c = other.getA();
        d = other.getB();
        return new ComplexNumber((a * c + b * d) / (c * c + d * d), (b * c - a * d) / (c * c + d * d));
    }

    public void div2(ComplexNumber other) {
        ComplexNumber n = div(other);
        setA(n.getA());
        setB(n.getB());
    }

    public double length() {
        return SqrtFinder.koren(getA() * getA() + getB() * getB());
    }

    public String toString() {
        if (getA() == 0) {
            if (getB() != 0) {
            return getB() + "i";} else return "0";
        }
        else {
            if (getB() != 0) {
            return getA() + (getB() > 0 ? " + " + getB() + "i" : getB() + "i");}
            else {return "0";}
        }
    }

    public double arg() {
        if (getA() >= 0) {
            return Math.atan(getB() / getA());
        }
        else {
            if (getB() <= 0) {return 180 + Math.atan(getB() / getA());}
            else {return -180 + Math.atan(getB() / getA());}
        }
    }

    public ComplexNumber pow(double n) {
        ComplexNumber c = new ComplexNumber(Math.cos(arg()), Math.sin(arg()));
        return c.multNumber(Math.pow(length(), n));
    }

    public boolean equals(ComplexNumber other) {
        return (getA() == other.getA() && getB() == other.getB());
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
