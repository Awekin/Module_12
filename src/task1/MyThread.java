package task1;

public class MyThread {
    int sec = 0;

    public void countSeconds() throws InterruptedException {
        while (true) {
            System.out.println("Пройшло: " + sec + " cек.");
            sec++;
            Thread.sleep(1000);
        }
    }

    public void everyFiveSeconds() throws InterruptedException {
        while (true) {
            Thread.sleep(5000);
            System.out.println("! Пройшло 5 cекунд !");
        }
    }
}