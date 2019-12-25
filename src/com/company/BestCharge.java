package com.company;
import java.util.*;

public class BestCharge {
    static ArrayList<Food> userInput() {
      Scanner input = new Scanner(System.in);
      ArrayList<Food> order = new ArrayList<Food>();
      do {
        System.out.println("What is your dish?");
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
        for (int i = 0; i < itemList.length; i++) {
          if (x.foodName.equals(itemList[i].foodName)) {
            price += x.count * itemList[i].price;
          }
        }
      }
      return price;
    }

    public static void main(String[] args) {
      ArrayList<Food> order = userInput();
      for (Food x : order) {
        System.out.println(x.foodName + "*" + x.count);
      }
      int price = calculatePrice(order);
      System.out.println(price);

    }
}

//method listAllItems 返回菜品列表；
//method Input 用户输入 在system.in里面读取;
//method listPromotions 返回两种打折方式，以及打折的商品列表；
//method calculatePrice 计算不打折时的价格；
//method calculateDiscounted 计算打折的价格；
//method comparePrice 比较折扣后的价格，取最小的那个；
//method output 输出结果；