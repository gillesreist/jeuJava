package fr.ecoleNum.dd.gameComponents.boardGame;

public class Weapon extends Case {
    private String name;
    private int attackLevel;

    public Weapon() {
        name = "sword";
        attackLevel = 1;
    }

    @Override
    public String toString() {
        return "A sword is stuck into a rock.";
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
