package menuprincipal.battleship.plateau;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class PlateauBateau extends Plateau {
    @Override
    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        super.ajouterTir(coordonee);
    }

    public PlateauBateau() {
        for (Case[] row : cases)
            Arrays.fill(row, Case.AUCUN);
    }

    public boolean placerBateau(ArrayList<Pair<Integer, Integer>> localisatonBateaux) {
        for (var test : localisatonBateaux) {
            if(cases[test.getKey()][test.getValue()] != Case.AUCUN)
                return false;
            else
                cases[test.getKey()][test.getValue()] = Case.BATEAU;
        }
        return true;
    }

}
