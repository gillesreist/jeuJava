package fr.ecoleNum.dd.gameEngine;

import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.character.Sorcerer;
import fr.ecoleNum.dd.character.Warrior;
import fr.ecoleNum.dd.utilities.Utilities;
import java.lang.reflect.Method;

import java.util.Scanner;
public class Menu {
    private boolean run;
    private String menuState;
    Scanner keyboard;
    public Menu() {
        menuState = "startMenu";
        run = true;
        keyboard = new Scanner(System.in);
    }

    public String getMenuState() {
        return menuState;
    }

    public boolean isRunning() {
        return this.run;
    }

    public void resetMenu() {
        this.run = true;
        menuState = "startMenu";
    }

    public boolean startMenu(Character character) {

        System.out.println("What would you like to do ?");
        if (character == null) {
            System.out.println("1 - Create a character");
        } else {
            System.out.println("1 - Go back to your character");
            System.out.println("2 - Start the adventure");
        }
        System.out.println("Q - quit the game");

        switch (keyboard.nextLine()) {

            case "1":
                menuState = "characterCreation";
                break;
            case "2":
                if (character != null) {
                    this.run = false;
                }
                break;
            case "q":
                this.run = false;
                return false;
        }
        return true;
    }

    public void characterCreation(Character character) {
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
                    menuState = "createCharacter";
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

    public Character createCharacter (Character character) {
        String characterClass = null;

        while (characterClass == null) {
            System.out.println("You want to create :");
            System.out.println("1 - A warrior");
            System.out.println("2 - A sorcerer");

            switch (keyboard.nextLine()) {
                case "1":
                    characterClass = "warrior";
                    break;
                case "2":
                    characterClass = "sorcerer";
                    break;
            }
        }

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
        return character;
    }

    public void informations(Character character) {
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

    public void modifyCharacter(Character character) {
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

    public void changeCharacterName(Character character) {
        System.out.println("Type the new name of your character.");
        character.setName(keyboard.nextLine());
        System.out.println("Your characters name is now "+ character.getName());
        keyboard.nextLine();
        menuState = "modifyCharacter";
    }

    public void changeCharacterHealth(Character character) {
        System.out.println("Type the new health of your character between "+character.getMinHealth()+" and "+character.getMaxHealth());
        int userEntryInt = Utilities.toIntIfValid(keyboard.nextLine());
        if (userEntryInt <= character.getMaxHealth() && userEntryInt >= character.getMinHealth() ) {
            character.setLifeLevel(userEntryInt);
            System.out.println("Your characters health is now "+ character.getLifeLevel());
            keyboard.nextLine();
            menuState = "modifyCharacter";
        }
    }

    public void changeCharacterStrength(Character character) {
        System.out.println("Type the new strength of your character between "+character.getMinStrength()+" and "+character.getMaxStrength());
        int userEntryInt = Utilities.toIntIfValid(keyboard.nextLine());
        if (userEntryInt <= character.getMaxStrength() && userEntryInt >= character.getMinStrength() ) {
            character.setAttackStrength(userEntryInt);
            System.out.println("Your characters strength is now " + character.getAttackStrength());
            keyboard.nextLine();
            menuState = "modifyCharacter";
        }
    }

    public void waitForPlayer(){
        keyboard.nextLine();
    }

    public String yesOrNo(){
        String key = "";
        while (!key.equals("y") && !key.equals("n")) {
            System.out.println("You must enter 'y' or 'n'.");
            key = keyboard.nextLine();
        }
        return key;
    }

}
