package SEM1.Homework_OOP_base.src;

public class Matrix2x2 {
    private double[][] massive;

    public Matrix2x2(double a, double b, double c, double d) {
        massive = new double[][]{{a, b}, {c, d}};
    }

    public Matrix2x2() {
        this(0,0,0,0);
    }

    public Matrix2x2(double a) {
        this(a,a,a,a);
    }

    public Matrix2x2(double[][] a) {
        setMassive(a);
    }

    public Matrix2x2 add(Matrix2x2 other) {
        Matrix2x2 m = new Matrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j] += other.massive[i][j];
            }
        }
        return m;
    }

    public void add2(Matrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j] += other.massive[i][j];
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 other) {
        Matrix2x2 m = new Matrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j] -= other.massive[i][j];
            }
        }
        return m;
    }

    public void sub2(Matrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j] -= other.massive[i][j];
            }
        }
    }

    public double[][] getMassive() {
        return massive;
    }

    public Matrix2x2 multNumber(double n) {
        Matrix2x2 m = new Matrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j] *= n;
            }
        }
        return m;
    }

    public void multNumber2(double n) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j] *= n;
            }
        }
    }

    public Matrix2x2 mult(Matrix2x2 other) {
        Matrix2x2 m = new Matrix2x2(getMassive());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.massive[i][j] *= other.massive[j][i];
            }
        }
        return m;
    }

    public void mult2(Matrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.massive[i][j] *= other.massive[j][i];
            }
        }
    }

    public double det() {
        return massive[0][0] * massive[1][1] - massive[0][1] * massive[1][0];
    }

    public void transpon() {
        setMassive(massive[0][0], massive[1][0], massive[0][1], massive[1][1]);
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 m = new Matrix2x2(massive[1][1], massive[1][0], massive[0][1], massive[0][0]);
        return m.multNumber(1/det()); // можно даже не вызывать ошибку при det = 0. Деление на 0 и так ее вызовет
    }

    public Matrix2x2 equivalentDiagonal() {
        return new Matrix2x2(SqrtFinder.koren(det()), 0, 0, SqrtFinder.koren(det()));
    }

    public Vector2D multVector(Vector2D vector) {
        double[] v = new double[]{vector.getA(), vector.getB()};
        double[] c = new double[]{0, 0};
        for (int i = 0; i < 2; i++) {
            c[i] = 0;
            for (int j = 0; j < 2; j++) {
                c[i] += massive[i][j]*v[j];
            }
        }
        return new Vector2D(c[0], c[1]);
    }

    public void setMassive(double[][] massive) {
        this.massive = massive;
    }

    public void setMassive(double a, double b, double c, double d) {
        massive = new double[][]{{a, b}, {c, d}};
    }
}
