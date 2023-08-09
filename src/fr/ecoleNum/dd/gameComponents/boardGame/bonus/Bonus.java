package fr.ecoleNum.dd.gameComponents.boardGame.bonus;

import fr.ecoleNum.dd.gameComponents.boardGame.Case;

public class Bonus extends Case {
    private String name;

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
