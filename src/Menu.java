import java.util.Scanner;

public class Menu {


    private boolean run;
    private String menuState;
    private String characterClass = "";
    private String characterName = "";
    Warrior warrior;
    Sorcerer sorcerer;
    Scanner keyboard = new Scanner(System.in);


    public Menu() {
        menuState = "startMenu";
        run = true;
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
                gameStart(userEntry);
                break;
            case "chooseClass":
                chooseClass(userEntry);
                break;
            case "chooseName":
                chooseName(userEntry);
                break;
            case "informations":
                informations(userEntry);
                break;
            case "modifyCharacter":
                modifyCharacter(userEntry);
                break;
        }
    }

    public void startMenu(String userEntry) {

        switch (userEntry) {

            case "1":
                menuState = "characterCreation";
                characterCreation("");
                break;
            case "2":
                menuState = "gameStart";
                gameStart("");
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
    }

    public void characterCreation(String userEntry) {

        switch (userEntry) {

            case "1":
                if (this.characterClass.isEmpty()) {
                    menuState = "chooseClass";
                    chooseClass("");
                } else {
                    menuState = "chooseName";
                    chooseName("");
                }
                break;
            case "2":
                informations("");
                break;
            case "3":
                menuState = "modifyCharacter";
                modifyCharacter("");
                break;
            case "4":
                menuState = "startMenu";
                startMenu("");
                break;
            default:
                if (this.characterClass.isEmpty()) {
                    System.out.println("1 - Choose the class of your character");
                } else {
                    System.out.println("1 - Choose the name of your character");

                }
                System.out.println("2 - See your character informations");
                System.out.println("3 - Modify your character");
                System.out.println("4 - return to main menu");
        }
    }

    public void gameStart(String userEntry) {
        switch (userEntry) {
            default:
                System.out.println("you can't yet");
                menuState = "startMenu";
                startMenu("");

        }
    }


    public void chooseClass(String userEntry) {

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
                System.out.println("1 - A Warrior");
                System.out.println("2 - A sorcerer");
        }
    }

    public void chooseName(String userEntry) {

    }

    public void informations(String userEntry) {
        if (this.characterClass.isEmpty()) {
            System.out.println("You must chose a class first.");
        } else if (this.characterName.isEmpty()) {
            System.out.println("The class of your character is "+this.characterClass);
        } else {
            System.out.println("The class of your character is "+this.characterClass+" and his name is "+this.characterName);
        }
        keyboard.nextLine();
        characterCreation("");
    }

    public void modifyCharacter(String userEntry) {
        System.out.println("not yet");
        keyboard.nextLine();
        menuState = "characterCreation";
        characterCreation("");
    }

}
