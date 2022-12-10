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

    public Case ajouterTir(Coordonnee coordonnee){
        Case resultat = plateauBateauAdversaire.ajouterTir(coordonnee);
        setCase(coordonnee,resultat);
        return resultat;
    }

    public boolean aCouleTousBateaux(){
        return plateauBateauAdversaire.validerAllBateauCoules();
    }

}
