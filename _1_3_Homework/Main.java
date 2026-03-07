package _1_3_Homework;

import Homework4.CargoBay_withList;

public class Main {
    public static void main(String[] args) {
        // 1. Создаем отсеки
        CargoBay_withList<Phone> phoneBay = new CargoBay_withList<>(10);
        phoneBay.add(new Phone("iPhone 15"));
        phoneBay.add(new Phone("Samsung S24"));

        CargoBay_withList<Electronics> electronicsBay = new CargoBay_withList<>(10);
        CargoBay_withList<Cargo> generalCargoBay = new CargoBay_withList<>(20);
        CargoBay_withList<Food> foodBay = new CargoBay_withList<>(10);

        // ==========================================
        // ПРОВЕРКА 1: inspectCargo (Producer Extends)
        // ==========================================
        // Должно работать для любых типов, наследующих Cargo
        CustomsTerminal.inspectCargo(phoneBay);
        CustomsTerminal.inspectCargo(foodBay);

        // ==========================================
        // ПРОВЕРКА 2: loadHumanitarianApples (Consumer Super)
        // ==========================================
        // Мы можем положить фрукты в отсек для еды и в общий
//        отсек
        CustomsTerminal.loadHumanitarianApples(foodBay);
        CustomsTerminal.loadHumanitarianApples(generalCargoBay);

        // РАСКОММЕНТИРУЙТЕ СТРОКУ НИЖЕ — ОНА ДОЛЖНА ВЫДАВАТЬ
//        ОШИБКУ КОМПИЛЯЦИИ!

//                 CustomsTerminal.loadHumanitarianApples(electronicsBay);
// Ошибка: Электроника не может хранить яблоки

                // ==========================================
                // ПРОВЕРКА 3: transferCargo (PECS в чистом виде)
                // ==========================================
                // Перегружаем телефоны в отсек для электроники
                CustomsTerminal.transferCargo(phoneBay, electronicsBay);

        // Перегружаем ВСЮ электронику в общий грузовой отсек
        CustomsTerminal.transferCargo(electronicsBay,
                generalCargoBay);

        // РАСКОММЕНТИРУЙТЕ СТРОКУ НИЖЕ — ОНА ДОЛЖНА ВЫДАВАТЬ
//        ОШИБКУ КОМПИЛЯЦИИ!
//                 CustomsTerminal.transferCargo(foodBay, electronicsBay);
// Ошибка: Нельзя еду выгрузить к электронике

                System.out.println("Если код скомпилировался и вывел это сообщение — вы стали мастером Wildcards и PECS!");
    }
}