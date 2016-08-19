package com.needforcode.corejava.multitreading;

import org.apache.log4j.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



public class ProducerConsumerBlockingQueue {

    public static void main(String args[]) {

        // Creating shared object
        BlockingQueue sharedQue = new LinkedBlockingQueue();

        // Creating Producer thread
        Thread producer = new Thread(new Producer(sharedQue));
        // Creating Consumer thread
        Thread consumer = new Thread(new Consumer(sharedQue));

        // Starting producer and Consumer thread
        producer.start();
        consumer.start();
    }

}

class Producer implements Runnable {

    private final BlockingQueue sharedQue;

    public Producer(BlockingQueue sharedQueue) {
        this.sharedQue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Produced: " + i);
                sharedQue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).error("Exception", ex);
            }
        }
    }

}

class Consumer implements Runnable {

    private final BlockingQueue sharedQue;

    public Consumer(BlockingQueue sharedQueue) {
        this.sharedQue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).error("Exception", ex);
            }
        }
    }
}
