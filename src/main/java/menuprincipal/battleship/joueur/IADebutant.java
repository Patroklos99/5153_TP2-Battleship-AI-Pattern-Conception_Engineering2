package menuprincipal.battleship.joueur;

import javafx.util.Pair;
import menuprincipal.battleship.plateau.Coordonnee;

import java.util.Random;

public class IADebutant extends Joueur{

    @Override
    protected Coordonnee determinerTir() {
        Random randomNum = new Random();
        int colonne = randomNum.nextInt(9 + 1);
        int rangee = randomNum.nextInt(9 + 1);
        return new Coordonnee(colonne,rangee);
    }


}
