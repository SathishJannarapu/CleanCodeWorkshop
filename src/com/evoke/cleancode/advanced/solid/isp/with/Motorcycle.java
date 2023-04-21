package com.evoke.cleancode.advanced.solid.isp.with;

public class Motorcycle implements Engine, Acceleration {
  public void startEngine() {
    System.out.println("Starting motorcycle engine...");
  }

  public void stopEngine() {
    System.out.println("Stopping motorcycle engine...");
  }

  public void accelerate() {
    System.out.println("Accelerating motorcycle...");
  }

  public void brake() {
    System.out.println("Braking motorcycle...");
  }
}
