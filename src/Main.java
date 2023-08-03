public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the dungeon of Khazad Dum!");
        boolean quit = false;
        Menu menu = new Menu();
        CreateCharacter character = menu.run();
        while (!quit) {
            Play play = new Play(character);
            quit = play.tilTheEnd();
        }
        System.out.println("Goodbye.");
    }
}