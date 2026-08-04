void main() throws InterruptedException {
    MyThread t = new MyThread();
    Thread thr = t.thread1;

    thr.start();
    t.thread2.start();
}
