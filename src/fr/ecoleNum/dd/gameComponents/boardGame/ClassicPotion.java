package fr.ecoleNum.dd.gameComponents.boardGame;

public class ClassicPotion extends Potion{
    public ClassicPotion() {
        super("classicPotion");
    }

    public ClassicPotion(String name){
      super(name);
    }

    @Override
    public String toString() {
        return "You see an ordinary potion in the grass";
    }

}
