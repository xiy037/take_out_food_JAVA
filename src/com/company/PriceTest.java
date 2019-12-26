package com.company;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PriceTest {
  @Test
  public void shouldReturnDiscountedPrice1() {
    int price = 60;
    assertEquals(48, BestCharge.getDiscountedPrice1(price));
  }

  @Test
  public void shouldReturnDiscountedPrice2() {
    int price = 60;
    ArrayList<Food> order = new ArrayList<>();
    String foodName = "黄焖鸡";
    int count = 2;
    Food dish = new Food(foodName, count);
    order.add(dish);
    assertEquals(42, BestCharge.getDiscountedPrice2(order, price));
  }
}
