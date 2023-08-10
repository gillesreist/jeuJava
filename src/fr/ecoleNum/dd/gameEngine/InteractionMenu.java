package fr.ecoleNum.dd.gameEngine;

import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.gameComponents.boardGame.bonus.attackEquipment.AttackEquipment;
import fr.ecoleNum.dd.utilities.Utilities;

import java.util.ArrayList;
import java.util.Scanner;

public class InteractionMenu {

    Scanner keyboard;

    public InteractionMenu(){
        keyboard = new Scanner(System.in);
    }

    public boolean yesOrNo(){
        String key = "";
        while (!key.equals("y") && !key.equals("n")) {
            System.out.println("You must enter 'y' or 'n'.");
            key = keyboard.nextLine();
        }
        return key.equals("y");
    }

    public String userEntry(){
        return keyboard.nextLine();
    }

    public int getAttackLevelFromInventory(ArrayList<AttackEquipment> inventory) {
        if (!inventory.isEmpty()){
            if (inventory.size() == 1) {
                System.out.println("Do you want to use your "+inventory.get(0).getName());
                if (yesOrNo()) {
                    return inventory.get(0).getAttackLevel();
                }
            } else {
                System.out.println("Which one do you want to use to attack ?");
                System.out.println("0 - none");
                for (int i= 0; i < inventory.size(); i++) {
                    System.out.println((i+1)+" - "+inventory.get(i).getName());
                }
                String userEntry;
                int userChoice = -1;
                while(userChoice < 0 || userChoice > inventory.size()) {
                    userEntry  = userEntry();
                    userChoice = Utilities.toIntIfValid(userEntry);
                }
                if (userChoice != 0) {
                    return inventory.get(userChoice-1).getAttackLevel();
                }
            }
        }
        return 0;
    }

}
