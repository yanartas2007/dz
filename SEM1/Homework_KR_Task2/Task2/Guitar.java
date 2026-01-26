package SEM1.Homework_KR_Task2.Task2;

public class Guitar extends StringInstrument{
    public Guitar(String tonality, int stringQuantity) {
        super(tonality, stringQuantity);
    }

    public Guitar() {
        this("Неизвестно", 1);
    }

    @Override
    public void playMusic() {
        System.out.println("🎸");
    }

    public void breakGuitar() {
        setStringQuantity(0);
        System.out.println("Гитара сломана");
    }
}
