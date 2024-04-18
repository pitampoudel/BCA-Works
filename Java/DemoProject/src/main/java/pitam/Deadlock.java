package pitam;

/*
-A deadlock in Java occurs when two or more threads are blocked indefinitely, waiting for each other to release resources that they hold.
-In this example, thread1 acquires the lock on one resource(resource1) and then tries to acquire the lock on the other resource(resource2).
	thread2 acquires the lock on one resource(resource2) and then tries to acquire the lock on the other resource(resource1).
	This situation leads to a state where no thread can proceed, resulting in a deadlock.

-It's essential to use synchronization carefully to avoid potential deadlocks or performance bottlenecks.
*/
public class Deadlock {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1 acquired lock on resource1.");
                try {
                    Thread.sleep(100); // Adding a delay to make deadlock more likely
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("Thread 1 waiting for resource2.");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2 acquired lock on resource2.");
                synchronized (resource1) {
                    System.out.println("Thread 2 waiting for resource1.");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}