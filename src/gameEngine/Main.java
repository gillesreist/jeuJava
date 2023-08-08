package gameEngine;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the dungeon of Khazad Dum!\nPress Enter");
        Menu menu = new Menu();
        while  (menu.isRunning()) {
            menu.chooseNextStep();
        }
        System.out.println("Goodbye.");
    }
}