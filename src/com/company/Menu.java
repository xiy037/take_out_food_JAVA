package com.company;

public class Menu {
  public Food[] listItems() {
    final Food[] listAll = new Food[4];
    listAll[0] = new Food(1, "黄焖鸡", 18);
    listAll[1] = new Food(2, "肉夹馍", 6);
    listAll[2] = new Food(3, "凉皮", 8);
    listAll[3] = new Food(4, "冰锋", 2);
    return listAll;
  }

  public Food[] listPromotedItems() {
    final Food[] promoted = new Food[2];
    promoted[0] = new Food(1, "黄焖鸡", 18);
    promoted[1] = new Food(3, "凉皮", 8);
    return promoted;
  }
}
