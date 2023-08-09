package fr.ecoleNum.dd.gameComponents.boardGame;

import fr.ecoleNum.dd.character.Character;

public class Potion extends Bonus {
    int healthRecovery;

    public Potion() {
        this("Potion", 1);
    }

    public Potion(String name, int healthRecovery){
        this.name = name;
        this.healthRecovery = healthRecovery;
    }

    @Override
    public void interaction(Character character) {
        if (character.getLifeLevel() < character.getMaxHealth()) {
            System.out.println("You drink it and gain some energy.");
            character.setLifeLevel(character.getLifeLevel()+healthRecovery);

            if (character.getLifeLevel() > character.getMaxHealth()) {
                character.setLifeLevel(character.getMaxHealth());
                System.out.println("You got your energy to the max!");
            }
            System.out.println("Your life level is now "+character.getLifeLevel());

        } else {
            System.out.println("You're feeling great, you don't need to drink this.");
        }
    }

    @Override
    public String toString() {
        return "You see a potion in the grass";
    }

}
