package com.company;

import java.util.*;

public class BestCharge {
  static ArrayList<Food> userInput() {
    Scanner input = new Scanner(System.in);
    ArrayList<Food> order = new ArrayList<>();
    System.out.println("menu：黄焖鸡，肉夹馍，凉皮，冰峰");
    do {
      System.out.println("What is your choice?");
      String foodName = input.next();
      System.out.println("How many?");
      int count = input.nextInt();
      Food dish = new Food(foodName, count);
      order.add(dish);
      System.out.println("Anything else? yes/no");
    } while (!input.next().equals("no"));
    input.close();
    return order;
  }

  static int calculatePrice(ArrayList<Food> arr) {
    Food[] itemList = Menu.listItems();
    int price = 0;
    for (Food x : arr) {
      for (Food food : itemList) {
        if (x.foodName.equals(food.foodName)) {
          price += x.count * food.price;
        }
      }
    }
    return price;
  }

  static int getDiscountedPrice1(int price) {
    int discountedPrice = price;
    if (price >= 30) {
      discountedPrice = price - (Math.floorDiv(price, 30) * 6);
    }
    return discountedPrice;
  }

  static int getDiscountedPrice2(ArrayList<Food> order, int price) {
    int discountedPrice = price;
    Food[] discountedList = Menu.listPromotedItems();
    for (Food x : order) {
      for (Food food : discountedList) {
        if (x.foodName.equals(food.foodName)) {
          discountedPrice = price - (food.price / 2) * x.count;
        }
      }
    }
    return discountedPrice;
  }

  public static void main(String[] args) {
    ArrayList<Food> order = userInput();
    for (Food x : order) {
      System.out.println(x.foodName + "*" + x.count);
    }
    int price = calculatePrice(order);
    System.out.println("折扣前价格：" + price + "元");
    int discountedPrice1 = getDiscountedPrice1(price);
    int discountedPrice2 = getDiscountedPrice2(order, price);
    int bestCharge = price;
    String bestPromotion = "无优惠";
    if (discountedPrice1 < price || discountedPrice2 < price) {
      if (discountedPrice1 <= discountedPrice2) {
        bestCharge = discountedPrice1;
        bestPromotion = "满30减6";
      } else {
        bestCharge = discountedPrice2;
        bestPromotion = "指定商品半价：黄焖鸡，凉皮";
      }
    }
    String receipt = "总价：" + bestCharge + "元，优惠方式：" + bestPromotion;
    System.out.println(receipt);
  }


}

//method listAllItems 返回菜品列表；
//method Input 用户输入 在system.in里面读取;
//method listPromotions 返回两种打折方式，以及打折的商品列表；
//method calculatePrice 计算不打折时的价格；
//method calculateDiscounted 计算打折的价格；
//method comparePrice 比较折扣后的价格，取最小的那个；
//method output 输出结果；