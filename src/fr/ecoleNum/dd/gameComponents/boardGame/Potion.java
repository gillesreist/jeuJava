package fr.ecoleNum.dd.gameComponents.boardGame;

public class Potion extends Case {
    String name;

    public Potion() {
        name = "Mana Potion";
    }

    @Override
    public String toString() {
        return "You see a potion in the grass";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
