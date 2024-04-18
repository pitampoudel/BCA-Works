package pitam;


//Inter-thread communication allows synchronized threads to communicate with each other.
/*It is implemented by following methods of Object class:
 wait():Causes current thread to release the lock and wait until either another thread invokes the notify()
 method or the notifyAll() method for this object, or a specified amount of time has elapsed.
 notify():Wakes up a single thread that is waiting on this object's monitor.
 notifyAll():Wakes up all threads that are waiting on this object's monitor.
 */
class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("going to withdraw...");

        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait(); //wait
            } catch (Exception e) {
            }
        }
        this.amount -= amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount) {
        System.out.println("going to deposit...");
        this.amount += amount;
        System.out.println("deposit completed... ");
        notify();
    }
}

public class InterThreadCommunicationDemo {

    public static void main(String[] args) {

        final Customer c = new Customer();
        new Thread() {
            public void run() {
                c.withdraw(15000);
            }

        }.start();

        new Thread() {
            public void run() {
                c.deposit(10000);
                System.out.println(c.amount);
            }
        }.start();
    }
}