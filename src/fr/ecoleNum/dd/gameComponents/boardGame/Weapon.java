package fr.ecoleNum.dd.gameComponents.boardGame;

public class Weapon extends Case {
    private String name;
    private int attackLevel;

    public Weapon() {
        this("weapon",1);
    }

    public Weapon(String name, int attackLevel) {
        this.name = name;
        this.attackLevel = attackLevel;
    }

    @Override
    public String toString() {
        return "A weapon just lying on the side of the road. Weird...";
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
