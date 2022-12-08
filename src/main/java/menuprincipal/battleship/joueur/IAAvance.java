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

            //Si la case précédente était un touché
            if(resultatTirPrecedent == Case.TOUCHE) {
                //Attribuer le tir pivot à la même coordonnée que le tir précédent
                tirPivot = tirPrecedent;
            } else if(resultatTirPrecedent == Case.COULE) {
                //Sinon, si c'était un touché-coulé, on réinitialise l'état, pour que l'IA recommence
                // à chercher aléatoirement.
                reinitialiserEtat();
            }
        }

        if(tirPivot != null){
            //Si tirPivot n'est pas nul, cela veut dire que l'IA a trouvé un bateau et
            //  il essaiera activement de le couler en cherchant autour de la case tirPivot.

            coordTir = trouverProchaineCible(pt);
        } else {
            //Sinon, tirer sur une case aléatoire.
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

        int axeChoisi = choisirAxeTir();
        int directionChoisi = choisirDirectionTir();

        //Si ça fait deux fois qu'on change la direction du tir...
        if(compteurChangementDirection == 2){
            //Changer l'axe de tir.
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
        //Si on ne connait pas encore l'orientation du bateau, choisir un axe par où tirer.
        if( orientationBateau == -1) {
            axeChoisi = randomNum.nextInt(2);
        } else
            axeChoisi = orientationBateau;
        return axeChoisi;
    }

    private int choisirDirectionTir() {

        // Choisir dans quelle direction tirer (direction positive ou négative dans l'axe)
        int directionTirTemp;
        Random randomNum = new Random();

        //Si direction du Tir indéterminé
        if(directionTir == 0)
            //Choisir aléatoirement
            directionTirTemp = randomNum.nextBoolean() ? 1 : -1;
        else {
            //sinon...

            //Si résultat du tir précédent est raté...
            if (resultatTirPrecedent == Case.RATE) {
                //Changer la direction du tir
                directionTir *= -1;
                compteurChangementDirection += 1;
            }
            directionTirTemp = directionTir;
        }
        return directionTirTemp;
    }

    private Coordonnee determinerProchaineCible(int axeChoisi, int directionChoisi, PlateauTir pt) {
        Case etatCase = Case.TOUCHE;
        Coordonnee coordCible = new Coordonnee(tirPivot.posH, tirPivot.posV);

        //Tant qu'on ne pointe pas à une case vide...
        while(etatCase != Case.AUCUN){

            //incrémenter la coordonnée cible
            switch (axeChoisi) {
                case ORIENTATION_HORIZONTALE -> coordCible.posH += directionChoisi;
                case ORIENTATION_VERTICALE -> coordCible.posV += directionChoisi;
            }

            //Si on pointe toujours à l'intérieur du plateau
            if(coordCible.isValid()){
                //stocker l'état de la case pointé
                etatCase = pt.getCase(coordCible);
            } else {
                //Sinon, on recommence le procédé du début.
                //Cela évite que l'IA reste dans une boucle infinie.
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
