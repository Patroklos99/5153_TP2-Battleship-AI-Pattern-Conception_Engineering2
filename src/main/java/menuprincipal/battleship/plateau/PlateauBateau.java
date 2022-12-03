package menuprincipal.battleship.plateau;

import javafx.util.Pair;

import java.util.ArrayList;

public class PlateauBateau extends Plateau {

    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        super.ajouterTir(coordonee);
    }

    public PlateauBateau() {
        super();
    }

    public void placerBateau(ArrayList<Pair<Integer, Integer>> localisatonBateaux) {
        for (var test : localisatonBateaux) {
            if(cases[test.getKey()][test.getValue()] == Case.AUCUN)
                cases[test.getKey()][test.getValue()] = Case.BATEAU;
        }
    }

    @Override
    public String toString() {
        String plateau = "";
        for(Case[] row : cases){
            for(Case c : row){
                if(c == Case.AUCUN) {
                    plateau += "_ ";
                }else{
                    plateau += "B ";
                }
            }
            plateau += "\n";
        }
        return plateau;
    }
}
