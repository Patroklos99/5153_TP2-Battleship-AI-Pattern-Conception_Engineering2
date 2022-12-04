package menuprincipal.jeu;

import menuprincipal.battleship.joueur.IAAvance;
import menuprincipal.battleship.joueur.IADebutant;
import menuprincipal.battleship.joueur.Joueur;
import menuprincipal.battleship.joueur.Personne;

import java.util.InputMismatchException;
import java.util.Scanner;


public class SelecteurModeJeu {

    private static final String DEMANDER_MODE_JEU =
            " ****************************\n" +
                    " ****** MODE DE JEU ******\n" +
                    " ****************************\n" +
                    " 1 - Jouer contre un ordinateur\n" +
                    " 2 - Jouer contre un humain\n";
    private static final String DEMANDER_DIFFICULTE =
            " ****************************\n" +
                    " ****** DIFFICULTÉ ******\n" +
                    " ****************************\n" +
                    " 1 - Ordinateur débutant\n" +
                    " 2 - Ordinateur avancé\n";
    private static final String CHOIX_INVALIDE = "Choix invalide";
    private static final String METHODE_NON_IMP = "Cette fonction n'est pas encore implémentée.";

    private static Joueur determinerDifficulte(){
        Joueur joueur = null;
        int choix = -1;
        do {
            System.out.print(DEMANDER_DIFFICULTE);
            try {
                choix = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.print(CHOIX_INVALIDE);
                System.exit(1);
            }

            switch (choix) {
                case 1:
                    return new IADebutant();
                case 2:
                    return  new IAAvance();
                default:
                    System.out.println(CHOIX_INVALIDE);
            }
        } while (true);
    }

    public static Joueur determinerModeJeu() {
        Joueur joueur = null;
        int choix = -1;
        do {
            System.out.print(DEMANDER_MODE_JEU);
            try {
                choix = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.print(CHOIX_INVALIDE);
                System.exit(1);
            }

            switch (choix) {
                case 1:
                    return determinerDifficulte();
                case 2:
                    System.out.println(METHODE_NON_IMP);
                    System.exit(1);
                    break;
                default:
                    System.out.println(CHOIX_INVALIDE);
            }
        } while (true);
    }
}
