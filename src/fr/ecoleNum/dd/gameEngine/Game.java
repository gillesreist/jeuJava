package fr.ecoleNum.dd.gameEngine;
import java.util.ArrayList;
import java.util.Scanner;
import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.exceptions.CharacterOffBoardException;
import fr.ecoleNum.dd.gameComponents.boardGame.*;
import fr.ecoleNum.dd.gameComponents.dice.Dice;
import fr.ecoleNum.dd.gameComponents.dice.FakeDice;
import fr.ecoleNum.dd.gameComponents.dice.TwoD6;

public class Game {
    private int characterPosition;
    Character character;
    Scanner keyboard;
    Dice dice;
    ArrayList<Case> boardGame;

    Game(Character character) {
        boardGame = new ArrayList<Case>();
        characterPosition = 0;
        this.character = character;
        keyboard = new Scanner(System.in);
        dice = new FakeDice();
        createBoard();
    }

    private void createBoard() {
            boardGame.add(new EmptyCase());
            boardGame.add(new Foe());
            boardGame.add(new Weapon());
            boardGame.add(new Potion());
    }


    public void play() {
        System.out.println(character.getName()+ " is on the case number " + characterPosition);
        try {
            while (characterPosition < 64) {
                    playATurn();
            }
        } catch(CharacterOffBoardException e) {
            System.out.println(e.getMessage());;
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

    private void moveForward() throws CharacterOffBoardException {
        characterPosition += dice.getValue();
        System.out.println(character.getName() + " is on the case number " + characterPosition);
        try {
            System.out.println(boardGame.get(characterPosition - 1));
        } catch (Exception e) {
            throw new CharacterOffBoardException("You have won !");
        }
    }

    private void playATurn() throws CharacterOffBoardException {
        keyboard.nextLine();
        dice.throwDice();
        System.out.println("You threw a " + dice.getValue());
        moveForward();
    }
}