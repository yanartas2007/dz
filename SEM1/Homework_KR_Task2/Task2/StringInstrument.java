package SEM1.Homework_KR_Task2.Task2;

public abstract class StringInstrument extends MusicInstrument{
    private int stringQuantity;

    public StringInstrument(String tonality, int stringQuantity) {
        super(tonality);
        setStringQuantity(stringQuantity);
    }

    public StringInstrument() {
        this("Неизвестно", 1);
    }

    public int getStringQuantity() {
        return stringQuantity;
    }

    public void setStringQuantity(int stringQuantity) {
        this.stringQuantity = stringQuantity;
    }
}
