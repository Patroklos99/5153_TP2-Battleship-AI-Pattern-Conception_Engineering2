package menuprincipal.battleship.bateau;

import javafx.util.Pair;
import menuprincipal.battleship.plateau.Case;
import menuprincipal.battleship.plateau.Coordonnee;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Bateau {
    private int pointDeVie;
    private Dictionary<Coordonnee,Boolean> coordonneeEstTouche;

    /**
     * Objet représentant bateau sur un plateau.
     *
     * @param coordonnees Liste de coordonnees représentant la position du bateau.
     * */
    public Bateau(List<Coordonnee> coordonnees){

        coordonneeEstTouche = new Hashtable<Coordonnee,Boolean>();
        for(Coordonnee coord: coordonnees){
            coordonneeEstTouche.put(coord,false);
        }

        pointDeVie = coordonnees.size();
    }

    /**
     * Tir sur le bateau, puis vérifie si le tir touche le bateau et s'il est coulé.
     *
     * @param tir Coordonnée du tir.
     * @return Case.RATE, Case.TOUCHE, ou Case.COULE, tout dépendant du tir et de l'état du bateau.
     * */
    public Case tirerSur (Coordonnee tir) {
        Boolean estTouche = coordonneeEstTouche.get(tir);

        // Si coordonnée ne fait pas partie du bateau, retourne "raté".
        if(estTouche == null){
            return Case.RATE;
        }

        // Si coordonnée n'est pas encore touchée, on le touche, décrémente les points de vie.
        if(!estTouche) {
            pointDeVie--;
            coordonneeEstTouche.put(tir,true);

            if(estCoule())
                return Case.COULE;

            return Case.TOUCHE;
        }

        // Si coordonnée est déjà touchée, retourne "raté".
        return Case.RATE;
    }

    /**
     * Retourne si le bateau est coulé ou non.
     *
     * @return true si bateau coulé, sinon false.
     * */
    public boolean estCoule() {
        return (pointDeVie == 0);
    }
}
