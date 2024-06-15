package lab;
class Data {
    boolean isProduced = false;
    String data = "";

    public synchronized void produce(String d) {
        while (isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        data = d;
        isProduced = true;
        notify();
    }

    public synchronized String consume() {
        while (!isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        isProduced = false;
        notify();
        return data;
    }
}

class Producer implements Runnable {
    Data data;

    Producer(Data d) {
        data = d;
    }

    public void run() {
        String[] messages = {"Tomato", "Potato", "MOMO", "Chicken"};
        for (String message : messages) {
            data.produce(message);
            System.out.println("Produced: " + message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
    }
}

class Consumer implements Runnable {
    Data data;

    Consumer(Data d) {
        data = d;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            String message = data.consume();
            System.out.println("Consumed: " + message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
    }
}

public class lab17 {
    public static void main(String[] args) {
        Data data = new Data();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
        System.out.println("Copyright Pitam Poudel");
    }
}