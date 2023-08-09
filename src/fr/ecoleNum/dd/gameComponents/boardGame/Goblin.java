package fr.ecoleNum.dd.gameComponents.boardGame;

public class Goblin extends Foe {

    public Goblin() {
        super(6,1);
    }

    @Override
    public String toString() {
        return "A green monster is trying to steal your clothes.";
    }
}
