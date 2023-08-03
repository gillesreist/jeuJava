import java.util.Scanner;

public class CreateCharacter {
    private String characterName = chooseName();
    private String characterClass = chooseClass(characterName);

    public String toString(){//overriding the toString() method
        return "Name of your character : "+characterName+", class of your character : "+characterClass;
    }

    private String chooseName() {
        String name = "";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose the name of your character :");
        name = keyboard.nextLine();
        System.out.println("All may salute the mighty "+name+"!");
        return name;
    }

    private String chooseClass(String name) {
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
                default:
                    System.out.println("You can only choose between 1 or 2.");
            }
        }
        System.out.println(name+" is now a great "+characterClass+"!");
        return characterClass;
    }
}
