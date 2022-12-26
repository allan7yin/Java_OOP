public class Main {
    public static void main(String[] args) {
        System.out.println(ThreadColour.ANSI_PURPLE + "Hello, from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== another thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColour.ANSI_GREEN + "Hello from the anonymous class");
            }
        }.start();

        // this is the runnable way, with creating a class that impelements the runnable interface
        // We pass this object to the constructor of the Thread class

        //        Thread myRunnableThread = new Thread(new MyRunnable());
        //        myRunnableThread.start();

        // we can also make the thread class above as an anonymous class

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColour.ANSI_RED + "Hello, from MyRunnable's implementation of run()");

                try {
                    anotherThread.join(2000);
                    System.out.println(ThreadColour.ANSI_RED + "Another thread terminated or timed out, so I'm running again");
                } catch(InterruptedException e) {
                    System.out.println(ThreadColour.ANSI_RED + "I could not wait after all. I was interrupted");
                }
            }
        });

        myRunnableThread.start();
        // Most people prefer the runnable method, as it's shorter, and more used.

        System.out.println(ThreadColour.ANSI_PURPLE + "Hello, again, from the main thread");
    }
}
