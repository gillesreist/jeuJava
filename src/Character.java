import java.util.concurrent.ThreadLocalRandom;

public class Character {
    private String name;
    private int minHealth;
    private int maxHealth;
    private int lifeLevel;
    private int minStrength;
    private int maxStrength;
    private int attackStrength;

    public Character() {
        this.minHealth = 0;
        this.maxHealth = 0;
        this.minStrength = 0;
        this.maxStrength = 0;
        this.name = "Cannon Fodder";
        this.lifeLevel = ThreadLocalRandom.current().nextInt(this.minHealth, this.maxHealth + 1);
        this.attackStrength = ThreadLocalRandom.current().nextInt(this.minStrength, this.maxStrength+ 1);
    }

    public Character(String name) {
        this();
        this.name = name;
    }

    public Character(String name, int lifeLevel, int attackStrength) {
        this();
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.attackStrength = attackStrength;
    }

    public String toString(){//overriding the toString() method
        return name+" is a great character with "+lifeLevel+" health points and "+attackStrength+" attack strength.";
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

    public void setMinHealth(int minHealth) {
        this.minHealth = minHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setMinStrength(int minStrength) {
        this.minStrength = minStrength;
    }

    public void setMaxStrength(int maxStrength) {
        this.maxStrength = maxStrength;
    }

}
