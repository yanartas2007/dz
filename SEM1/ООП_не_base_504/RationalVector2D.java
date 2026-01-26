package SEM1.ООП_не_base_504;

import SEM1.Homework_OOP_base.src.RationalFraction;
import SEM1.Homework_OOP_base.src.SqrtFinder;

public class RationalVector2D {
    private RationalFraction a;
    private RationalFraction b;

    public RationalVector2D() {
        this(new RationalFraction(), new RationalFraction());
    }

    public RationalVector2D(RationalFraction a, RationalFraction b) {
        setA(a);
        setB(b);
    }

    public RationalVector2D add(RationalVector2D other) {
        return new RationalVector2D(this.getA().add(other.getA()), this.getB().add(other.getB()));
    }

    public String toString() {
        return  a.toString() + " " + b.toString();
    }

    public double length() {
        return SqrtFinder.koren(a.mult(a).add(b.mult(b)).value());
    }

    public RationalFraction scalarProduct(RationalVector2D other) {
        return getA().mult(other.getA()).add(getB().mult(other.getB()));
    }

    public boolean equals(RationalVector2D other) {
        return (getA().equals(other.getA()) && getB().equals(other.getB()));
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
