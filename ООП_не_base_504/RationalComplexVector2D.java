package ООП_не_base_504;

import Homework_OOP_base.src.SqrtFinder;

public class RationalComplexVector2D {
    private RationalComplexNumber a;
    private RationalComplexNumber b;

    public RationalComplexVector2D() {
        this(new RationalComplexNumber(), new RationalComplexNumber());
    }

    public RationalComplexVector2D(RationalComplexNumber a, RationalComplexNumber b) {
        setA(a);
        setB(b);
    }

    public RationalComplexVector2D add(RationalComplexVector2D other) {
        return new RationalComplexVector2D(this.getA().add(other.getA()), this.getB().add(other.getB()));
    }

    public String toString() {
        return  a.toString() + " " + b.toString();
    }

    public double length() {
        return SqrtFinder.koren(a.mult(a).add(b.mult(b)).arg());
    }

    public RationalComplexNumber scalarProduct(RationalComplexVector2D other) {
        return getA().mult(other.getA()).add(getB().mult(other.getB()));
    }

    public boolean equals(RationalComplexVector2D other) {
        return (getA().equals(other.getA()) && getB().equals(other.getB()));
    }

    public RationalComplexNumber getA() {
        return a;
    }

    public void setA(RationalComplexNumber a) {
        this.a = a;
    }

    public RationalComplexNumber getB() {
        return b;
    }

    public void setB(RationalComplexNumber b) {
        this.b = b;
    }
}