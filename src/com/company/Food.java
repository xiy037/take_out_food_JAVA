package com.company;

public class Food {
  public int id;
  public String foodName;
  public int price;
  public int count;

  public Food(int x, String a, int y) {
    this.id = x;
    this.foodName = a;
    this.price = y;
  }

  public Food(String b, int i) {
    this.foodName = b;
    this.count = i;
  }
}
