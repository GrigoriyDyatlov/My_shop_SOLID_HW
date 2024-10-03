package ru.netology.Basket;

import java.util.HashMap;
import java.util.Map;
public class Basket {

    protected HashMap<String, Integer> goods;
    protected HashMap<String, Integer> myGoods;


    public Basket(HashMap<String, Integer> goods) {
        this.goods = goods;
        this.myGoods = new HashMap<>();
    }

    public boolean put(String itemKey, int quantity) {
        if (goods.get(itemKey) != null && myGoods.get(itemKey) != null) {
            myGoods.put(itemKey, myGoods.get(itemKey) * quantity);
            return true;
        } else if (goods.get(itemKey) != null) {
            myGoods.put(itemKey, quantity);
            return true;
        } else return false;
    }

    public boolean remove(String itemKey) {
        if (myGoods.get(itemKey) > 1) {
            myGoods.replace(itemKey, myGoods.get(itemKey) - 1);
            return true;
        } else if (myGoods.get(itemKey) == 1) {
            myGoods.remove(itemKey);
            return true;
        } else return false;
    }

    public void inMyBasket() {
        System.out.println(myGoods.entrySet());
    }

    public int totalCost() {
        int sum = 0;
        for (String key : myGoods.keySet()) {
            sum += (goods.get(key) * myGoods.get(key));
        }
        return sum;
    }
}
