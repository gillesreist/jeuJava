import java.util.ArrayList;
import java.util.Scanner;

public class CharacterEditor {
    private String characterName;
    private String characterClass;

    public String toString(){//overriding the toString() method
        return "Name of your character : "+ characterName +", class of your character : "+ characterClass;
    }

    public void createCharacter() {
        chooseName();
        chooseClass();
    }

    public void chooseName() {
        Scanner keyboard = new Scanner(System.in);
        this.characterName = keyboard.nextLine();
        System.out.println("All may salute the mighty "+this.characterName+"!");
    }

    public void chooseClass() {

        String userEntry = "";
        boolean hasChosen = false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose the class of "+this.characterName+" :");
        System.out.println("type 1 for a warrior");
        System.out.println("type 2 for a sorcerer");
        while (!hasChosen) {
            userEntry = keyboard.nextLine();
            switch (userEntry) {
                case "1":
                    this.characterClass = "warrior";
                    hasChosen = true;
                    break;
                case "2":
                    this.characterClass = "sorcerer";
                    hasChosen = true;
                    break;
                default:
                    System.out.println("You can only choose between 1 or 2.");
            }
        }
        System.out.println(this.characterName+" is now a great "+this.characterClass+"!");
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getCharacterClass() {
        return characterClass;
    }
}
