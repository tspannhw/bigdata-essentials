package com.needforcode.corejava.lambdas;

public class LambdaTest {

  public static void main(String[] args) {

    // Using anonymous classes
    Runnable anonymousTest = new Runnable() {

      @Override
      public void run() {
        System.out.println("Hello world anonymous!");
      }
    };

    // Using Lambda expressions
    Runnable lambdaTest = () -> System.out.println("Hello world Lambda!");

    // Run both of them
    anonymousTest.run();
    lambdaTest.run();

  }
}
