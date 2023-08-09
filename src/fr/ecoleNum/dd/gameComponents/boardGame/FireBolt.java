package fr.ecoleNum.dd.gameComponents.boardGame;

public class FireBolt extends Spell {
    public FireBolt() {
        super("fireBolt", 2);
    }
    public FireBolt(String name, int attackLevel){
        super(name, attackLevel);
    }

    @Override
    public String toString() {
        return "You found a scroll with fire symbols on it.";
    }
}
