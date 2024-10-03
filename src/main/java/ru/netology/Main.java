package ru.netology;

import ru.netology.Basket.Basket;
import ru.netology.Client.ClientBronze;
import ru.netology.Client.ClientGoldStatus;
import ru.netology.Client.ClientSilverStatus;
import ru.netology.PriceListOfGoods.PriceList;

import java.util.HashMap;
import java.util.List;

// Нету магических чисел везде использованы переменные или логические выражения main 41, ClientSilverStatus 12.
public class Main {
    public static void main(String[] args) {
        //Каждая реализация Клиента расширяет его возможности, но все ои обладают свойствами Клиента.
        ClientBronze client1 = new ClientBronze("Olya");
        ClientSilverStatus client2 = new ClientSilverStatus("Tanya");
        ClientGoldStatus client3 = new ClientGoldStatus("Petya");

        HashMap<String, Integer> goods = new HashMap<>();
        goods.putAll(goodsCreate());
// Здесь создание списка доступных продуктов вынесено отдельно, что бы не засорять меин созданием классов,
// создание отдельного метода для часто повторяющегося когда
// чтобы можно было создать список разными способами, например загрузить файл json.

        Basket basket = new Basket(goods);
        basket.put("Milk", 1);
        basket.put("Ags", 1);
        basket.put("Beer", 5);
        basket.put("Beer", 2);
//Корзина хранит только список товаров и сумму к оплате. Покупкой занимается отдельный класс.
        client1.by(basket.totalCost());
        client3.by(basket.totalCost());
        client2.by(basket.totalCost());
        client3.byOnCredit(basket.totalCost());

    }

    public static HashMap<String, Integer> goodsCreate() {
        PriceList Milk = new PriceList("Milk", 100);
        PriceList Ags = new PriceList("Ags", 115);
        PriceList Beer = new PriceList("Beer", 147);
        List<PriceList> priceList = List.of(Milk, Ags, Beer);
        HashMap<String, Integer> goods = new HashMap<>();
        for (int i = 0; i < priceList.size(); i++) {
            goods.put(priceList.get(i).getNameOfTheProduct(), priceList.get(i).getCost());
        }
        return goods;
    }
}