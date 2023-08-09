package fr.ecoleNum.dd.gameEngine;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;
import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.exceptions.CharacterOffBoardException;
import fr.ecoleNum.dd.gameComponents.boardGame.*;
import fr.ecoleNum.dd.gameComponents.dice.Dice;
import fr.ecoleNum.dd.gameComponents.dice.FakeDice;

public class Game {
    private Menu menu;
    private Character character;
    private int characterPosition;
    private Dice dice;
    private ArrayList<Case> boardGame;
    private boolean run;
    private boolean gameInProgress;

    public Game() {
        menu = new Menu();
        boardGame = new ArrayList<>();
        character = null;
        dice = new FakeDice();
        run = true;
        gameInProgress = false;
        createBoard();
    }

    public boolean isRunning() {
        return run;
    }

    private void createBoard() {
        boardGame.add(new EmptyCase());
        boardGame.add(new Foe());
        boardGame.add(new Weapon());
        boardGame.add(new Dragon());
        boardGame.add(new Mace());
        boardGame.add(new ThunderBolt());
        boardGame.add(new ClassicPotion());
        boardGame.add(new Goblin());
        boardGame.add(new FireBolt());
        boardGame.add(new Sword());
        boardGame.add(new Wizard());
        boardGame.add(new BigPotion());
    }

    public void start() {
        System.out.println("Welcome to the dungeon of Ragnarok !");
        while (isRunning()) {
            while (menu.isRunning()) {
                try {
                    switch (menu.getMenuState()) {
                        case "startMenu" :
                            run = menu.startMenu(character);
                            break;
                        case "createCharacter" :
                            character = menu.createCharacter(character);
                            break;
                        default :
                            Method method = menu.getClass().getMethod(menu.getMenuState(), Character.class);
                            method.invoke(menu, character);
                    }
                } catch (Exception e) {
                    System.err.println(e.toString());
                    menu.resetMenu();
                }
            }
            if (run) {
                play();
            }
        }
        System.out.println("Goodbye.");
    }

    private void play() {
        gameInProgress = true;
        characterPosition = 0;
        System.out.println(character.getName()+ " is starting his journey !");
        try {
            while (gameInProgress) {
                    playATurn();
            }
        } catch(CharacterOffBoardException e) {
            gameInProgress = false;
        }

        System.out.println("Congratulations, you finished your adventure!");

        System.out.println("Would you like to start another game ?");
        switch (menu.yesOrNo()) {
            case "y":
                break;
            case "n":
                menu.resetMenu();
                break;
        }
    }

    private void moveForward() throws CharacterOffBoardException {
        characterPosition += dice.getValue();
        try {
            System.out.println("You threw a " + dice.getValue()+"\n"+character.getName() + " is on the case number " + characterPosition+"\n"+boardGame.get(characterPosition - 1));
        } catch (IndexOutOfBoundsException e) {
            throw new CharacterOffBoardException("You went off the board.");
        }
    }

    private void playATurn() throws CharacterOffBoardException {
        menu.waitForPlayer();
        dice.throwDice();
        System.out.println();
        moveForward();
    }
}