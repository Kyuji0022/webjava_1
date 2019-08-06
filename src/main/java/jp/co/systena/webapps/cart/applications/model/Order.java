package jp.co.systena.webapps.cart.applications.model;

public class Order {
  public int itemId;
  public int num;

  public Order(int itemId, int num) {
      this.itemId = itemId;
      this.num = num;
  }
}