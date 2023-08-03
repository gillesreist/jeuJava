import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Play {
    CreateCharacter character;
    int characterPosition = 1;
    int diceResult = ThreadLocalRandom.current().nextInt(1, 6 + 1);

    public Play(CreateCharacter character){
        this.character = character;
    }
    public boolean tilTheEnd() {

        System.out.println(character.getCharacterName()+" is on the case number "+ characterPosition);
        while (characterPosition < 64) {
            characterPosition += diceResult;
            System.out.println(character.getCharacterName()+" is on the case number "+ characterPosition);
        }
        System.out.println("Congratulations, you finished your adventure!");

        System.out.println("Would you like to start another game ? (y/n)");
        boolean quit = false;
        Scanner keyboard = new Scanner(System.in);
        String key = "";
        while (!key.equals("y") && !key.equals("n")) {
            key = keyboard.nextLine();
            switch (key) {
                case "y":
                    break;
                case "n":
                    quit = true;
                    break;
                default:
                    System.out.println("You must enter 'y' or 'n'.");
            }
        }
        return quit;
    }
}
