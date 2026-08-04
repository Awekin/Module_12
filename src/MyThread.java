public class MyThread {
    int sec = 0;

    Thread thread1 = new Thread(() -> {
        try {
            while (true) {

                System.out.println("Пройшло: " + sec + " cек.");
                sec++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    });

    Thread thread2 = new Thread(() -> {
        try {
            while (true) {

                Thread.sleep(5000);
                System.out.println("! Пройшло 5 cекунд !");

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    });

}

