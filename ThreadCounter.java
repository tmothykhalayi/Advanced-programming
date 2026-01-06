// Thread class
class CounterThread extends Thread {
    public void run() {
        for (int i = 1; ; i++) {
            System.out.println(getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

// Runnable interface
class CounterRunnable implements Runnable {
    public void run() {
        for (int i = 1; ; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

// Main class
public class ThreadCounter {
    public static void main(String[] args) {

        // Thread using Thread class
        CounterThread t1 = new CounterThread();

        // Threads using Runnable
        Thread t2 = new Thread(new CounterRunnable());
        Thread t3 = new Thread(new CounterRunnable());

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}
