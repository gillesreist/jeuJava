package fr.ecoleNum.dd.gameComponents.boardGame.foe;

import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.exceptions.CharacterDeadException;
import fr.ecoleNum.dd.gameComponents.boardGame.Case;

public class Foe extends Case {

    private int lifeLevel;
    private int attackStrength;

    public Foe() {
        this(1,1);
    }

    public Foe(int lifeLevel, int attackStrength) {
        this.lifeLevel = lifeLevel;
        this.attackStrength = attackStrength;
    }

    @Override
    public String toString() {
        return "A monster is in the way.";
    }

    @Override
    public void interaction(Character character) throws CharacterDeadException {
        fight(character);
    }

    protected void fight(Character character) throws CharacterDeadException {
        System.out.println("You cannot avoid the fight.");
        setLifeLevel(getLifeLevel()- character.getAttackStrength());
        if (getLifeLevel()<=0) {
            System.out.println("You killed him on your first try.");
        } else {
            System.out.println("You attacked him first and removed him "+character.getAttackStrength()+" life points.");
            System.out.println("He got "+getLifeLevel()+" life points left.");
            System.out.println("He strikes you back and inflicts you "+getAttackStrength()+" damages.");
            character.setLifeLevel(character.getLifeLevel()-getAttackStrength());
            if (character.getLifeLevel() <= 0) {
                System.out.println("I'm very sorry to inform you that you are now dead.");
                throw new CharacterDeadException("Character is dead");
            } else {
                System.out.println("You have "+character.getLifeLevel()+" life points left.");
                System.out.println("Your opponent is now fleeing.");
            }
        }
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
}
