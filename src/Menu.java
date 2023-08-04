import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void startMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What would you like to do ?");
        System.out.println("1 - Create a character");
        System.out.println("2 - Start the adventure");
        System.out.println("Q - quit the game");


    }
    public CreateCharacter run() {
        boolean characterFinished = false;
        String userEntry = "";

        Scanner keyboard = new Scanner(System.in);
        System.out.println("What would you like to do ?");
        System.out.println("1 - Create a character");
        System.out.println("2 - Information about your character");
        System.out.println("3 - Start the adventure");
        System.out.println("Q - quit the game");

        CreateCharacter characterInfos = null;


        while (!characterFinished) {
            userEntry = keyboard.nextLine();
            switch (userEntry) {
                case "1":
                    characterInfos = new CreateCharacter();

                    if (characterInfos.getCharacterClass().isEmpty()) {
                        characterInfos = null;
                    }
                    break;
                case "2":
                    if (characterInfos == null) {
                        System.out.println("You must create a character first.");
                    } else {
                        System.out.println(characterInfos);
                        System.out.println("Would you like to change his name ? (y/n)");
                        userEntry = keyboard.nextLine();
                        switch (userEntry) {
                            case "y":
                                System.out.println("Enter the new name of your character :");
                                characterInfos.setCharacterName(keyboard.nextLine());
                                System.out.println("Your character new name is "+characterInfos.getCharacterName());
                                break;
                            case "n":
                                break;
                            default :
                                System.out.println("You must enter 'y' or 'n'.");
                        }
                        System.out.println("Would you like to change his class ? (y/n)");
                        userEntry = keyboard.nextLine();
                        switch (userEntry) {
                            case "y":
                                if (characterInfos.getCharacterClass().equals("warrior")) {
                                    characterInfos.setCharacterClass("sorcerer");
                                } else {
                                    characterInfos.setCharacterClass("warrior");
                                }
                                System.out.println("You have switched your character class.");
                                break;
                            case "n":
                                break;
                            default :
                                System.out.println("You must enter 'y' or 'n'.");
                        }

                    }
                    break;
                case "3":
                    if (characterInfos == null) {
                        System.out.println("You must create a character first.");
                    } else {
                        characterFinished = true;
                    }

                    break;
                case "q":
                    System.out.println("Goodbye");
                    System.exit(0);
                default:
                    System.out.println("You can only choose among the proposals.");
            }
            System.out.println("You are back on the main menu.");
        }
        return characterInfos;
    }
}





