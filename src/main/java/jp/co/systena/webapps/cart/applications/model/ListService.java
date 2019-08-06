package jp.co.systena.webapps.cart.applications.model;

import java.util.ArrayList;
import java.util.List;

public class ListService {

  /**
   * 商品情報を設定
   * 複数の商品を商品一覧として設定する。
   * @return
   */
  public List<Item> getItemList() {

    // 商品1
    Item item1 = new Item();
    item1.itemId = 1;
    item1.name = "商品1";
    item1.price = 100;

    // 商品2
    Item item2 = new Item();
    item2.itemId = 2;
    item2.name = "商品2";
    item2.price = 200;

    // 商品3
    Item item3 = new Item();
    item3.itemId = 3;
    item3.name = "商品3";
    item3.price = 300;

    // 商品一覧として保存
    List<Item> itemList = new ArrayList<Item>();
    itemList.add(item1);
    itemList.add(item2);
    itemList.add(item3);

    return itemList;

  }

}
