package Homework_KR_Task2.Task2;

public class Violin extends StringInstrument{
    public Violin(String tonality, int stringQuantity) {
        super(tonality, stringQuantity);
    }

    public Violin() {
        this("Неизвестно", 1);
    }

    @Override
    public void playMusic() {
        System.out.println("🎻");
    }

    public void changeViolinBow() {
        System.out.println("Смычёк сменили");
    }
}
