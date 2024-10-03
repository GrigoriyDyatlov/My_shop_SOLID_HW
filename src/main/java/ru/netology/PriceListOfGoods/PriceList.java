package ru.netology.PriceListOfGoods;

public class PriceList {
    private String nameOfTheProduct;
    private int cost;

    public PriceList (String nameOfTheProduct, int cost){
        this.cost = cost;
        this.nameOfTheProduct = nameOfTheProduct;
    }

    public String  getNameOfTheProduct(){
        return nameOfTheProduct;
    }
    public int getCost(){
        return  cost;
    }

    public void setCost(int newCost){
        this.cost = newCost;
    }
}
