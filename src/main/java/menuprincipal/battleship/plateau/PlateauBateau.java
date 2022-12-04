package menuprincipal.battleship.plateau;

import javafx.util.Pair;
import menuprincipal.battleship.bateau.Bateau;

import java.util.ArrayList;
import java.util.List;

public class PlateauBateau extends Plateau {

    private ArrayList<Bateau> bateaux;

    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        super.ajouterTir(coordonee);
    }

    /**
     * Représente le plateau inférieur qui contient les bateaux du joueur.
     * */
    public PlateauBateau() {
        super();
        bateaux = new ArrayList<Bateau>();
    }

    /**
     * @deprecated
     *
     * Utilisez placerNouveauBateau avec une liste de Coordonnee à la place.
     * */
    public void placerBateau(List<Pair<Integer, Integer>> coords) {
        ArrayList<Coordonnee> c = new ArrayList<Coordonnee>();
        for(Pair<Integer, Integer> coord : coords){
            c.add(new Coordonnee(coord.getKey(),coord.getValue()));
            cases[coord.getKey()][coord.getValue()] = Case.BATEAU;
        }

        bateaux.add(new Bateau(c));
    }

    /**
     * Place un nouveau bateau situé sur les coordonnées dans la liste.
     *
     * @param coords Liste de coordonnées représentant la position du bateau.
     * */
    public void placerNouveauBateau(List<Coordonnee> coords) {
        for(Coordonnee coord : coords){
            cases[coord.posH][coord.posV] = Case.BATEAU;
        }
        bateaux.add(new Bateau(coords));
    }

    /**
     * @deprecated
     *
     * Utilisez la version qui prend un objet Coordonnee.
     * */
    public boolean estCaseInnoccupee(Pair<Integer, Integer> coord){
        if(coord.getKey() >= TAILLE_PLATEAU || coord.getValue() >= TAILLE_PLATEAU ) return false;
        Case c = cases[coord.getKey()][coord.getValue()];
        return c == Case.AUCUN || c == Case.RATE;
    }

    /**
     * Vérifie si la case n'est pas occupée par un bateau ou un tir, et si elle existe.
     *
     * @return true si inoccupée, false si occupée ou non-existante.
     * */
    public boolean estCaseInnoccupee(Coordonnee coord){
        if(coord.posH >= TAILLE_PLATEAU || coord.posV >= TAILLE_PLATEAU ) return false;
        Case c = cases[coord.posH][coord.posV];
        return c == Case.AUCUN || c == Case.RATE;
    }

}
