package Homework_KR_Task2.Task2;

public abstract class MusicInstrument {
    private String tonality;

    public MusicInstrument(String tonality) {
        setTonality(tonality);
    }

    public MusicInstrument() {
        this("Неизвестно");
    }

    public abstract void playMusic();

    public String getTonality() {
        return tonality;
    }

    public void setTonality(String tonality) {
        this.tonality = tonality;
    }
}
