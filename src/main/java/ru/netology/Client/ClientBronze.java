package ru.netology.Client;

public class ClientBronze implements Client {
    private final String name;

    public ClientBronze(String name) {
        this.name = name;
    }

    @Override
    public void by(int spending) {
        System.out.println("To be paid " + spending);
    }
}
