package ru.netology.Client;

public class ClientSilverStatus extends ClientBronze implements Client {
    protected final int discount = 10;

    public ClientSilverStatus(String name) {
        super(name);
    }

    @Override
    public void by(int spending) {
        int toPay = spending / 100 * (100 - discount);
        System.out.println("To be paid" + spending + "\n" +
                "To be paid with discount: " + toPay);
    }
}
