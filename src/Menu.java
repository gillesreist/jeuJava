import java.util.Scanner;

public class Menu {

    private boolean run;
    private String menuState;
    private String characterClass = "";
    Warrior warrior;
    Sorcerer sorcerer;

    public Menu() {
        run = true;
        menuState = ("startMenu");
    }

    public boolean isRunning() {
        return this.run;
    }

    public void chooseNextStep(String userEntry) {
        chooseNextStep(this.menuState, userEntry);
    }

    public void chooseNextStep(String menuState, String userEntry) {
        Scanner keyboard = new Scanner(System.in);

        switch (menuState) {

            case "startMenu":

                switch (userEntry) {

                    case "1":
                        this.menuState = "characterCreation";
                        chooseNextStep("");
                        break;
                    case "2":
                        this.menuState = "gameStart";
                        chooseNextStep("");
                        break;
                    case "3":
                        this.run = false;
                        break;
                    default:
                        System.out.println("What would you like to do ?");
                        System.out.println("1 - Create a character");
                        System.out.println("2 - Start the adventure");
                        System.out.println("3 - quit the game");
                }
                break;

            case "characterCreation":

                switch (userEntry) {

                    case "1" :
                        if (this.characterClass.isEmpty()) {
                            this.menuState = "chooseClass";
                            chooseNextStep("");
                        } else {
                            this.menuState = "chooseName";
                            chooseNextStep("");
                        }
                        break;
                    case "2" :
                        System.out.println("informations");
                        chooseNextStep("");
                        break;
                    case "3" :
                        this.menuState = "modifyCharacter";
                        chooseNextStep("");
                        break;
                    case "4" :
                        this.menuState = "startMenu";
                        chooseNextStep("");
                        break;
                    default :
                        if (this.characterClass.isEmpty()) {
                            System.out.println("1 - Choose the class of your character");
                        } else {
                            System.out.println("1 - Choose the name of your character");

                        }
                        System.out.println("2 - See your character informations");
                        System.out.println("3 - Modify your character");
                        System.out.println("4 - return to main menu");
                }

                break;


            case "gameStart" :

                switch (userEntry) {
                    default :
                        System.out.println("you can't yet");
                        this.menuState = "startMenu";
                        chooseNextStep("");

                }
                break;

            case "chooseClass" :

                switch (userEntry) {
                    case "1" :
                        this.characterClass = "warrior";
                        this.menuState = "characterCreation";
                        chooseNextStep("");
                        break;
                    case "2" :
                        this.characterClass = "sorcerer";
                        this.menuState = "characterCreation";
                        chooseNextStep("");
                        break;
                    default :
                        System.out.println("You want to create :");
                        System.out.println("1 - A Warrior");
                        System.out.println("2 - A sorcerer");

                }
                break;


            default :
                this.menuState = "startMenu";
                chooseNextStep("");


        }


    }


    public String getMenuState() {
        return menuState;
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





