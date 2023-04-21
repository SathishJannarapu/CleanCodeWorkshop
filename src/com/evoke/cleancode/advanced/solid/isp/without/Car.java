package com.evoke.cleancode.advanced.solid.isp.without;

public class Car implements Vehicle {
  public void startEngine() {
    System.out.println("Starting car engine...");
  }

  public void stopEngine() {
    System.out.println("Stopping car engine...");
  }

  public void accelerate() {
    System.out.println("Accelerating car...");
  }

  public void brake() {
    System.out.println("Braking car...");
  }

  public void changeGear() {
    System.out.println("Changing gear in car...");
  }
}
