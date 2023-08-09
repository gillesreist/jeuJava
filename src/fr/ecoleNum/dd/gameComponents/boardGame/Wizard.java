package fr.ecoleNum.dd.gameComponents.boardGame;

public class Wizard extends Foe {
    public Wizard(){
        super(9,2);
    }
    @Override
    public String toString() {
        return "Some weird guy shakes his wand.";
    }
}
