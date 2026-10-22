public class Demo {
    public static void main(String[] args) {

        Test test = new Test();

        Thread t1 = new Thread(() -> test.show());

        Thread t2 = new Thread(() -> test.show());

        t1.start();
        t2.start();
    }
}

// In the current implementation, both threads (t1 and t2) are using the same object (test).
// Since the `show()` method is synchronized, only one thread can execute it at a time.
// The second thread will have to wait for the first thread to finish before it can execute the method.
// This is because the `synchronized` keyword locks the method at the object level.

class Test {

    synchronized void show() {
        System.out.println(Thread.currentThread().getName() + "Inside show");

        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {}

        System.out.println(Thread.currentThread().getName() + "Show finish");
    }
}
