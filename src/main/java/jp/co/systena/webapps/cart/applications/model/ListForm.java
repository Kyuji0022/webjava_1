package jp.co.systena.webapps.cart.applications.model;


public class ListForm {
  public int[] itemId;
  public int[] count;

  public void setCount(int[] count) {
    this.count = count;
  }

  public int[] getCount() {
    return this.count;
  }

  public void setItemId(int[] itemId) {
    this.itemId = itemId;
  }

  public int[] getItemId() {
    return this.itemId;
  }
}
