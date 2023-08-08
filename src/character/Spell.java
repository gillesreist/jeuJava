package character;

public class Spell {
    private String name;
    private int attackLevel;

    Spell() {
        name = "fireBolt";
        attackLevel = 2;
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
