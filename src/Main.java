import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the dungeon of Khazad Dum!");
        Menu menu = new Menu();

        Scanner keyboard = new Scanner(System.in);

        String userEntry="";

        menu.chooseNextStep(userEntry);

        while  (menu.isRunning()) {
            userEntry = keyboard.nextLine();
            menu.chooseNextStep(menu.getMenuState(), userEntry);
        }

        System.out.println("Goodbye.");
    }
}