package menuprincipal.frontend;

import menuprincipal.battleship.plateau.Plateau;

public class AfficheurPartie {

    private static final String PLATEAU_BATEAU = "Plateau de bateaux: ";
    private static final String PLATEAU_TIR = "Tirs effectués : ";
    private static final String COLUMN_LETTRES = "  1 2 3 4 5 6 7 8 9 10";

    public static void afficherPartie (Plateau plateau_b, Plateau plateau_t) {
        System.out.println(PLATEAU_BATEAU);
        System.out.println(COLUMN_LETTRES);
        System.out.println(plateau_b.toString());
        System.out.println(PLATEAU_TIR);
        System.out.println(COLUMN_LETTRES);
        System.out.println(plateau_t.toString());
    }
}
