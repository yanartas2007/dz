package Homework_OOP_base.src;

public class Vector2D {
    private double a;
    private double b;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(double a, double b) {
        setA(a);
        setB(b);
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(this.getA() + other.getA(), this.getB() + other.getB());
    }

    public double scalarProduct(Vector2D other) {
        return getA() * other.getA() + getB() * other.getB();
    }

    public double cos(Vector2D other) {
        return scalarProduct(other) / (length() + other.length());
    }

    public boolean equals(Vector2D other) {
        return (a == other.getA()) && (b == other.getB());
    }

    public String toString() {
        return  a + " " + b;
    }

    public double length() {
        return SqrtFinder.koren(a*a+b*b);
    }

    public void add2(Vector2D other) {
        a = this.getA() + other.getA();
        b = this.getB() + other.getB();
    }

    public Vector2D mult(double n) {
        return new Vector2D(this.getA() * n, this.getB() * n);
    }

    public void mult2(double n) {
        a = this.getA() * n;
        b = this.getB() * n;
    }

    public Vector2D sub(Vector2D other) {
        return new Vector2D(this.getA() - other.getA(), this.getB() - other.getB());
    }

    public void sub2(Vector2D other) {
        a = this.getA() - other.getA();
        b = this.getB() - other.getB();
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
