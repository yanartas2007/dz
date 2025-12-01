package ООП_не_base_504;

import Homework_OOP_base.src.*;

public class RationalMatrix2x2 {
    private RationalFraction[][] massive;

    public RationalMatrix2x2(RationalFraction a, RationalFraction b, RationalFraction c, RationalFraction d) {
        massive = new RationalFraction[][]{{a, b}, {c, d}};
    }

    public RationalMatrix2x2() {
        this(new RationalFraction(), new RationalFraction(), new RationalFraction(), new RationalFraction());
    }

    public RationalMatrix2x2(RationalFraction a) {
        this(a,a,a,a);
    }

    public RationalMatrix2x2(RationalFraction[][] a) {
        setMassive(a);
    }

    public RationalMatrix2x2 add(RationalMatrix2x2 other) {
        RationalMatrix2x2 m = new RationalMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].add2(other.massive[i][j]);
            }
        }
        return m;
    }

    public void add2(RationalMatrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].add2(other.massive[i][j]);
            }
        }
    }

    public RationalMatrix2x2 sub(RationalMatrix2x2 other) {
        RationalMatrix2x2 m = new RationalMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].sub2(other.massive[i][j]);
            }
        }
        return m;
    }

    public void sub2(RationalMatrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].sub2(other.massive[i][j]);
            }
        }
    }

    public RationalFraction[][] getMassive() {
        return massive;
    }

    public RationalMatrix2x2 multNumber(RationalFraction n) {
        RationalMatrix2x2 m = new RationalMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].mult(n);
            }
        }
        return m;
    }

    public void multNumber2(RationalFraction n) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].mult2(n);
            }
        }
    }

    public RationalMatrix2x2 mult(RationalMatrix2x2 other) {
        RationalMatrix2x2 m = new RationalMatrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j].mult2(other.massive[j][i]);
            }
        }
        return m;
    }

    public void mult2(RationalMatrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j].mult2(other.massive[j][i]);
            }
        }
    }

    public RationalFraction det() {
        return massive[0][0].mult(massive[1][1]).sub(massive[0][1].mult(massive[1][0]));
    }

    public void transpon() {
        setMassive(massive[0][0], massive[1][0], massive[0][1], massive[1][1]);
    }

    public RationalMatrix2x2 inverseMatrix() { // вот этим лучше не пользоваться, здесь костыль, тк дробь поодерживает только int, но не float. отклонение +-0.000001
        RationalMatrix2x2 m = new RationalMatrix2x2(massive[1][1], massive[1][0], massive[0][1], massive[0][0]);
        return m.multNumber(new RationalFraction(((int) (1/det().value()) * 1000000), 1 / 1000000)); // можно даже не вызывать ошибку при det = 0. Деление на 0 и так ее вызовет
    }

    public Matrix2x2 equivalentDiagonal() {
        return new Matrix2x2(SqrtFinder.koren(det().value()), 0, 0, SqrtFinder.koren(det().value()));
    }

    public Vector2D multVector(Vector2D vector) {
        RationalFraction[] v = new RationalFraction[]{new RationalFraction((int) vector.getA(), 0), new RationalFraction((int) vector.getB(), 1)};
        RationalFraction[] c = new RationalFraction[]{new RationalFraction(), new RationalFraction()};
        for (int i = 0; i < 2; i++) {
            c[i] = new RationalFraction();
            for (int j = 0; j < 2; j++) {
                c[i].add2(massive[i][j].mult(v[j]));
            }
        }
        return new Vector2D(c[0].value(), c[1].value());
    }

    public void setMassive(RationalFraction[][] massive) {
        this.massive = massive;
    }

    public void setMassive(RationalFraction a, RationalFraction b, RationalFraction c, RationalFraction d) {
        massive = new RationalFraction[][]{{a, b}, {c, d}};
    }

}
