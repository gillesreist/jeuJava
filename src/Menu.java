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
            case "changeWarriorName":
                changeWarriorName(userEntry);
                break;
            case "changeWarriorHealth":
                changeWarriorHealth(userEntry);
                break;
            case "changeWarriorStrength":
                changeWarriorStrength(userEntry);
                break;
            case "changeSorcererName":
                changeSorcererName(userEntry);
                break;
            case "changeSorcererHealth":
                changeSorcererHealth(userEntry);
                break;
            case "changeSorcererStrength":
                changeSorcererStrength(userEntry);
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
                gameStart("");
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
                informations("");
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
                } else {
                    System.out.println("1 - Choose the name of your character");

                }
                if (!this.characterClass.isEmpty()) {
                    System.out.println("2 - See your character informations");
                    System.out.println("3 - Modify your character");
                }
                System.out.println("Q - return to main menu");
        }
    }

    private void gameStart(String userEntry) {
        switch (userEntry) {
            default:
                if (this.characterName.isEmpty()) {
                    System.out.println("You are not supposed to be here yet");
                } else {
                    System.out.println("You can't yet");
                }
                menuState = "startMenu";
                startMenu("");

        }
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
                System.out.println("1 - A Warrior");
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
            warrior = new Warrior(this.characterName);
        } else {
            sorcerer = new Sorcerer(this.characterName);
        }
        keyboard.nextLine();
        characterCreation("");
    }

    private void informations(String userEntry) {
        if (this.characterClass.isEmpty()) {
            System.out.println("You must chose a class first.");
        } else if (this.characterName.isEmpty()) {
            System.out.println("The class of your character is "+this.characterClass);
        } else {
            if (this.characterClass.equals("warrior")) {
                System.out.println(warrior);
            } else if (this.characterClass.equals("sorcerer")) {
                System.out.println(sorcerer);

            }
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
            if (this.characterClass.equals("warrior")) {
                switch (userEntry) {
                    case "1":
                        menuState = "changeWarriorName";
                        changeWarriorName("");
                        break;
                    case "2":
                        menuState = "changeWarriorHealth";
                        changeWarriorHealth("");
                        break;
                    case "3":
                        menuState = "changeWarriorStrength";
                        changeWarriorStrength("");
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
            } else if (this.characterClass.equals("sorcerer")) {
                switch (userEntry) {
                    case "1" :
                        menuState = "changeSorcererName";
                        changeSorcererName("");
                        break;
                    case "2" :
                        menuState = "changeSorcererHealth";
                        changeSorcererHealth("");
                        break;
                    case "3" :
                        menuState = "changeSorcererStrength";
                        changeSorcererStrength("");
                        break;
                    case "q" :
                        menuState = "characterCreation";
                        characterCreation("");
                        break;
                    default :
                        System.out.println("What do you want to change ?");
                        System.out.println("1 - Your character Name");
                        System.out.println("2 - Your character Health");
                        System.out.println("3 - Your character Strength");
                        System.out.println("Q - Nothing");
                }
            } else {
                System.out.println("How did you come here ?");
                menuState = "characterCreation";
                characterCreation("");
            }
        }
    }

    private void changeWarriorName(String userEntry) {
        
    }

}
