package menuprincipal.battleship.plateau;

import javafx.util.Pair;

public abstract class Plateau {
    public Case[][] cases = new Case[40][40];

    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        cases[coordonee.getValue()][coordonee.getKey()] = Case.TOUCHE;
    }
}
