public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ThreadColour.ANSI_RED + "Hello, from MyRunnable's implementation of run()");
    }
}
