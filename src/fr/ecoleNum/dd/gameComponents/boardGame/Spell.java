package fr.ecoleNum.dd.gameComponents.boardGame;

public class Spell extends Case {
    private String name;
    private int attackLevel;

    public Spell() {
        this("spell",1);
    }

    public Spell(String name, int attackLevel) {
        this.name = name;
        this.attackLevel = attackLevel;
    }

    @Override
    public String toString() {
        return "You found a scroll with strange symobls on it.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }
}
