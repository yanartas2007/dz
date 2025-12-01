package ООП_не_base_504;

import Homework_OOP_base.src.*;

public class ComplexMatrix2x2 {
    private ComplexNumber[][] massive;

    public ComplexMatrix2x2(ComplexNumber a, ComplexNumber b, ComplexNumber c, ComplexNumber d) {
        massive = new ComplexNumber[][]{{a, b}, {c, d}};
    }

    public ComplexMatrix2x2() {
        this(new ComplexNumber(), new ComplexNumber(), new ComplexNumber(), new ComplexNumber());
    }

    public ComplexMatrix2x2(ComplexNumber a) {
        this(a,a,a,a);
    }

    public ComplexMatrix2x2(ComplexNumber[][] a) {
        setMassive(a);
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 other) {
        ComplexMatrix2x2 m = new ComplexMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].add2(other.massive[i][j]);
            }
        }
        return m;
    }

    public void add2(ComplexMatrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].add2(other.massive[i][j]);
            }
        }
    }

    public ComplexMatrix2x2 sub(ComplexMatrix2x2 other) {
        ComplexMatrix2x2 m = new ComplexMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].sub2(other.massive[i][j]);
            }
        }
        return m;
    }

    public void sub2(ComplexMatrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].sub2(other.massive[i][j]);
            }
        }
    }

    public ComplexNumber[][] getMassive() {
        return massive;
    }

    public ComplexMatrix2x2 multNumber(ComplexNumber n) {
        ComplexMatrix2x2 m = new ComplexMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].mult(n);
            }
        }
        return m;
    }

    public void multNumber2(ComplexNumber n) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].mult2(n);
            }
        }
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 other) {
        ComplexMatrix2x2 m = new ComplexMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].mult2(other.massive[j][i]);
            }
        }
        return m;
    }

    public void mult2(ComplexMatrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].mult2(other.massive[j][i]);
            }
        }
    }

    public ComplexNumber det() {
        return massive[0][0].mult(massive[1][1]).sub(massive[0][1].mult(massive[1][0]));
    }

    public void transpon() {
        setMassive(massive[0][0], massive[1][0], massive[0][1], massive[1][1]);
    }

    public ComplexMatrix2x2 inverseMatrix() {
        ComplexMatrix2x2 m = new ComplexMatrix2x2(massive[1][1], massive[1][0], massive[0][1], massive[0][0]);
        return m.multNumber(new ComplexNumber(1/det().length(), 1)); // можно даже не вызывать ошибку при det = 0. Деление на 0 и так ее вызовет
    }

    public Matrix2x2 equivalentDiagonal() {
        return new Matrix2x2(SqrtFinder.koren(det().length()), 0, 0, SqrtFinder.koren(det().length()));
    }

    public Vector2D multVector(Vector2D vector) {
        ComplexNumber[] v = new ComplexNumber[]{new ComplexNumber((int) vector.getA(), 0), new ComplexNumber((int) vector.getB(), 1)};
        ComplexNumber[] c = new ComplexNumber[]{new ComplexNumber(), new ComplexNumber()};
        for (int i = 0; i < 2; i++) {
            c[i] = new ComplexNumber();
            for (int j = 0; j < 2; j++) {
                c[i].add2(massive[i][j].mult(v[j]));
            }
        }
        return new Vector2D(c[0].length(), c[1].length());
    }

    public void setMassive(ComplexNumber[][] massive) {
        this.massive = massive;
    }

    public void setMassive(ComplexNumber a, ComplexNumber b, ComplexNumber c, ComplexNumber d) {
        massive = new ComplexNumber[][]{{a, b}, {c, d}};
    }

}
