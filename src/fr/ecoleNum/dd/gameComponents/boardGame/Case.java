package fr.ecoleNum.dd.gameComponents.boardGame;
import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.character.Warrior;
import fr.ecoleNum.dd.exceptions.CharacterDeadException;
import fr.ecoleNum.dd.gameEngine.InteractionMenu;

public abstract class Case {
    protected InteractionMenu interactionMenu;
    public Case() {
        interactionMenu = new InteractionMenu();
    }

    public void interaction(Character character) throws CharacterDeadException {
        if (character instanceof Warrior) {
            System.out.println("Your warrior is going forward.");
        } else {
            System.out.println("Your sorcerer is going forward.");
        }
    }
}
