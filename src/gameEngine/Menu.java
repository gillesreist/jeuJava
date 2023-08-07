package gameEngine;

import character.Character;
import character.Sorcerer;
import character.Warrior;
import utilities.Utilities;

import java.util.Scanner;
public class Menu {
    private boolean run;
    private String menuState;
    private String characterClass;
    private String characterName;
    Character character;
    Game game;
    Scanner keyboard;
    public Menu() {
        menuState = "startMenu";
        run = true;
        characterClass = "";
        characterName = "";
        keyboard = new Scanner(System.in);
    }

    public String getMenuState() {
        return menuState;
    }

    public boolean isRunning() {
        return this.run;
    }

    public void chooseNextStep(String userEntry) {
        chooseNextStep(this.menuState, userEntry);
    }

    public void chooseNextStep(String menuState, String userEntry) {
        switch (menuState) {
            case "startMenu" :
                startMenu(userEntry);
                break;
            case "characterCreation" :
                characterCreation(userEntry);
                break;
            case "gameStart":
                gameStart();
                break;
            case "chooseClass":
                chooseClass(userEntry);
                break;
            case "chooseName":
                chooseName(userEntry);
                break;
            case "informations":
                informations();
                break;
            case "modifyCharacter":
                modifyCharacter(userEntry);
                break;
            case "changeCharacterName":
                changeCharacterName(userEntry);
                break;
            case "changeCharacterHealth":
                changeCharacterHealth(userEntry);
                break;
            case "changeCharacterStrength":
                changeCharacterStrength(userEntry);
                break;
        }
    }

    private void startMenu(String userEntry) {

        switch (userEntry) {

            case "1":
                menuState = "characterCreation";
                characterCreation("");
                break;
            case "2":
                menuState = "gameStart";
                gameStart();
                break;
            case "q":
                this.run = false;
                break;
            default:
                System.out.println("What would you like to do ?");
                System.out.println("1 - Create a character");
                if (!this.characterName.isEmpty()) {
                    System.out.println("2 - Start the adventure");
                }
                System.out.println("Q - quit the game");
        }
    }

    private void characterCreation(String userEntry) {

        switch (userEntry) {

            case "1":
                if (this.characterClass.isEmpty()) {
                    menuState = "chooseClass";
                    chooseClass("");
                } else {
                    chooseName("");
                }
                break;
            case "2":
                informations();
                break;
            case "3":
                menuState = "modifyCharacter";
                modifyCharacter("");
                break;
            case "q":
                menuState = "startMenu";
                startMenu("");
                break;
            default:
                if (this.characterClass.isEmpty()) {
                    System.out.println("1 - Choose the class of your character");
                } else if (this.characterName.isEmpty()){
                    System.out.println("1 - Choose the name of your character");
                } else {
                    System.out.println("1 - See the name of your character.");
                }
                if (!this.characterClass.isEmpty()) {
                    System.out.println("2 - See your character informations");
                    System.out.println("3 - Modify your character");
                }
                System.out.println("Q - return to main menu");
        }
    }

    private void gameStart() {
        if (this.characterName.isEmpty()) {
            System.out.println("You are not supposed to be here yet");
        } else {
            System.out.println(this.characterName+" is beginning his adventure !");
            game = new Game(character);
            game.play();
        }
        menuState = "startMenu";
        startMenu("");
    }

    private void chooseClass(String userEntry) {

        switch (userEntry) {
            case "1" :
                this.characterClass = "warrior";
                menuState = "characterCreation";
                characterCreation("");
                break;
            case "2" :
                this.characterClass = "sorcerer";
                menuState = "characterCreation";
                characterCreation("");
                break;
            default :
                System.out.println("You want to create :");
                System.out.println("1 - A character.Warrior");
                System.out.println("2 - A sorcerer");
        }
    }

    private void chooseName(String userEntry) {
        while(this.characterName.isEmpty()) {
            System.out.println("Type the name of your character");
            this.characterName = keyboard.nextLine();
        }
        System.out.println("All may salute the mighty "+this.characterName+"!");
        if (characterClass.equals("warrior")) {
            character = new Warrior(this.characterName);
        } else {
            character = new Sorcerer(this.characterName);
        }
        keyboard.nextLine();
        characterCreation("");
    }

    private void informations() {
        if (this.characterClass.isEmpty()) {
            System.out.println("You must chose a class first.");
        } else if (this.characterName.isEmpty()) {
            System.out.println("The class of your character is "+this.characterClass);
        } else {
            System.out.println(character);
        }
        keyboard.nextLine();
        characterCreation("");
    }

    private void modifyCharacter(String userEntry) {
        if (this.characterClass.isEmpty()) {
            System.out.println("You must create your character first.");
            keyboard.nextLine();
        } else if (this.characterName.isEmpty()) {
            switch (userEntry) {
                case "1" :
                    menuState = "chooseClass";
                    chooseClass("");
                    break;
                case "2" :
                    menuState = "characterCreation";
                    characterCreation("");
                    break;
                default :
                    System.out.println("Would you like to change your character class ?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
            }
        } else {
            switch (userEntry) {
                case "1":
                    menuState = "changeCharacterName";
                    changeCharacterName("");
                    break;
                case "2":
                    menuState = "changeCharacterHealth";
                    changeCharacterHealth("");
                    break;
                case "3":
                    menuState = "changeCharacterStrength";
                    changeCharacterStrength("");
                    break;
                case "q":
                    menuState = "characterCreation";
                    characterCreation("");
                    break;
                default:
                    System.out.println("What do you want to change ?");
                    System.out.println("1 - Your character Name");
                    System.out.println("2 - Your character Health");
                    System.out.println("3 - Your character Strength");
                    System.out.println("Q - Nothing");
            }
        }
    }

    private void changeCharacterName(String userEntry) {
        if (!userEntry.isEmpty()) {
            this.character.setName(userEntry);
            this.characterName = userEntry;
            System.out.println("Your characters name is now "+ this.character.getName());
            keyboard.nextLine();
            menuState = "modifyCharacter";
            modifyCharacter("");
        } else {
            System.out.println("Type the new name of your character.");
        }
    }

    private void changeCharacterHealth(String userEntry) {
        int userEntryInt = Utilities.toIntIfValid(userEntry);
        if (userEntryInt <= character.getMaxHealth() && userEntryInt >= character.getMinHealth() ) {
            character.setLifeLevel(userEntryInt);
            System.out.println("Your characters health is now "+ character.getLifeLevel());
            keyboard.nextLine();
            menuState = "modifyCharacter";
            modifyCharacter("");
        } else {
            System.out.println("Type the new health of your character between "+character.getMinHealth()+" and "+character.getMaxHealth());
        }
    }

    private void changeCharacterStrength(String userEntry) {
        int userEntryInt = Utilities.toIntIfValid(userEntry);
        if (userEntryInt <= character.getMaxStrength() && userEntryInt >= character.getMinStrength() ) {
            character.setAttackStrength(userEntryInt);
            System.out.println("Your characters strength is now "+ character.getAttackStrength());
            keyboard.nextLine();
            menuState = "modifyCharacter";
            modifyCharacter("");
        } else {
            System.out.println("Type the new strength of your character between "+character.getMinStrength()+" and "+character.getMaxStrength());
        }
    }

}
