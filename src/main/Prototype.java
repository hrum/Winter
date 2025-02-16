package main;

import java.util.ArrayList;
import java.util.List;

public class Prototype {

    private List<String> currentCards;
    private List<Deck> decks;

    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.start();
    }

    private void start() {
        initDecks();
        for(Deck deck: decks)
            currentCards.add(deck.draw());
        for(String currentCard: currentCards)
            System.out.print(currentCard + " ");
    }

    private void initDecks() {
        currentCards = new ArrayList<>();
        decks = new ArrayList<>();
        Deck waterDeck = new Deck();
        waterDeck.addBuildings("Колодец", 8);
        waterDeck.addBuildings("Фонтан", 6);
        waterDeck.addBuildings("Водопровод", 4);
        waterDeck.addBuildings("Водохранилище", 2);
        Deck foodDeck = new Deck();
        foodDeck.addBuildings("Яблоневый сад", 8);
        foodDeck.addBuildings("Пшеничное поле", 6);
        foodDeck.addBuildings("Ферма", 4);
        foodDeck.addBuildings("Амбар", 2);
        Deck woodDeck = new Deck();
        woodDeck.addBuildings("Лесопилка", 8);
        woodDeck.addBuildings("Каменоломня", 6);
        woodDeck.addBuildings("Железная шахта", 4);
        woodDeck.addBuildings("Склад", 2);
        Deck goldDeck = new Deck();
        goldDeck.addBuildings("Торговая лавка" , 8);
        goldDeck.addBuildings("Золотая шахта" , 6);
        goldDeck.addBuildings("Порт" , 4);
        goldDeck.addBuildings("Банк" , 2);

        Deck eventDeck = new Deck();
        eventDeck.add("Золото");
        eventDeck.add("Еда");
        eventDeck.add("Вода");
        eventDeck.add("Стройматериалы");
        decks.add(waterDeck);
        decks.add(foodDeck);
        decks.add(woodDeck);
        decks.add(goldDeck);
        decks.add(eventDeck);
        decks.add(eventDeck);
    }
}
