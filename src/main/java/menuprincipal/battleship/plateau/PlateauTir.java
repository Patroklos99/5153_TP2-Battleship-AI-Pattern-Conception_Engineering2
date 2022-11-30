package menuprincipal.battleship.plateau;

import javafx.util.Pair;

import java.util.Arrays;

public class PlateauTir extends Plateau {
    private void verifierTir(Pair<Integer, Integer> coordonoee) {
        
    }

    public PlateauTir() {
        for (Case[] jay : cases)
            Arrays.fill(jay, Case.AUCUN);
    }

}
