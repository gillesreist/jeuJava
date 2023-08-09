package fr.ecoleNum.dd.gameComponents.boardGame;
import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.character.Warrior;

public abstract class Case {

    public void interaction(Character character) {
        if (character instanceof Warrior) {
            System.out.println("Your warrior is going forward.");
        } else {
            System.out.println("Your sorcerer is going forward.");
        }
    }
}
