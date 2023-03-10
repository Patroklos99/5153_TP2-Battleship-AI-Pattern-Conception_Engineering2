package menuprincipal;

import menuprincipal.controlleurs.ChargeurPartie;
import menuprincipal.jeu.Jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    private static final String MENU =
            " ****************************\n" +
                    " ****** MENU PRINCIPAL ******\n" +
                    " ****************************\n" +
                    " 1 - Jouer une nouvelle partie\n" +
                    " 2 - Visualiser une partie \n" +
                    " 3 - Quitter\n";
    private static final String ERREUR = "Veuillez entrer un choix valide\n";

    /**
     * Affiche le menu de sélection du jeu
     */
    public static void afficherMenu() {
        System.out.print(MENU);
    }

    /**
     * Permet au joueur de choisir les options qui veut dans le jeu
     */
    private static void choisirOption() {
        int choix = -1;
        Jeu jeu = new Jeu();
        do {
            afficherMenu();
            try {
                choix = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                choix = -1;
            }

            switch (choix) {
                case 1:
                    jeu.jouer();
                    break;
                case 2:
                    ChargeurPartie.chargerPartie();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.print(ERREUR);
            }
        } while (true);
    }

    public static void main(String[] args) {
        choisirOption();
    }
}
