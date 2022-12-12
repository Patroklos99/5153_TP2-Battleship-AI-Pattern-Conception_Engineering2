package menuprincipal.jeu;

import menuprincipal.battleship.joueur.IAAvance;
import menuprincipal.battleship.joueur.IADebutant;
import menuprincipal.battleship.joueur.Joueur;

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

    /**
     * Choisi la difficulté de l'intelligence artificielle
     * @return L'IA que le joueur veut
     */
    public static Joueur determinerDifficulte() {
        int choix = -1;
        while (true) {
            System.out.print(DEMANDER_DIFFICULTE);
            try {
                choix = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                choix = -1;
            }
            switch (choix) {
                case 1 : return new IADebutant();
                case 2 : return new IAAvance();
                default: System.out.println(CHOIX_INVALIDE);
            }
        }
    }

    /**
     * Choisi si le deuxième joueur est une personne ou une IA
     * @return le type de joueur souhaité
     */
    public static Joueur determinerModeJeu() {
        int choix = -1;
        while (true) {
            System.out.print(DEMANDER_MODE_JEU);
            try {
                choix = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                choix = -1;
            }

            switch (choix) {
                case 1:
                    return determinerDifficulte();
                case 2:
                    System.out.println(METHODE_NON_IMP);
                    break;
                default:
                    System.out.println(CHOIX_INVALIDE);
            }
        }
    }
}
