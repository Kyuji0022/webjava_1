package jp.co.systena.webapps.cart.applications.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class Cart {
  @Autowired
  private ListService listService;

  //private ArrayList<Item> itemList;
  private int itemId;
  private ArrayList<Map<Integer, Integer>> itemNum = new ArrayList<Map<Integer, Integer>>();

  public ArrayList<Map<Integer, Integer>> getOrder() {
      return itemNum;
  }

  public void setOrder(List<Item> itemList,int[] num) {
      itemList = listService.getItemList();


      for(int count = 0; count < itemList.size(); count++) {
          this.itemId = itemList.get(count).itemId;

          Map<Integer, Integer> order = new HashMap<>();
          order.put(itemId, num[count]);

          itemNum.add(order);
      }
  }
}