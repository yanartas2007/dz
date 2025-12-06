package Homework_KR_Task2.Task1;

public class CookieManager {
    public static Cookie bakeCookie(String type, int arg1, int arg2) {
        Cookie ret;
        if (equals(type, "Соленая")) {ret = new SaltyCookie(arg1, arg2);}
        else if (equals(type, "Сладкая")) {ret = new SweetCookie(arg1, arg2);}
        else if (equals(type, "Ягодная")) {ret = new CookieWithBerries(arg1, arg2);}
        else if (equals(type, "Ореховая")) {ret = new CookieWithNuts(arg1, arg2);}
        else {ret = new SaltyCookie(arg1, arg2 * 100); System.out.print("Тип не распознан. Думаю, вы хотели дичайше солёную печеньку.");}
        ret.bake();
        return ret;
    }

    public static Cookie bakeCookie(String type) {
        return bakeCookie(type, 0, 0);
    }



    public static boolean equals(String a, String b) {
        if (a.length() != b.length())  {
            return false;
        }
        else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {return false;}
            }
        }
        return true;
    }
}
