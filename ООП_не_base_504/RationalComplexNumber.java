package ООП_не_base_504;

import Homework_OOP_base.src.RationalFraction;
import Homework_OOP_base.src.SqrtFinder;

public class RationalComplexNumber {
    private RationalFraction a; // действительная часть
    private RationalFraction b; // мнимая часть

    public RationalComplexNumber(RationalFraction a, RationalFraction b) {
        setA(a);
        setB(b);
    }

    public RationalComplexNumber() {
        this(new RationalFraction(), new RationalFraction());
    }

    public RationalComplexNumber add(RationalComplexNumber other) {
        return new RationalComplexNumber(getA().add(other.getA()), getB().add(other.getB()));
    }

    public void add2(RationalComplexNumber other) {
        setA(getA().add(other.getA()));
        setB(getB().add(other.getB()));
    }

    public RationalComplexNumber sub(RationalComplexNumber other) {
        return new RationalComplexNumber(getA().sub(other.getA()), getB().sub(other.getB()));
    }

    public void sub2(RationalComplexNumber other) {
        setA(getA().sub(other.getA()));
        setB(getB().sub(other.getB()));
    }

    public RationalComplexNumber mult(RationalComplexNumber other) {
        return new RationalComplexNumber(getA().mult(other.getA()).sub( getB().mult(other.getB())), getB().mult(other.getA()).add(getA().mult(other.getB())));
    }

    public void mult2(RationalComplexNumber other) {
        setA(getA().mult(other.getA()).sub(getB().mult(other.getB())));
        setB(getB().mult(other.getA()).add(getA().mult(other.getB())));
    }

    public RationalComplexNumber multNumber(double c) {
        return mult(new RationalComplexNumber(new RationalFraction((int) c * 1000000, 1/1000000), new RationalFraction()));
    }

    public void multNumber2(RationalFraction c) {
        RationalComplexNumber n = mult(new RationalComplexNumber(c, new RationalFraction()));
        setA(n.getA());
        setB(n.getB());
    }

    public RationalComplexNumber div(RationalComplexNumber other) {
        RationalFraction a, b, c, d;
        a = getA();
        b = getB();
        c = other.getA();
        d = other.getB();
        return new RationalComplexNumber((a.mult(c).add(b.mult(d))).div(c.mult(c).add(d.mult(d))), (b.mult(c).sub(a.mult(d))).div(c.mult(c).add(d.mult(d))));
    }

    public void div2(RationalComplexNumber other) {
        RationalComplexNumber n = div(other);
        setA(n.getA());
        setB(n.getB());
    }

    public double length() {
        return SqrtFinder.koren(getA().mult(getA()).add(getB().mult(getB())).value());
    }

    public String toString() {
        if (getA().getA() == 0) {
            if (getB().getA() != 0) {
                return getB() + "i";} else return "0";
        }
        else {
            if (getB().getA() != 0) {
                return getA() + (getB().getA() > 0 ? " + " + getB() + "i" : getB() + "i");}
            else {return "0";}
        }
    }

    public double arg() {
        if (getA().getA() >= 0) {
            return Math.atan(getB().value() / getA().value());
        }
        else {
            if (getB().getA() <= 0) {return 180 + Math.atan(getB().value() / getA().value());}
            else {return -180 + Math.atan(getB().value() / getA().value());}
        }
    }

    public RationalComplexNumber pow(double n) {
        RationalComplexNumber c = new RationalComplexNumber(new RationalFraction((int) Math.cos(arg()) * 1000000,1 / 1000000), new RationalFraction((int) Math.sin(arg()) * 1000000,1 / 1000000));
        return c.multNumber(Math.pow(length(), n));
    }

    public boolean equals(RationalComplexNumber other) {
        return (getA() == other.getA() && getB() == other.getB());
    }

    public RationalFraction getA() {
        return a;
    }

    public void setA(RationalFraction a) {
        this.a = a;
    }

    public RationalFraction getB() {
        return b;
    }

    public void setB(RationalFraction b) {
        this.b = b;
    }
}