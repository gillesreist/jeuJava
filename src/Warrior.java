import java.util.concurrent.ThreadLocalRandom;

public class Warrior {
    private String name;
    private int minHealth;
    private int maxHealth;
    private int lifeLevel;
    private int minStrength;
    private int maxStrength;
    private int attackStrength;
    private Weapon weapon;

    public Warrior() {
        this.minHealth = 5;
        this.maxHealth = 10;
        this.minStrength = 5;
        this.maxStrength = 10;
        this.name = "Cannon Fodder";
        this.lifeLevel = ThreadLocalRandom.current().nextInt(this.minHealth, this.maxHealth + 1);
        this.attackStrength = ThreadLocalRandom.current().nextInt(this.minStrength, this.maxStrength+ 1);
        weapon = new Weapon();
    }

    public Warrior(String name) {
        this();
        this.name = name;
    }

    public Warrior(String name, int lifeLevel, int attackStrength) {
        this();
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.attackStrength = attackStrength;
    }

    public String toString(){//overriding the toString() method
        return name+" is a great warrior with "+lifeLevel+" health points and "+attackStrength+" attack strength.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeLevel() {
        return lifeLevel;
    }

    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getMinHealth() {
        return minHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public int getMaxStrength() {
        return maxStrength;
    }
}




