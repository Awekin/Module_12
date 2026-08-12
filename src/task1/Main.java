package task1;

public class Main {
    static void main() {
        MyThread t = new MyThread();

        Thread thread1 = new Thread(() -> {
            try {
                t.countSeconds();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                t.everyFiveSeconds();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread1.start();
        thread2.start();
    }
}