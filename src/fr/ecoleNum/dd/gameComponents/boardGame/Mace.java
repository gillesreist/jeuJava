package fr.ecoleNum.dd.gameComponents.boardGame;

public class Mace extends Weapon {
    public Mace() {
        super("mace", 2);
    }
    public Mace(String name, int attackLevel){
        super(name, attackLevel);
    }

    @Override
    public String toString() {
        return "You see a good piece of wood against a tree.";
    }
}
