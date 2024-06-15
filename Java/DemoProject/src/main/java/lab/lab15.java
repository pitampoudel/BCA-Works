package lab;
class MyThread1 extends Thread {
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread1: " + i);
        }
    }
}

class MyThread2 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread2: " + i);
        }
    }
}

public class lab15 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();

        Thread t2 = new Thread(new MyThread2());
        t2.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
        System.out.println("Copyright Pitam Poudel");
    }
}