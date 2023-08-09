package fr.ecoleNum.dd.gameComponents.boardGame;

public class BigPotion extends Potion{
    public BigPotion() {
        super("bigPotion");
    }

    public BigPotion(String name){
        super(name);
    }

    @Override
    public String toString() {
        return "You see a huge potion in the grass";
    }
}
