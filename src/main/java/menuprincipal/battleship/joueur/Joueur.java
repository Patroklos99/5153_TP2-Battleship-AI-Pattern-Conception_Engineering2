package menuprincipal.battleship.joueur;

import menuprincipal.battleship.plateau.Coordonnee;
import menuprincipal.battleship.plateau.PlateauTir;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Joueur {

    /**
     * Détermine les autres coordonnées du bateau à l'aide de la case de départ et l'orientation
     * @param orientation l'orientation du bateau
     * @param tailleBateau la taille du bateau demandé
     * @param caseDepart la case de départ du bateau
     * @param coordonneBateau les coordonnées du bateau à placer
     */
    private void determinerAutresCases(int orientation, int tailleBateau, Coordonnee caseDepart, List<Coordonnee> coordonneBateau){
        for(int i = 1; i < tailleBateau; i++){
            if(orientation == 0){
                // la colonne change (on reste sur la même rangée)
                coordonneBateau.add(new Coordonnee(caseDepart.posH + i, caseDepart.posV));
            }else{
                coordonneBateau.add(new Coordonnee(caseDepart.posH, caseDepart.posV + i));
            }

        }

    }

    /**
     * Détermine la case de départ (coordonnée) du bateau
     * @param orientation l'orientation du bateau
     * @param tailleBateau la taille du bateau demandé
     * @return la case de départ du bateau
     */
    private Coordonnee determinerCaseDepart(int orientation, int tailleBateau){
        Random randomNum = new Random();
        int colonne;
        int rangee;
        if(orientation == 0){
            // min + randomNum.nextInt(max - min + 1)
            rangee = randomNum.nextInt(9 + 1);
            colonne = randomNum.nextInt(9 - tailleBateau + 1 + 1);
        }else{
            colonne = randomNum.nextInt(9 + 1);
            rangee = randomNum.nextInt(9 - tailleBateau + 1 + 1);
        }
        return new Coordonnee(colonne,rangee);
    }

    /**
     * Détermine les coordonnées du bateau
     * @param tailleBateau la taille du bateau demandé
     * @param coordonneBateau les coordonnées du bateau à placer
     * @param orientation l'orientation du bateau
     */
    private void determinerBateau(int tailleBateau, List<Coordonnee> coordonneBateau, int orientation){
        Coordonnee caseDepart = determinerCaseDepart(orientation,tailleBateau);
        coordonneBateau.add(caseDepart);
        determinerAutresCases(orientation,tailleBateau,caseDepart,coordonneBateau);
    }

    /**
     * Détermine l'orientation du bateau à placer
     * @return 0 si le bateau est horizontal, 1 si le bateau est vertical
     */
    private int determinerOrientation(){
        Random randomNum = new Random();
        return randomNum.nextInt(2);
    }

    /**
     * Retourne le tir du joueur
     * @param plateauTir le plateau de tir du joueur
     * @return la coordonnée du tir
     */
    public Coordonnee determinerTir(PlateauTir plateauTir) {
        return null;
    }

    /**
     * Retourne les coordonnées du bateau du joueur
     * @param numeroBateau le numéro de bateau à placer (0 à 4)
     * @return les coordonnées du bateau du joueur
     */
    public List<Coordonnee> demanderPlacerBateau(int numeroBateau) {
        List<Coordonnee> bateau = new ArrayList<>();

        this.determinerPlacerBateau(bateau, numeroBateau);
        return bateau;
    }

    /**
     * Ajout des coordonnées du bateau dans la variable coordonneeBateau
     * @param coordonneBateau les coordonnées du bateau
     * @param numeroBateau le numéro du bateau
     */
    protected void determinerPlacerBateau(List<Coordonnee> coordonneBateau, int numeroBateau) {
        int orientation;

        switch (numeroBateau){
            case 0:
                orientation = determinerOrientation();
                determinerBateau(5, coordonneBateau, orientation);
                break;
            case 1:
                orientation = determinerOrientation();
                determinerBateau(4, coordonneBateau, orientation);
                break;
            case 2:
            case 3:
                orientation = determinerOrientation();
                determinerBateau(3, coordonneBateau, orientation);
                break;
            case 4:
                orientation = determinerOrientation();
                determinerBateau(2, coordonneBateau, orientation);
                break;
        }

    }
}
