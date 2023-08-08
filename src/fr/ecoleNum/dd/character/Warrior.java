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
        this.setMinHealth(5);
        this.setMaxHealth(10);
        this.setMinStrength(5);
        this.setMaxStrength(10);
        this.setLifeLevel(ThreadLocalRandom.current().nextInt(this.getMinHealth(), this.getMaxHealth() + 1));
        this.setAttackStrength(ThreadLocalRandom.current().nextInt(this.getMinStrength(), this.getMaxStrength()+ 1));
    }


}




