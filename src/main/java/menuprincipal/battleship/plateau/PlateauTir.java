package menuprincipal.battleship.plateau;

import javafx.util.Pair;

public class PlateauTir extends Plateau {

    private PlateauBateau plateauBateauAdversaire;


    /**
     * Représente le plateau supérieur qui contient les tirs effectués par le joueur.
     * */
    public PlateauTir(PlateauBateau plateauAdversaire_) {
        super();
        plateauBateauAdversaire = plateauAdversaire_;
    }

    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        plateauBateauAdversaire.ajouterTir(coordonee);
        super.ajouterTir(coordonee);
    }

    public Case ajouterTir(Coordonnee coordonnee){
        Case resultat = plateauBateauAdversaire.ajouterTir(coordonnee);
        setCase(coordonnee,resultat);
        return resultat;
    }

    /**
     * @deprecated
     *
     * Utilisez ajouterTir(Coordonnee coordonnee) à la place.
     * */
    public boolean verifierTir(Pair<Integer, Integer> coordonoee, PlateauBateau plateauBateau) {
        return plateauBateau.cases[coordonoee.getKey()][coordonoee.getValue()] == Case.BATEAU;
    }


}
