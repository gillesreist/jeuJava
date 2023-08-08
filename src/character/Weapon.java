package character;

public class Weapon {
    private String name;
    private int attackLevel;

    Weapon() {
        name = "sword";
        attackLevel = 1;
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
