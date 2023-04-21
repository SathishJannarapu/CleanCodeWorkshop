package com.evoke.cleancode.advanced.solid.liskov.with;

public class Square extends Shape {
  private int sideLength;

  public Square(int sideLength) {
    this.sideLength = sideLength;
  }

  public int getSideLength() {
    return sideLength;
  }

  public void setSideLength(int sideLength) {
    this.sideLength = sideLength;
  }

  public int calculateArea() {
    return sideLength * sideLength;
  }
}
