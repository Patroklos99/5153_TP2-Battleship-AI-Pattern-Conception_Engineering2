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
            " 2 - Jouer une partie existante\n" +
            " 3 - Quitter\n";

    private static final String ERREUR = "Veuillez entrer un choix valide\n";

    private static void afficherMenu(){ System.out.print(MENU); }

    private static Jeu choisirOption(){
        int choix;
        do {
            afficherMenu();
            try {
                choix = new Scanner(System.in).nextInt();
            } catch(InputMismatchException e){
                System.out.print(ERREUR);
                return choisirOption();
            }

            if (choix == 1) return new Jeu();
            if (choix == 2) return ChargeurPartie.chargerPartie();
            if (choix == 3) System.exit(0);

            System.out.print(ERREUR);
        }while(true);
    }

    public static void main(String[] args) {
        Jeu battleship = choisirOption();
        battleship.jouer();
    }
}
