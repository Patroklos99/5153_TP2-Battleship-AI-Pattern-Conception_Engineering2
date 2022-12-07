package menuprincipal.battleship.joueur;

import menuprincipal.battleship.plateau.Case;
import menuprincipal.battleship.plateau.Coordonnee;
import menuprincipal.battleship.plateau.PlateauTir;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class IAAvance extends Joueur {

    Coordonnee coordPrecendeteValide;

    @Override
    public Coordonnee determinerTir(PlateauTir pt) {
        Random randomNum = new Random();
        int colonne = randomNum.nextInt(9 + 1);
        int rangee = randomNum.nextInt(9 + 1);
        //Si plateau n'a aucun tir, on garde le premier tir
        if (Arrays.stream(new String[]{pt.toString()}).allMatch(e -> Objects.equals(e, "_"))) {
            if (pt.ajouterTir(new Coordonnee(colonne, rangee)) == Case.TOUCHE)
                coordPrecendeteValide = new Coordonnee(colonne, rangee);
            return new Coordonnee(colonne, rangee);
            //autrement on verifie si le dernier tir à touché
        } else if (pt.cases[coordPrecendeteValide.posH][coordPrecendeteValide.posV] == Case.TOUCHE) {
                //Obtenir les cases (2min - 4 max) au tour de la coordonne_precendante valide
                //les mettres dans un array. prendre 1/2 de probabilité de prendre una case correct




                //update du coordPrecenteValide si on a touché una nouvelle case
                if (pt.ajouterTir(new Coordonnee(colonne, rangee)) == Case.TOUCHE) {
                    coordPrecendeteValide = new Coordonnee(colonne, rangee);
            }
            return new Coordonnee(colonne, rangee);
        }
        return null;
    }

}
