package ru.netology.Client;

public class ClientGoldStatus extends ClientSilverStatus implements Client {
    private final int discount = 20;
    private final int creditLimit = 5000;
    private int debt = creditLimit;

    public ClientGoldStatus(String name) {
        super(name);
    }

    @Override
    public void by(int spending) {
        int toPay = spending / 100 * (100 - discount);
        System.out.println("To be paid " + spending + "\n" +
                "To be paid with discount: " + toPay);
    }

    public void byOnCredit(int spending) {
        if (spending <= debt) {
            by(spending);
            debt = debt - spending;
            System.out.println("Your credit limit is: " + debt);
        } else {
            System.out.println("Not enough money on your credit score.");
        }
    }
}
