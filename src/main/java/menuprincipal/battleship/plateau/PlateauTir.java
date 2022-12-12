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

    /**
     * Ajoute un tir dans le tableau de l'adversaire
     *
     * @param coordonnee Cordonnee à cibler.
     * @return resultat le type d'enum de la case atteinte.
     */
    public Case ajouterTir(Coordonnee coordonnee){
        Case resultat = plateauBateauAdversaire.ajouterTir(coordonnee);
        setCase(coordonnee,resultat);
        return resultat;
    }

    /**
     * Verifie que toute la flotte des bateaux ont été coulés
     *
     * @return booleen correspondant si tous les bateaux ont été coulés
     */
    public boolean aCouleTousBateaux(){
        return plateauBateauAdversaire.validerAllBateauCoules();
    }

}
