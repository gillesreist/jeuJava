package gameEngine;

import character.Character;
import character.Sorcerer;
import character.Warrior;
import utilities.Utilities;
import java.lang.reflect.Method;

import java.util.Scanner;
public class Menu {
    private boolean run;
    private String menuState;
    Character character;
    Game game;
    Scanner keyboard;
    public Menu() {
        menuState = "startMenu";
        run = true;
        character = null;
        keyboard = new Scanner(System.in);
    }

    public String getMenuState() {
        return menuState;
    }

    public boolean isRunning() {
        return this.run;
    }

    public void chooseNextStep() {
        chooseNextStep(this.menuState);
    }

    public void chooseNextStep(String menuState) {
        try {
            Method method = this.getClass().getDeclaredMethod(menuState);
            method.invoke(this);
        } catch(Exception e) {
            System.err.println("Something is broken.");
        }
    }

    private void startMenu() {

        System.out.println("What would you like to do ?");
        System.out.println("1 - Create a character");
        if (character != null) {
            System.out.println("2 - Start the adventure");
        }
        System.out.println("Q - quit the game");

        switch (keyboard.nextLine()) {

            case "1":
                menuState = "characterCreation";
                break;
            case "2":
                menuState = "gameStart";
                break;
            case "q":
                this.run = false;
                break;
        }
    }

    private void characterCreation() {
        if (character == null) {
            System.out.println("1 - Choose the class of your character");
        } else {
            System.out.println("1 - See your character informations");
            System.out.println("2 - Modify your character");
        }
        System.out.println("Q - return to main menu");

        switch (keyboard.nextLine()) {

            case "1":
                if (character == null) {
                    menuState = "chooseClass";
                } else {
                    menuState = "informations";
                }
                break;
            case "2":
                menuState = "modifyCharacter";
                break;
            case "q":
                menuState = "startMenu";
                break;
        }
    }

    private void gameStart() {
        if (character == null) {
            System.out.println("You are not supposed to be here yet");
        } else {
            System.out.println(this.character.getName()+" is beginning his adventure !");
            game = new Game(character);
            game.play();
        }
        menuState = "startMenu";
    }

    private void chooseClass () {

        System.out.println("You want to create :");
        System.out.println("1 - A warrior");
        System.out.println("2 - A sorcerer");

        switch (keyboard.nextLine()) {
            case "1" :
                menuState = "choosename";
                chooseName("warrior");
                break;
            case "2" :
                menuState = "choosename";
                chooseName("sorcerer");
                break;
        }
    }

    private void chooseName(String characterClass) {
        System.out.println("Type the name of your character");
        String characterName = keyboard.nextLine();

        System.out.println("All may salute the mighty "+characterName+"!");
        if (characterClass.equals("warrior")) {
            character = new Warrior(characterName);
        } else {
            character = new Sorcerer(characterName);
        }
        keyboard.nextLine();
        menuState = "characterCreation";
    }

    private void informations() {
        if (character == null) {
            System.out.println("You must create your character first.");
        } else {
            if (character instanceof Warrior) {
                System.out.println("Your character is a warrior named "+character.getName());
            } else {
                System.out.println("Your character is a sorcerer named "+character.getName());
            }
            System.out.println(character);
        }
        keyboard.nextLine();
        menuState = "characterCreation";
    }

    private void modifyCharacter() {
        if (character == null) {
            System.out.println("You must create your character first.");
            keyboard.nextLine();
        } else {
            System.out.println("What do you want to change ?");
            System.out.println("1 - Your character Name");
            System.out.println("2 - Your character Health");
            System.out.println("3 - Your character Strength");
            System.out.println("Q - Nothing");
            switch (keyboard.nextLine()) {
                case "1":
                    menuState = "changeCharacterName";
                    break;
                case "2":
                    menuState = "changeCharacterHealth";
                    break;
                case "3":
                    menuState = "changeCharacterStrength";
                    break;
                case "q":
                    menuState = "characterCreation";
                    break;
            }
        }
    }

    private void changeCharacterName() {
        System.out.println("Type the new name of your character.");
        character.setName(keyboard.nextLine());
        System.out.println("Your characters name is now "+ character.getName());
        keyboard.nextLine();
        menuState = "modifyCharacter";
    }

    private void changeCharacterHealth() {
        System.out.println("Type the new health of your character between "+character.getMinHealth()+" and "+character.getMaxHealth());
        int userEntryInt = Utilities.toIntIfValid(keyboard.nextLine());
        if (userEntryInt <= character.getMaxHealth() && userEntryInt >= character.getMinHealth() ) {
            character.setLifeLevel(userEntryInt);
            System.out.println("Your characters health is now "+ character.getLifeLevel());
            keyboard.nextLine();
            menuState = "modifyCharacter";
        }
    }

    private void changeCharacterStrength() {
        System.out.println("Type the new strength of your character between "+character.getMinStrength()+" and "+character.getMaxStrength());
        int userEntryInt = Utilities.toIntIfValid(keyboard.nextLine());
        if (userEntryInt <= character.getMaxStrength() && userEntryInt >= character.getMinStrength() ) {
            character.setAttackStrength(userEntryInt);
            System.out.println("Your characters strength is now " + character.getAttackStrength());
            keyboard.nextLine();
            menuState = "modifyCharacter";
        }
    }
}
