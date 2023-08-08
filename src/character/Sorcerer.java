package character;

import java.util.concurrent.ThreadLocalRandom;

public class Sorcerer extends Character {
    private Spell spell;

    public Sorcerer() {
        super();
        spell = new Spell();
    }

    public Sorcerer(String name) {
        this();
        this.setName(name);
    }

    public Sorcerer(String name, int lifeLevel, int attackStrength) {
        this();
        this.setName(name);
        this.setLifeLevel(lifeLevel);
        this.setAttackStrength(attackStrength);
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

