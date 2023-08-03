import java.util.Scanner;

public class CreateCharacter {
    private String characterName = chooseName();
    private String characterClass = chooseClass(characterName);

    public String toString(){//overriding the toString() method
        return "Name of your character : "+ characterName +", class of your character : "+ characterClass;
    }

    private String chooseName() {
        String name = "";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("You can quit the character creation by entering 'q' :");
        System.out.println("Choose the name of your character :");
        name = keyboard.nextLine();
        if (name.equals("q")) {
            return name;
        }
        System.out.println("All may salute the mighty "+name+"!");
        return name;
    }

    private String chooseClass(String name) {

        if (characterName.equals("q")) {
            name="";
            return "";
        }

        String characterClass = "";
        String userEntry = "";
        boolean hasChosen = false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose the class of "+name+" :");
        System.out.println("type 1 for a warrior");
        System.out.println("type 2 for a sorcerer");
        while (!hasChosen) {
            userEntry = keyboard.nextLine();
            switch (userEntry) {
                case "1":
                    characterClass = "warrior";
                    hasChosen = true;
                    break;
                case "2":
                    characterClass = "sorcerer";
                    hasChosen = true;
                    break;
                case "q":
                    characterClass = "";
                    return characterClass;
                default:
                    System.out.println("You can only choose between 1 or 2.");
            }
        }
        System.out.println(name+" is now a great "+characterClass+"!");
        return characterClass;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }
}
