package fr.ecoleNum.dd.gameComponents.boardGame;

import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.character.Warrior;

public class FireBolt extends Spell {
    public FireBolt() {
        super("fireBolt", 5);
    }
    public FireBolt(String name, int attackLevel){
        super(name, attackLevel);
    }

    @Override
    public String toString() {
        return "You found a scroll with fire symbols on it.";
    }
}
