import java.util.concurrent.ThreadLocalRandom;

public class Sorcerer {
    private String name = "Cannon fodder";
    private int minHealth = 3;
    private int maxHealth = 8;
    private int lifeLevel = ThreadLocalRandom.current().nextInt(minHealth, maxHealth + 1);
    private int minStrength = 6;
    private int maxStrength = 15;
    private int attackStrength = ThreadLocalRandom.current().nextInt(minStrength, maxStrength + 1);
    private Spell spell = new Spell();


    public Sorcerer(String name, int lifeLevel, int attackStrength) {
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.attackStrength = attackStrength;

    }

    public Sorcerer(String name) {
        this.name = name;
    }

    public Sorcerer() {
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
}

