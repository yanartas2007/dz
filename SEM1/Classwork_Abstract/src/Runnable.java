package SEM1.Classwork_Abstract.src;

public interface Runnable {
    void run();

    default int getMaxSpeed() {
        return 10;
    }
}