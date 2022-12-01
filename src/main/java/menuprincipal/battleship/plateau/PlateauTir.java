package menuprincipal.battleship.plateau;

import javafx.util.Pair;

public class PlateauTir extends Plateau {

    private PlateauBateau plateauBateauAdversaire;

    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        plateauBateauAdversaire.ajouterTir(coordonee);
        super.ajouterTir(coordonee);
    }

    public PlateauTir(PlateauBateau plateauAdversaire_) {
        super();
        plateauBateauAdversaire = plateauAdversaire_;
    }

    public boolean verifierTir(Pair<Integer, Integer> coordonoee, PlateauBateau plateauBateau) {
        return plateauBateau.cases[coordonoee.getKey()][coordonoee.getValue()] == Case.BATEAU;
    }


}
