package menuprincipal.battleship.plateau;

import javafx.util.Pair;

import java.util.Arrays;

public class PlateauTir extends Plateau {

    public boolean verifierTir(Pair<Integer, Integer> coordonoee, PlateauBateau plateauBateau) {
        return plateauBateau.cases[coordonoee.getKey()][coordonoee.getValue()] == Case.BATEAU;
    }

    public PlateauTir() {
        for (Case[] jay : cases)
            Arrays.fill(jay, Case.AUCUN);
    }

}
