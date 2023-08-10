package fr.ecoleNum.dd.gameComponents.boardGame.foe;

import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.exceptions.CharacterDeadException;
import fr.ecoleNum.dd.gameComponents.boardGame.Case;
import fr.ecoleNum.dd.utilities.Utilities;

public class Foe extends Case {

    private int lifeLevel;
    private int attackStrength;

    public Foe() {
        this(1,1);
    }

    public Foe(int lifeLevel, int attackStrength) {
        super();
        this.lifeLevel = lifeLevel;
        this.attackStrength = attackStrength;
    }

    @Override
    public String toString() {
        return "A monster is in the way. ";
    }

    @Override
    public void interaction(Character character) throws CharacterDeadException {
        fight(character);
    }

    protected void fight(Character character) throws CharacterDeadException {
        System.out.println("You cannot avoid the fight.");
        character.attack(this);
        if (getLifeLevel()<=0) {
            System.out.println("You killed him.");
        } else {
            System.out.println("He got "+getLifeLevel()+" life points left.");
            character.defend(this);
            if (character.getLifeLevel() <= 0) {
                System.out.println("I'm very sorry to inform you that you are now dead.");
                throw new CharacterDeadException("Character is dead");
            } else {
                System.out.println("You have "+character.getLifeLevel()+" life points left.");
                System.out.println("Your opponent is now fleeing.");
            }
        }
    }

    public int chooseAttackEquipment(Character character) {
        return interactionMenu.getAttackLevelFromInventory(character.getInventory());
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
