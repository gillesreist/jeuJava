package fr.ecoleNum.dd.character;

import fr.ecoleNum.dd.gameComponents.boardGame.bonus.attackEquipment.AttackEquipment;
import fr.ecoleNum.dd.gameComponents.boardGame.foe.Foe;

import java.util.ArrayList;

public abstract class Character {
    private String name;
    private int lifeLevel;
    private int attackStrength;
    private int minHealth;
    private int maxHealth;
    private int minStrength;
    private int maxStrength;
    private ArrayList<AttackEquipment> inventory;

    public Character() {
        this.name = "Cannon Fodder";
        this.inventory = new ArrayList<>();
        setCharacterMinMax();
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

    public String toString() {
        return this.getName()+" has "+ this.getLifeLevel() +" health points and "+ this.getAttackStrength() +" attack strength.";
    };

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

    protected abstract void setCharacterMinMax();

    public ArrayList<AttackEquipment> getInventory() {
        return inventory;
    }

    public void addToInventory(AttackEquipment attackEquipment) {
        inventory.add(attackEquipment);
    }

    public int getInventorySize() {
        return inventory.size();
    }

    public void clearInventory() {
        inventory.clear();
    }

    public void attack(Foe foe){
        int equipmentAttackLevel = foe.chooseAttackEquipment(this);
        int totalAttackStrength = getAttackStrength()+equipmentAttackLevel;
        foe.setLifeLevel(foe.getLifeLevel()- totalAttackStrength);
        System.out.println("You attacked him first and removed him "+totalAttackStrength+" life points.");
    }



    public void defend(Foe foe) {
        System.out.println("He strikes you back and inflicts you "+foe.getAttackStrength()+" damages.");
        setLifeLevel(getLifeLevel()-foe.getAttackStrength());
    }

}
