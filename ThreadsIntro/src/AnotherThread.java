public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ThreadColour.ANSI_BLUE + "Hello, from " + currentThread().getName());

        try {
            Thread.sleep(5000); // pauses the thread for 3 seconds

        } catch (InterruptedException e) {
            System.out.println(ThreadColour.ANSI_BLUE + "Another thread woke me up");
            return; // returning here terminates this thread if it is interrupted
        }

        System.out.println(ThreadColour.ANSI_BLUE + "Five seconds have passed, I'm awake");
    }
}
