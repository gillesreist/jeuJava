package fr.ecoleNum.dd.character;

import fr.ecoleNum.dd.gameComponents.boardGame.Spell;

import java.util.concurrent.ThreadLocalRandom;

public class Sorcerer extends Character {

    public Sorcerer() {
        super();
    }

    public Sorcerer(String name) {
        super(name);
    }

    public Sorcerer(String name, int lifeLevel, int attackStrength) {
        super(name, lifeLevel, attackStrength);
    }

    protected void setCharacterMinMax() {
        this.setMinHealth(3);
        this.setMaxHealth(8);
        this.setMinStrength(6);
        this.setMaxStrength(15);
        this.setLifeLevel(ThreadLocalRandom.current().nextInt(this.getMinHealth(), this.getMaxHealth() + 1));
        this.setAttackStrength(ThreadLocalRandom.current().nextInt(this.getMinStrength(), this.getMaxStrength()+ 1));
    }

}

