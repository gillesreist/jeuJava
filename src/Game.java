import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    int characterPosition;
    int diceResult;
    Character character;
    Scanner keyboard;
    String userEntry;

    Game(Character character) {
        characterPosition = 1;
        this.character = character;
        keyboard = new Scanner(System.in);
    }


    public void play() {
        System.out.println(character.getName()+ " is on the case number " + characterPosition);
        moveForward();

        System.out.println("Congratulations, you finished your adventure!");

        System.out.println("Would you like to start another game ? (y/n)");
        String key = "";
        while (!key.equals("y") && !key.equals("n")) {
            key = keyboard.nextLine();
            switch (key) {
                case "y":
                    characterPosition = 1;
                    play();
                    break;
                case "n":
                    break;
                default:
                    System.out.println("You must enter 'y' or 'n'.");
            }
        }
    }

    private void moveForward() {
        while (characterPosition < 64) {
            throwDice();
            characterPosition += diceResult;
            System.out.println("You threw a "+diceResult);
            System.out.println(character.getName() + " is on the case number " + characterPosition);
            keyboard.nextLine();
        }
    }

    private void throwDice() {
        diceResult = ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

}