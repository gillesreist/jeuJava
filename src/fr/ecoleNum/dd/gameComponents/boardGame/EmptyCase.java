package fr.ecoleNum.dd.gameComponents.boardGame;

import fr.ecoleNum.dd.character.Character;

public class EmptyCase extends Case {

    @Override
    public void interaction(Character character) {
        System.out.println("You are moving forward.");
    }

    @Override
    public String toString() {
        return "There is nothing there";
    }
}
