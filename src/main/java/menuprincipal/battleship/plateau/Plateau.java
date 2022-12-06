package menuprincipal.battleship.plateau;

import javafx.util.Pair;

import java.util.Arrays;

public abstract class Plateau {

    protected static final int TAILLE_PLATEAU = 10;

    public Case[][] cases = new Case[TAILLE_PLATEAU][TAILLE_PLATEAU];

    /**
     * Classe abstraite représentant un des plateaux du jeu (plateau de tir supérieur ou plateau de bateaux inférieur)
     * */
    public Plateau() {
        for (Case[] row : cases)
            Arrays.fill(row, Case.AUCUN);
    }

    /**
     * @deprecated
     *
     * Utilisez la version qui prend un objet Coordonnee en paramètre.
     * */
    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        cases[coordonee.getValue()][coordonee.getKey()] = Case.TOUCHE;
    }

    /**
     * Tirer sur une coordonnee du plateau. Retourne le type de case touché.
     * Stock aussi l'état de la case après le tir (Ratée, Touché, Coulé).
     *
     * @param coordonnee Cordonnee à tirer.
     * @return Case.RATE, Case.TOUCHE, ou Case.COULE, tout dépendant si le bateau touché est coulé ou non.
     */
    abstract public Case ajouterTir(Coordonnee coordonnee);


    /**
     * Assigne un état à la case situé dans une coordonnée.
     *
     * @param coordonnee Coordonnee de la case.
     * @param caseEtat Nouvel état de la case.
     * */
    protected void setCase(Coordonnee coordonnee, Case caseEtat){
        cases[coordonnee.posH][coordonnee.posV] = caseEtat;
    }

    /**
     * Reçois l'état de la case situé dans une coordonnée.
     *
     * @param coordonnee Coordonnee de la case.
     *
     * @return État de la case.
     * */
    protected Case getCase(Coordonnee coordonnee){
        return cases[coordonnee.posH][coordonnee.posV];
    }

    @Override
    public String toString() {
        String plateau = "";
        int numero = 1;
        for(Case[] row : cases){
            if (numero < 10) plateau += numero++ + "  ";
            else plateau += numero++ + " ";
            for(Case c : row){
                if(c == Case.AUCUN) {
                    plateau += "_ ";
                }else if(c == Case.BATEAU){
                    plateau += "B ";
                }else if(c == Case.TOUCHE){
                    plateau += "X ";
                }else if(c == Case.COULE){
                    plateau += "X ";
                }else if(c == Case.RATE){
                    plateau += "O ";
                }
            }
            plateau += "\n";
        }
        return plateau;
    }

}
