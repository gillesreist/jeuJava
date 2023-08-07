import java.util.concurrent.ThreadLocalRandom;

public class Sorcerer {
    private String name;
    private int minHealth;
    private int maxHealth;
    private int lifeLevel;
    private int minStrength;
    private int maxStrength;
    private int attackStrength;
    private Spell spell;

    public Sorcerer() {
        this.minHealth = 3;
        this.maxHealth = 8;
        this.minStrength = 6;
        this.maxStrength = 15;
        this.name = "Cannon Fodder";
        this.lifeLevel = ThreadLocalRandom.current().nextInt(this.minHealth, this.maxHealth + 1);
        this.attackStrength = ThreadLocalRandom.current().nextInt(this.minStrength, this.maxStrength+ 1);
        spell = new Spell();
    }

    public Sorcerer(String name) {
        this();
        this.name = name;
    }

    public Sorcerer(String name, int lifeLevel, int attackStrength) {
        this();
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.attackStrength = attackStrength;
    }

    public String toString(){//overriding the toString() method
        return name+" is a great sorcerer with "+lifeLevel+" health points and "+attackStrength+" attack strength.";
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

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
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

