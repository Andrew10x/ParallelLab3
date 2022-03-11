package Task2;
import java.util.Random;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}

class Producer implements Runnable {
    private final Drop drop;
    int size = 10;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        int[] importantInfo = new int[size];
        for(int i=0; i<size; i++){
            importantInfo[i] = (int) (Math.random()*50);
            System.out.print(importantInfo[i] + " ");
        }
        System.out.println();
        Random random = new Random();

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            drop.put(importantInfo[i]);
            try {
                Thread.sleep(/*random.nextInt(1000)*/ 10);
            } catch (InterruptedException e) {}
        }
        drop.put(Integer.MAX_VALUE);
    }
}

class Consumer implements Runnable {
    private final Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        for (int message = drop.take();
             message != Integer.MAX_VALUE;
             message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(/*random.nextInt(1000)*/ 0);
            } catch (InterruptedException e) {}
        }
    }
}

class Drop {

    private int message;

    private boolean empty = true;

    public synchronized int take() {

        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = true;

        notifyAll();
        return message;
    }

    public synchronized void put(int message) {
        // Wait until message has
        // been retrieved.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        notifyAll();
    }
}

