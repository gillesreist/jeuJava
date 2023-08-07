package gameEngine;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import character.Character;
import exceptions.CharacterOffBoardException;

public class Game {
    int characterPosition;
    int diceResult;
    Character character;
    Scanner keyboard;

    Game(Character character) {
        characterPosition = 1;
        this.character = character;
        keyboard = new Scanner(System.in);
    }


    public void play() {
        System.out.println(character.getName()+ " is on the case number " + characterPosition);
        while (characterPosition < 64) {
            try {
                moveForward(characterPosition);
            } catch(CharacterOffBoardException e) {
                System.out.println(e.getMessage());;
            }
        }

        System.out.println("Congratulations, you finished your adventure!");

        System.out.println("Would you like to start another game ? (y/n)");
        String key = "";
        while (!key.equals("y") && !key.equals("n")) {
            key = keyboard.nextLine();
            switch (key) {
                case "y":
                    characterPosition = 1;
                    play();
                    break;
                case "n":
                    break;
                default:
                    System.out.println("You must enter 'y' or 'n'.");
            }
        }
    }

    private void moveForward(int characterPosition) throws CharacterOffBoardException {

        throwDice();
        System.out.println("You threw a "+diceResult);
        if (characterPosition + diceResult > 64) {
                throw new CharacterOffBoardException("Your character will go too far.");
            }
            this.characterPosition += diceResult;
            System.out.println(character.getName() + " is on the case number " + this.characterPosition);
            keyboard.nextLine();
    }

    private void throwDice() {
        diceResult = ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

}