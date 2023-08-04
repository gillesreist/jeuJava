public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the dungeon of Khazad Dum!");
        boolean quit = false;
        Menu menu = new Menu();
        CharacterEditor characterEditor = new CharacterEditor();

        while  (!quit) {
            boolean startTheGame = false;

            while (!startTheGame) {
                menu.startMenu();
            }
        }




      /*  CreateCharacter character = menu.run();
        while (!quit) {
            Play play = new Play(character);
            quit = play.tilTheEnd();
        }*/
        System.out.println("Goodbye.");
    }
}