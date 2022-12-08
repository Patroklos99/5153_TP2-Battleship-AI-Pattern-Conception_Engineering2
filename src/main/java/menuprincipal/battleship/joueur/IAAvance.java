package menuprincipal.battleship.joueur;

import menuprincipal.battleship.plateau.Case;
import menuprincipal.battleship.plateau.Coordonnee;
import menuprincipal.battleship.plateau.PlateauTir;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class IAAvance extends Joueur {

    private final int ORIENTATION_HORIZONTALE = 0;
    private final int ORIENTATION_VERTICALE = 1;
    Coordonnee tirPivot = null;
    Coordonnee tirPrecedent = null;
    Case resultatTirPrecedent = null;
    int orientationBateau = -1;
    int directionTir = 0;
    int compteurChangementDirection = 0;

    @Override
    public Coordonnee determinerTir(PlateauTir pt) {
        Random randomNum = new Random();
        Coordonnee coordTir;

        if(tirPrecedent != null) {
            resultatTirPrecedent = pt.getCase(tirPrecedent);
            if(resultatTirPrecedent == Case.COULE)
                reinitialiserEtat();
        }

        if(tirPivot != null){
            coordTir = trouverProchaineCible(pt);
        }

        else {
            do {
                int colonne = randomNum.nextInt(9 + 1);
                int rangee = randomNum.nextInt(9 + 1);
                coordTir = new Coordonnee(colonne, rangee);
            } while (pt.getCase(coordTir) != Case.AUCUN);
        }

        tirPrecedent = coordTir;
        return coordTir;
    }

    private Coordonnee trouverProchaineCible(PlateauTir pt){
        Random randomNum = new Random();
        int axeChoisi;

        //Si on ne connait pas encore l'orientation du bateau, choisir un axe par où tirer.
        if( orientationBateau == -1) {
            orientationBateau = randomNum.nextInt(2);
        }

        // Choisir dans quelle direction tirer (direction positive ou négative dans l'axe)
        if(directionTir == 0)
            directionTir = randomNum.nextBoolean() ? 1 : -1;
        else if (resultatTirPrecedent == Case.RATE) {
            directionTir *= -1;
            compteurChangementDirection += 1;
        }

        if(compteurChangementDirection == 2){
            switch (orientationBateau) {
                case ORIENTATION_HORIZONTALE -> orientationBateau = ORIENTATION_VERTICALE;
                case ORIENTATION_VERTICALE -> orientationBateau = ORIENTATION_HORIZONTALE;
            }
        }

        Case etatCase = Case.TOUCHE;
        Coordonnee coordCible = new Coordonnee(tirPivot.posH, tirPivot.posV);

        //Tant qu'on ne pointe pas à une case vide...
        while(etatCase != Case.AUCUN){

            //incrémenter la coordonnée cible
            switch (orientationBateau) {
                case ORIENTATION_HORIZONTALE -> coordCible.posH += directionTir;
                case ORIENTATION_VERTICALE -> coordCible.posV += directionTir;
            }

            //Si on pointe toujours à l'intérieur du plateau
            if(coordCible.isValid()){
                //stocker l'état de la case pointé
                etatCase = pt.getCase(coordCible);
            } else {
                //sinon, recommencer du début.
                return trouverProchaineCible(pt);
            }
        }

        return coordCible;
    }

    private void reinitialiserEtat() {
        tirPivot = null;
        orientationBateau = -1;
        compteurChangementDirection = 0;
        directionTir = 0;
    }

}
