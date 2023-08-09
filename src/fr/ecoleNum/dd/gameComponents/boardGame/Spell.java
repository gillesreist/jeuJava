package fr.ecoleNum.dd.gameComponents.boardGame;

import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.character.Warrior;

public class Spell extends AttackEquipment {

    public Spell() {
        this("spell",1);
    }

    public Spell(String name, int attackLevel) {
        super(name, attackLevel);
    }

    @Override
    public String toString() {
        return "You found a scroll with strange symbols on it.";
    }

    @Override
    public void interaction(Character character) {
        if (character instanceof Warrior) {
            System.out.println("If only you knew how to read...");
        } else {
            System.out.println("You learn a new spell, you can feel your power growing !");
            equip(character);
        }
    }
}
