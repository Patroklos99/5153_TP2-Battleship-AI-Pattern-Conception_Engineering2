package menuprincipal.battleship.plateau;

import javafx.util.Pair;

import java.util.Arrays;

public class PlateauTir extends Plateau {

    private PlateauBateau plateauAdversaire;

    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        plateauAdversaire.ajouterTir(coordonee);
        super.ajouterTir(coordonee);
    }
    public boolean verifierTir(Pair<Integer, Integer> coordonoee, PlateauBateau plateauBateau) {
        return plateauBateau.cases[coordonoee.getKey()][coordonoee.getValue()] == Case.BATEAU;
    }

    public PlateauTir(PlateauBateau plateauAdversaire_) {
        plateauAdversaire = plateauAdversaire_;
        initialiserPlateau();
    }

}
