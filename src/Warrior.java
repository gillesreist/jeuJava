import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

public class Warrior {
    private String name = "Cannon Fodder";
    private int minHealth = 5;
    private int maxHealth = 10;
    private int lifeLevel = ThreadLocalRandom.current().nextInt(minHealth, maxHealth + 1);
    private int minStrength = 5;
    private int maxStrength = 10;
    private int attackStrength = ThreadLocalRandom.current().nextInt(minStrength, maxStrength + 1);
    private Weapon weapon = new Weapon();

    public Warrior(String name, int lifeLevel, int attackStrength) {
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.attackStrength = attackStrength;

    }

    public Warrior(String name) {
        this.name = name;
    }

    public Warrior() {
    }

    public String toString(){//overriding the toString() method
        return name+" "+lifeLevel+" "+attackStrength;
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

}




