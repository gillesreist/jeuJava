package fr.ecoleNum.dd.gameEngine;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.exceptions.CharacterDeadException;
import fr.ecoleNum.dd.exceptions.CharacterOffBoardException;
import fr.ecoleNum.dd.gameComponents.boardGame.*;
import fr.ecoleNum.dd.gameComponents.boardGame.bonus.attackEquipment.FireBolt;
import fr.ecoleNum.dd.gameComponents.boardGame.bonus.attackEquipment.Mace;
import fr.ecoleNum.dd.gameComponents.boardGame.bonus.attackEquipment.Sword;
import fr.ecoleNum.dd.gameComponents.boardGame.bonus.attackEquipment.ThunderBolt;
import fr.ecoleNum.dd.gameComponents.boardGame.bonus.potions.BigPotion;
import fr.ecoleNum.dd.gameComponents.boardGame.bonus.potions.ClassicPotion;
import fr.ecoleNum.dd.gameComponents.boardGame.foe.Foe;
import fr.ecoleNum.dd.gameComponents.boardGame.foe.Dragon;
import fr.ecoleNum.dd.gameComponents.boardGame.foe.Goblin;
import fr.ecoleNum.dd.gameComponents.boardGame.foe.Wizard;
import fr.ecoleNum.dd.gameComponents.dice.Dice;
import fr.ecoleNum.dd.gameComponents.dice.D6;

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
        dice = new D6();
        run = true;
        gameInProgress = false;
    }

    public boolean isRunning() {
        return run;
    }

    private void createBoard() {
        for (int i=0; i <64; i++) {
            if (i==45 || i==52 || i==56 || i== 62) {
                boardGame.add(new Dragon());
            } else if (i==10 || i==20 || i==25 || i== 32 || i==35 || i==36 || i== 37 || i==40 || i==44 || i== 47) {
                boardGame.add(new Wizard());
            } else if (i==3|| i==6 || i==9 || i==12 || i==15 || i==18 || i==21 || i==24 || i==27 || i==30) {
                boardGame.add(new Goblin());
            } else if (i==2|| i==5 || i==11 || i==22 || i==38) {
                boardGame.add(new Mace());
            } else if (i==19|| i==26 || i==42 || i==53) {
                boardGame.add(new Sword());
            } else if (i==1|| i==4 || i==8 || i==17 || i==23) {
                boardGame.add(new ThunderBolt());
            } else if (i==48|| i==49) {
                boardGame.add(new FireBolt());
            } else if (i==7|| i==13 || i==31 || i==33 || i==39 || i==43) {
                boardGame.add(new ClassicPotion());
            } else if (i==28|| i==41) {
                boardGame.add(new BigPotion());
            } else {
                boardGame.add(new EmptyCase());
            }
        }
        Collections.shuffle(boardGame);
        boardGame.set(63, new Dragon());
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
                    System.err.println(e);
                    menu.resetMenu();
                }
            }
            if (run) {
                setGame();
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
        } catch(CharacterDeadException e) {
            gameInProgress = false;
        }

        System.out.println("Would you like to start another game ?");
        switch (menu.yesOrNo()) {
            case "y":
                setGame();
                break;
            case "n":
                menu.resetMenu();
                break;
        }
    }

    private void moveForward() throws CharacterDeadException {
        if (characterPosition!=boardGame.size()) {
            characterPosition += dice.getValue();
            if (characterPosition > boardGame.size()) {
                characterPosition = boardGame.size();
            }
            System.out.println("You threw a " + dice.getValue() + "\n" + character.getName() + " is on the case number " + characterPosition + "\n" + boardGame.get(characterPosition - 1));
            boardGame.get(characterPosition - 1).interaction(character);
            checkForDeadFoe();
        } else {
            System.out.println("Congratulations, you finished your adventure!");
            gameInProgress = false;
        }
    }

    private void checkForDeadFoe() {
        int caseNumber = characterPosition-1;
        Case foe = boardGame.get(caseNumber);
        if ( foe instanceof Foe) {
            if (((Foe) foe).getLifeLevel() <= 0) {
                boardGame.set(caseNumber, new DeadFoe());
            }
        }
    }

    private void playATurn() throws CharacterDeadException {
        menu.waitForPlayer();
        dice.throwDice();
        moveForward();
    }

    private void setGame() {
        character.setLifeLevel(character.getMinHealth());
        character.setAttackStrength(character.getMinStrength());
        boardGame.clear();
        character.clearInventory();
        createBoard();
    }
}