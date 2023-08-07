import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Character {
    private Weapon weapon;

    public Warrior() {
        this.setMinHealth(5);
        this.setMaxHealth(10);
        this.setMinStrength(5);
        this.setMaxStrength(10);
        this.setName("Cannon Fodder");
        this.setLifeLevel(ThreadLocalRandom.current().nextInt(this.getMinHealth(), this.getMaxHealth() + 1));
        this.setAttackStrength(ThreadLocalRandom.current().nextInt(this.getMinStrength(), this.getMaxStrength()+ 1));
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

    public String toString(){//overriding the toString() method
        return this.getName()+" is a great warrior with "+ this.getLifeLevel() +" health points and "+ this.getAttackStrength() +" attack strength.";
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

}




