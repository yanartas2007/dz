package Homework_KR_Task2.Task2;

public class DoubleBass extends StringInstrument{
    private int size;

    public DoubleBass(String tonality, int stringQuantity, int size) {
        super(tonality, stringQuantity);
        setSize(size);
    }

    public DoubleBass() {
        this("Неизвестно", 1, 100);
    }

    @Override
    public void playMusic() {
        System.out.println("🎻");
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
