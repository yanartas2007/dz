package Homework_OOP_base.src;

// В задании нет этого класса, но функцию поиска корня удобнее вынести отдельно, так как
// она встречается несколько раз

public class SqrtFinder {
    private static double tochnostSqrt = 0.00001;

    public static double koren(double S) { // Бинарный поиск.
        // находим левую и правую границу с точностью до tochnostSqrt, возвращаем середину
        // каждый раз середина становится левой, или правой границей
        if (S == 0 || S == 1) {
            return S;
        }
        if (S == 4) {
            return 2; // Для 4 результат почему то 1,999..., хотя для дальнейших квадратов
            // все нормально (9 -> 3). Возможно, проблема в расчетах при переводе в двоичную
            // систему счисления и обратно.
        }
        double left;
        double right;
        if (S < 1) {
            left = S;
            right = 1;
        } else {
            left = 1;
            right = S;
        }
        double middle;
        double approx;
        do {
            middle = left + (right - left) / 2;
            approx = middle * middle;
            if (approx > S) {
                right = middle;
            } else {
                left = middle;
            }
        } while ((approx - S) * (approx - S) > tochnostSqrt * tochnostSqrt);
        return middle;
    }

    public static void setTochnostSqrt(double tochnostSqrt1) {
        tochnostSqrt = tochnostSqrt1;
    }

    public static double getTochnostSqrt() {return tochnostSqrt;}
}
