package menuprincipal.battleship.plateau;

import javafx.util.Pair;
import menuprincipal.battleship.bateau.Bateau;

import java.util.ArrayList;
import java.util.List;

public class PlateauBateau extends Plateau {

    private ArrayList<Bateau> bateaux;

    /**
     * Représente le plateau inférieur qui contient les bateaux du joueur.
     * */
    public PlateauBateau() {
        super();
        bateaux = new ArrayList<Bateau>();
    }


    /**
     * Ajoute le tir dans le tableau correspondant
     *
     * @param coordonnee Cordonnee à tirer.
     * @return caseTouche le type d'enum de la case atteinte
     */
    @Override
    public Case ajouterTir(Coordonnee coordonnee){
        Case caseTouche = getCase(coordonnee);

        // Retourne Rate s'il n'y a pas de bateau à la coordonnée
        if(caseTouche == Case.AUCUN){
            setCase(coordonnee,Case.RATE);
            return Case.RATE;
        }

        // Retourne Touche ou Coule s'il y a un bateau.
        if(caseTouche == Case.BATEAU){
            Case resultat = Case.RATE;
            for(Bateau b : bateaux){
                resultat = b.tirerSur(coordonnee);
                if(resultat != Case.RATE)
                    break;
            }
            setCase(coordonnee,resultat);
            return resultat;
        }

        // Par défaut, retourne l'état de la case en tant que tel.
        return caseTouche;
    }

    /**
     * Place un nouveau bateau situé sur les coordonnées dans la liste.
     *
     * @param coords Liste de coordonnées représentant la position du bateau.
     * */
    public void placerNouveauBateau(List<Coordonnee> coords) {
        for(Coordonnee coord : coords)
            setCase(coord, Case.BATEAU);
        bateaux.add(new Bateau(coords));
    }

    /**
     * Vérifie si la case n'est pas occupée par un bateau ou un tir, et si elle existe.
     *
     * @return true si inoccupée, false si occupée ou non-existante.
     * */
    public boolean estCaseInnoccupee(Coordonnee coord){
        if(!estCaseValide(coord)) return false;
        Case c = getCase(coord);
        return c == Case.AUCUN || c == Case.RATE;
    }


    /**
     * Verifie si la case est valide par rapport à la grandeur du plateau
     *
     * @param coord unités des référence du tir
     * @return  si la case est valide
     */
    public boolean estCaseValide(Coordonnee coord){
       return coord.posH < TAILLE_PLATEAU && coord.posV < TAILLE_PLATEAU;
    }

    /**
     * Vérifie si tous les bateaux sont coulés, ce qui signifierait une défaite de la part du joueur.
     *
     * @return true si tous les bateaux sont coulés, sinon false.
     * */
    public boolean validerAllBateauCoules(){
        for(Bateau b : bateaux){
            if(!b.estCoule())
                return false;
        }
        return true;
    }

}
