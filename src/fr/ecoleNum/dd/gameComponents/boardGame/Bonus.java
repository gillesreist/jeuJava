package fr.ecoleNum.dd.gameComponents.boardGame;

public class Bonus extends Case {
    String name;

    public Bonus() {
        this("Bonus");
    }

    public Bonus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
