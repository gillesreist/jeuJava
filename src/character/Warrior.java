package character;

import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Character {
    private Weapon weapon;


    public Warrior() {
        super();
        weapon = new Weapon();
    }

    public Warrior(String name) {
        this();
        this.setName(name);
    }

    public Warrior(String name, int lifeLevel, int attackStrength) {
        this();
        this.setName(name);
        this.setLifeLevel(lifeLevel);
        this.setAttackStrength(attackStrength);
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
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




