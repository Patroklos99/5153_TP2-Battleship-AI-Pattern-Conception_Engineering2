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

    private final int DIR_POSIT = 1;
    private final int DIR_NEGAT = -1;
    private final int NON_DEFINED = 0;
    Coordonnee tirPivot;
    Coordonnee tirPrecedent;
    Case resultatTirPrecedent;
    int orientationBateau = -1;
    int directionTir = 0;
    int compteurChangementDirection = 0;

    @Override
    public Coordonnee determinerTir(PlateauTir pt) {
        Random randomNum = new Random();
        Coordonnee coordTir;

        if(tirPrecedent != null) {
            resultatTirPrecedent = pt.getCase(tirPrecedent);
            if(resultatTirPrecedent == Case.TOUCHE) {
                tirPivot = tirPrecedent;
            } else if(resultatTirPrecedent == Case.COULE) { //Forcer IA recommence à chercher aléatoirement.
                reinitialiserEtat();
            }
        }

        if(tirPivot != null){
            coordTir = trouverProchaineCible(pt); //essaiera de le couler en cherchant autour la case tirPivot.
        } else {
            do { //faire tir aleatoire
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
        int axeChoisi = choisirAxeTir();
        int directionChoisi = choisirDirectionTir();

        if(compteurChangementDirection == 2){ //Si deux fois qu'on change la direction du tir
            changerOrientationBateau();
            axeChoisi = orientationBateau;
        }
        return determinerProchaineCible(axeChoisi,directionChoisi,pt);
    }

    private void reinitialiserEtat() {
        tirPivot = null;
        orientationBateau = -1;
        compteurChangementDirection = 0;
        directionTir = 0;
    }

    private int choisirAxeTir() {
        int axeChoisi;
        Random randomNum = new Random();
        if(orientationBateau == -1) { //Si on connait pas l'orientation du bateau, choisir un axe par où tirer.
            axeChoisi = randomNum.nextInt(2);
        } else
            axeChoisi = orientationBateau;
        return axeChoisi;
    }

    private int choisirDirectionTir() { //direction + ou - dans l'axe
        int directionTirTemp;
        Random randomNum = new Random();
        if(directionTir == NON_DEFINED) { //choisir aleatoirement
            directionTirTemp = randomNum.nextBoolean() ? DIR_POSIT : DIR_NEGAT;
        } else {
            if (resultatTirPrecedent == Case.RATE) { //changer direction du tir
                directionTir *= DIR_NEGAT;
                compteurChangementDirection += DIR_POSIT;
            }
            directionTirTemp = directionTir;
        }
        return directionTirTemp;
    }

    private Coordonnee determinerProchaineCible(int axeChoisi, int directionChoisi, PlateauTir pt) {
        Case etatCase = Case.TOUCHE;
        Coordonnee coordCible = new Coordonnee(tirPivot.posH, tirPivot.posV);

        while(etatCase != Case.AUCUN){
            switch (axeChoisi) { //incrémenter la coordonnée cible
                case ORIENTATION_HORIZONTALE -> coordCible.posH += directionChoisi;
                case ORIENTATION_VERTICALE -> coordCible.posV += directionChoisi;
            }
            if(coordCible.isValid()) { //Si on pointe toujours à l'intérieur du plateau
                etatCase = pt.getCase(coordCible);
            } else { //procedé recommence du début. Evite IA reste dans boucle infinie.
                directionTir = 0;
                orientationBateau = -1;
                compteurChangementDirection = 0;
                return trouverProchaineCible(pt);
            }
        }
        orientationBateau = axeChoisi;
        return coordCible;
    }

    private void changerOrientationBateau(){
        switch (orientationBateau) {
            case ORIENTATION_HORIZONTALE -> orientationBateau = ORIENTATION_VERTICALE;
            case ORIENTATION_VERTICALE -> orientationBateau = ORIENTATION_HORIZONTALE;
        }
    }
}
