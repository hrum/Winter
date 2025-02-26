package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prototype {

    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.start();
    }

    private void start() {
        Deck buildingDeck = new Deck();
        List<String> currentCards = new ArrayList<>();
        for(int i = 0; i < 4; i++)
            currentCards.add(buildingDeck.draw());

        while (true) {
            System.out.println(currentCards);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            currentCards.set(Integer.parseInt(input) - 1, buildingDeck.draw());
        }
    }
}
