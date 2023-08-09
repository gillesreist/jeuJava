package fr.ecoleNum.dd.gameComponents.boardGame;

public class Dragon extends Foe {
    public Dragon(){
        super(15,4);
    }
    @Override
    public String toString() {
        return "A dragon is flying over you.";
    }
}
