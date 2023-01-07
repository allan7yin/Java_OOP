import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // we pass 3, since we want the limit to b  threads, as we have one producer, two consumer threads

        MyProducer producer = new MyProducer(buffer, ThreadColour.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColour.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColour.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            // the type for the Future must be the same as the Callable's type, and the return type of call
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColour.ANSI_WHITE + "I'm being printed from the Callable class");
                return "This is the Callable class result";
            }
        });

        try {
            System.out.println(future.get()); // future.get() blocks until the result is avialable
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        // but now, to use executorService, we need to shut down manually, as it will run even after main thread is done
        // if we do not shut it down
        executorService.shutdown();

        // now, using executorService is overkill for this type of tiny application, but it is very vital when working
        // on applications involving a large number of threads as executorService allows the JVM to optimize thread
        // management
    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");

        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }

                    if (buffer.peek().equals("EOF")) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }

                    // for peek and take, no need to specify element, takes the first element of the queue, as it should x
                } catch (InterruptedException e) {

                }
            }
        }
    }
}

