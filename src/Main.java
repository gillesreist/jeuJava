public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the dungeon of Khazad Dum!");
        Menu menu = new Menu();
        CreateCharacter character = menu.run();
        Play play = new Play(character);
        play.tilTheEnd();


    }
}