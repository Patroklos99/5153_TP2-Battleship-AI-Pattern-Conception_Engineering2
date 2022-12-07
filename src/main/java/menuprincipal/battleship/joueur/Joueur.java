package menuprincipal.battleship.joueur;

import javafx.util.Pair;
import menuprincipal.battleship.plateau.Coordonnee;

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

    abstract protected Coordonnee determinerTir();

    public Coordonnee demanderTir() {
        return determinerTir();
    }

    public List<Coordonnee> demanderPlacerBateau(int numeroBateau) {
        List<Coordonnee> bateau = new ArrayList<>();

        this.determinerPlacerBateau(bateau, numeroBateau);
        return bateau;
    }

    protected void determinerPlacerBateau(List<Coordonnee> coordonneBateau, int numeroBateau) {
        //à modifier (c'est pour les IA)
        //modifier aussi les diagrammes pour enlever la méthode dans les IA
        //coordonneBateau.addAll(List.of(new Pair<>(0,0), new Pair<>(0,1), new Pair<>(0,2), new Pair<>(0,3), new Pair<>(0,4)));
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
