package SEM1.Homework_KR_Task2.Task2;

public class MusicInstrument {
    private String tonality;

    public MusicInstrument(String tonality) {
        setTonality(tonality);
    }

    public MusicInstrument() {
        this("Неизвестно");
    }

    public void playMusic() {
        System.out.println("трыньк");
    }

    public String getTonality() {
        return tonality;
    }

    public void setTonality(String tonality) {
        this.tonality = tonality;
    }
}
