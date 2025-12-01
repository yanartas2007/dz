package ООП_не_base_504;

import Homework_OOP_base.src.*;

public class RationalComplexMatrix2x2 {
    private RationalComplexNumber[][] massive;

    public RationalComplexMatrix2x2(RationalComplexNumber a, RationalComplexNumber b, RationalComplexNumber c, RationalComplexNumber d) {
        massive = new RationalComplexNumber[][]{{a, b}, {c, d}};
    }

    public RationalComplexMatrix2x2() {
        this(new RationalComplexNumber(), new RationalComplexNumber(), new RationalComplexNumber(), new RationalComplexNumber());
    }

    public RationalComplexMatrix2x2(RationalComplexNumber a) {
        this(a,a,a,a);
    }

    public RationalComplexMatrix2x2(RationalComplexNumber[][] a) {
        setMassive(a);
    }

    public RationalComplexMatrix2x2 add(RationalComplexMatrix2x2 other) {
        RationalComplexMatrix2x2 m = new RationalComplexMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].add2(other.massive[i][j]);
            }
        }
        return m;
    }

    public void add2(RationalComplexMatrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].add2(other.massive[i][j]);
            }
        }
    }

    public RationalComplexMatrix2x2 sub(RationalComplexMatrix2x2 other) {
        RationalComplexMatrix2x2 m = new RationalComplexMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].sub2(other.massive[i][j]);
            }
        }
        return m;
    }

    public void sub2(RationalComplexMatrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].sub2(other.massive[i][j]);
            }
        }
    }

    public RationalComplexNumber[][] getMassive() {
        return massive;
    }

    public RationalComplexMatrix2x2 multNumber(RationalComplexNumber n) {
        RationalComplexMatrix2x2 m = new RationalComplexMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].mult(n);
            }
        }
        return m;
    }

    public void multNumber2(RationalComplexNumber n) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].mult2(n);
            }
        }
    }

    public RationalComplexMatrix2x2 mult(RationalComplexMatrix2x2 other) {
        RationalComplexMatrix2x2 m = new RationalComplexMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].mult2(other.massive[j][i]);
            }
        }
        return m;
    }

    public void mult2(RationalComplexMatrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].mult2(other.massive[j][i]);
            }
        }
    }

    public RationalComplexNumber det() {
        return massive[0][0].mult(massive[1][1]).sub(massive[0][1].mult(massive[1][0]));
    }

    public void transpon() {
        setMassive(massive[0][0], massive[1][0], massive[0][1], massive[1][1]);
    }

    public RationalComplexMatrix2x2 inverseMatrix() { // вот этим лучше не пользоваться, здесь костыль, тк дробь поодерживает только int, но не float. отклонение +-0.000001
        RationalComplexMatrix2x2 m = new RationalComplexMatrix2x2(massive[1][1], massive[1][0], massive[0][1], massive[0][0]);
        return m.multNumber(new RationalComplexNumber((new RationalFraction((int) (1/det().length()) * 1000000, 1)), new RationalFraction(1 / 1000000, 1))); // можно даже не вызывать ошибку при det = 0. Деление на 0 и так ее вызовет
    }

    public Matrix2x2 equivalentDiagonal() {
        return new Matrix2x2(SqrtFinder.koren(det().length()), 0, 0, SqrtFinder.koren(det().length()));
    }

    public RationalComplexVector2D multVector(RationalComplexVector2D vector) {
        RationalComplexNumber[] v = new RationalComplexNumber[]{new RationalComplexNumber(new RationalFraction((int) vector.getA().getA().getA(), 1), new RationalFraction()), new RationalComplexNumber(new RationalFraction((int) vector.getB().getA().getA(), 1), new RationalFraction(1, 1))};
        RationalComplexNumber[] c = new RationalComplexNumber[]{new RationalComplexNumber(), new RationalComplexNumber()};
        for (int i = 0; i < 2; i++) {
            c[i] = new RationalComplexNumber();
            for (int j = 0; j < 2; j++) {
                c[i].add2(massive[i][j].mult(v[j]));
            }
        }
        return new RationalComplexVector2D(c[0], c[1]);
    }

    public void setMassive(RationalComplexNumber[][] massive) {
        this.massive = massive;
    }

    public void setMassive(RationalComplexNumber a, RationalComplexNumber b, RationalComplexNumber c, RationalComplexNumber d) {
        massive = new RationalComplexNumber[][]{{a, b}, {c, d}};
    }

}
