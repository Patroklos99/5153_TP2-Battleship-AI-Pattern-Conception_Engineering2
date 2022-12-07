package menuprincipal.battleship.joueur;

import menuprincipal.battleship.plateau.Coordonnee;
import menuprincipal.battleship.plateau.PlateauTir;

import java.util.Random;

public class IADebutant extends Joueur{

    @Override
    public Coordonnee determinerTir(PlateauTir plateauTir) {
        Random randomNum = new Random();
        int colonne = randomNum.nextInt(9 + 1);
        int rangee = randomNum.nextInt(9 + 1);
        return new Coordonnee(colonne,rangee);
    }


}
