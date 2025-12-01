package ООП_не_base_504;

import Homework_OOP_base.src.ComplexNumber;
import Homework_OOP_base.src.SqrtFinder;

public class ComplexVector2D {
    private ComplexNumber a;
    private ComplexNumber b;

    public ComplexVector2D() {
        this(new ComplexNumber(), new ComplexNumber());
    }

    public ComplexVector2D(ComplexNumber a, ComplexNumber b) {
        setA(a);
        setB(b);
    }

    public ComplexVector2D add(ComplexVector2D other) {
        return new ComplexVector2D(this.getA().add(other.getA()), this.getB().add(other.getB()));
    }

    public String toString() {
        return  a.toString() + " " + b.toString();
    }

    public double length() {
        return SqrtFinder.koren(a.mult(a).add(b.mult(b)).arg());
    }

    public ComplexNumber scalarProduct(ComplexVector2D other) {
        return getA().mult(other.getA()).add(getB().mult(other.getB()));
    }

    public boolean equals(ComplexVector2D other) {
        return (getA().equals(other.getA()) && getB().equals(other.getB()));
    }

    public ComplexNumber getA() {
        return a;
    }

    public void setA(ComplexNumber a) {
        this.a = a;
    }

    public ComplexNumber getB() {
        return b;
    }

    public void setB(ComplexNumber b) {
        this.b = b;
    }
}
