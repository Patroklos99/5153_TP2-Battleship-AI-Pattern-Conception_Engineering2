package menuprincipal.frontend;

import menuprincipal.battleship.plateau.Plateau;

public class AfficheurPartie {

    private static final String PLATEAU_BATEAU = "Plateau de bateaux: ";
    private static final String PLATEAU_TIR = "Tirs effectués : ";

    public static void afficherPartie (Plateau pb, Plateau plateauTir) {
        System.out.println(PLATEAU_BATEAU);
        System.out.println(pb.toString());
        System.out.println(PLATEAU_TIR);
        System.out.println(plateauTir.toString());
    }
}
