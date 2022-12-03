package menuprincipal.battleship.plateau;

import javafx.util.Pair;

import java.util.Arrays;

public abstract class Plateau {

    protected static final int TAILLE_PLATEAU = 10;

    public Case[][] cases = new Case[TAILLE_PLATEAU][TAILLE_PLATEAU];

    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        cases[coordonee.getValue()][coordonee.getKey()] = Case.TOUCHE;
    }

    public Plateau() {
        for (Case[] row : cases)
            Arrays.fill(row, Case.AUCUN);
    }

    @Override
    public String toString() {
        String plateau = "";
        for(Case[] row : cases){
            for(Case c : row){
                if(c == Case.AUCUN) {
                    plateau += "_ ";
                }else if(c == Case.BATEAU){
                    plateau += "B ";
                }else if(c == Case.TOUCHE){
                    plateau += "T ";
                }else if(c == Case.COULE){
                    plateau += "C ";
                }else if(c == Case.RATE){
                    plateau += "R ";
                }
            }
            plateau += "\n";
        }
        return plateau;
    }

}
