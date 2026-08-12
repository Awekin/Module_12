package task2;

public class Main {
    static void main() throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread fizz = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread buzz = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread fizzbuzz = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread num = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        fizz.start();
        buzz.start();
        fizzbuzz.start();
        num.start();

        fizz.join();
        buzz.join();
        fizzbuzz.join();
        num.join();
    }
}