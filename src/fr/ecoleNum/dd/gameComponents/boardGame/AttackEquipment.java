package fr.ecoleNum.dd.gameComponents.boardGame;

import fr.ecoleNum.dd.character.Character;

public class AttackEquipment extends Bonus {
    private int attackLevel;

    public AttackEquipment() {
        this("attackEquipment",1);
    }

    public AttackEquipment(String name, int attackLevel) {
        this.name = name;
        this.attackLevel = attackLevel;
    }

    @Override
    public String toString() {
        return "Something useful just lying on the side of the road. Weird...";
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    protected void equip(Character character) {
        character.setAttackStrength(character.getAttackStrength()+getAttackLevel());
        if (character.getAttackStrength()> character.getMaxStrength()) {
            character.setAttackStrength(character.getMaxStrength());
        }
        System.out.println("Your attack strength is now "+character.getAttackStrength());
    }
}
