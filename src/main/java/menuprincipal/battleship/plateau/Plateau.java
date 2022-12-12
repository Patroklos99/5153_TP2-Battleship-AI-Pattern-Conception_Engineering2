package menuprincipal.battleship.plateau;

import javafx.util.Pair;

import java.util.Arrays;

public abstract class Plateau {

    private final static String COULEUR_AUCUN = "\u001B[34m\u001B[40m";
    private final static String COULEUR_RATE = "\u001B[37m\u001B[47m";
    private final static String COULEUR_TOUCHE = "\u001B[31m\u001B[41m";
    private final static String COULEUR_BATEAU = "\u001B[32m\u001B[40m";
    private final static String COULEUR_NORMAL = "\u001B[0m";
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
    public Case getCase(Coordonnee coordonnee){
        return cases[coordonnee.posH][coordonnee.posV];
    }

    /**
     * Modifie les valeurs desiŕees l'affichage en String des ceux-ci
     *
     * @return valeur de l'instance modifié pour l'affichage desiré
     */
    @Override
    public String toString() {
        String plateau = "";
        int numero = 1;
        for(Case[] row : cases){
            plateau += COULEUR_NORMAL;
            if (numero < 10) plateau += numero++ + "  ";
            else plateau += numero++ + " ";
            for(Case c : row){
                if(c == Case.AUCUN) {
                    plateau +=  COULEUR_AUCUN + "_ ";
                }else if(c == Case.BATEAU){
                    plateau += COULEUR_BATEAU + "B ";
                }else if(c == Case.TOUCHE){
                    plateau += COULEUR_TOUCHE + "X ";
                }else if(c == Case.COULE){
                    plateau += COULEUR_TOUCHE + "X ";
                }else if(c == Case.RATE){
                    plateau += COULEUR_RATE + "O ";
                }
            }
            plateau += COULEUR_NORMAL + "\n";
        }
        return plateau;
    }

}
