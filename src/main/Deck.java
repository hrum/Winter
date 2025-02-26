package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private final List<String> cards;
    private final Random random;

    public Deck() {
        cards = new ArrayList<>();
        random = new Random();
        String data = "Бар 2\n" +
                "Кафе 4\n" +
                "Ресторан 6\n" +
                "Пиццерия 8\n" +
                "Кофейня 10\n" +
                "Пельменная 12\n";
        String[] lines = data.split("\n");
        for(String line: lines)
            cards.add(line);
    }

    public String draw() {
        return cards.get(random.nextInt(cards.size()));
    }
}
