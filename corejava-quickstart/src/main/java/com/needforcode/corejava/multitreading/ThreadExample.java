package com.needforcode.corejava.multitreading;

public class ThreadExample implements Runnable {

    public void run() {
        System.out.println("Entered run method.");
        throw new RuntimeException("Exception throwing");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadExample());
        t.start();
        System.out.println("End of method.");
    }
}
