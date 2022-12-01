package menuprincipal.battleship.plateau;

import javafx.util.Pair;

import java.util.Arrays;

public abstract class Plateau {
    public Case[][] cases = new Case[40][40];

    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        cases[coordonee.getValue()][coordonee.getKey()] = Case.TOUCHE;
    }

    public Plateau() {
        for (Case[] row : cases)
            Arrays.fill(row, Case.AUCUN);
    }

}
