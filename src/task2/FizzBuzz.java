package task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {
    private final int n;
    private int number = 1;
    private int printed = 0;

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public FizzBuzz(int n) {
        this.n = n;
    }

    private boolean isFizz(int value) {
        return value % 3 == 0 && value % 5 != 0;
    }

    private boolean isBuzz(int value) {
        return value % 3 != 0 && value % 5 == 0;
    }

    private boolean isFizzBuzz(int value) {
        return value % 3 == 0 && value % 5 == 0;
    }

    private boolean isNumber(int value) {
        return value % 3 != 0 && value % 5 != 0;
    }

    public void fizz() throws InterruptedException {
        synchronized (this) {
            while (number <= n) {
                if (isFizz(number)) {
                    queue.put("fizz");
                    number++;
                    notifyAll();
                } else {
                    wait();
                }
            }
            notifyAll();
        }
    }

    public void buzz() throws InterruptedException {
        synchronized (this) {
            while (number <= n) {
                if (isBuzz(number)) {
                    queue.put("buzz");
                    number++;
                    notifyAll();
                } else {
                    wait();
                }
            }
            notifyAll();
        }
    }

    public void fizzbuzz() throws InterruptedException {
        synchronized (this) {
            while (number <= n) {
                if (isFizzBuzz(number)) {
                    queue.put("fizzbuzz");
                    number++;
                    notifyAll();
                } else {
                    wait();
                }
            }
            notifyAll();
        }
    }

    public void number() throws InterruptedException {
        while (printed < n) {
            synchronized (this) {
                while (number <= n && isNumber(number)) {
                    queue.put(String.valueOf(number));
                    number++;
                    notifyAll();
                }
            }
            String s = queue.take();
            printed++;
            print(s);
        }
    }

    private void print(String s) {
        System.out.print(s);
        System.out.print(printed < n ? ", " : System.lineSeparator());
    }
}