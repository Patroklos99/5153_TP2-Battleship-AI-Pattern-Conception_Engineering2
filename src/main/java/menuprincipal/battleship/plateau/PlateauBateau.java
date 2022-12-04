package menuprincipal.battleship.plateau;

import javafx.util.Pair;
import menuprincipal.battleship.bateau.Bateau;

import java.util.ArrayList;
import java.util.List;

public class PlateauBateau extends Plateau {

    private ArrayList<Bateau> bateaux;

    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        super.ajouterTir(coordonee);
    }

    public PlateauBateau() {
        super();
        bateaux = new ArrayList<Bateau>();
    }

    public void placerBateau(List<Pair<Integer, Integer>> coords) {
        for(Pair<Integer, Integer> coord : coords){
            cases[coord.getKey()][coord.getValue()] = Case.BATEAU;
        }
    }

    public boolean estCaseInnoccupee(Pair<Integer, Integer> coord){
        if(coord.getKey() >= TAILLE_PLATEAU || coord.getValue() >= TAILLE_PLATEAU ) return false;
        Case c = cases[coord.getKey()][coord.getValue()];
        return c == Case.AUCUN || c == Case.RATE;
    }

}
