package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<String> strings;
    private final Random random = new Random();

    public Deck() {
        strings = new ArrayList<>();
    }

    public void add(String string) {
        strings.add(string);
    }

    public void addBuildings(String string, int number) {
        switch (number) {
            case 2:
                strings.add(string + "(зевс)");
                strings.add(string + "(зевс)");
                break;
            case 4:
                strings.add(string + "(зев)");
                strings.add(string + "(зес)");
                strings.add(string + "(звс)");
                strings.add(string + "(евс)");
                break;
            case 6:
                strings.add(string + "(зе)");
                strings.add(string + "(зв)");
                strings.add(string + "(зс)");
                strings.add(string + "(ев)");
                strings.add(string + "(ес)");
                strings.add(string + "(вс)");
                break;
            case 8:
                strings.add(string + "(з)");
                strings.add(string + "(е)");
                strings.add(string + "(в)");
                strings.add(string + "(с)");
                strings.add(string + "(з)");
                strings.add(string + "(е)");
                strings.add(string + "(в)");
                strings.add(string + "(с)");
                break;
            default:
        }
    }

    public String draw() {
        return strings.get(random.nextInt(strings.size()));
    }
}
