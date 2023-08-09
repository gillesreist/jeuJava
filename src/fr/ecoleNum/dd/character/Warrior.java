package fr.ecoleNum.dd.character;

import fr.ecoleNum.dd.gameComponents.boardGame.Weapon;

import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Character {
        public Warrior() {
        super();
    }

    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, int lifeLevel, int attackStrength) {
        super(name, lifeLevel, attackStrength);
    }

    protected void setCharacterMinMax() {
        setMinHealth(5);
        setMaxHealth(10);
        setMinStrength(5);
        setMaxStrength(10);
        setLifeLevel(getMinHealth());
        setAttackStrength(getMinStrength());}
}




