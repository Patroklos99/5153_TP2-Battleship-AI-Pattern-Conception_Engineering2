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
        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        do {
            afficherMenu();
            try {
                choix = scanner.nextInt();
            } catch(InputMismatchException e){ return choisirOption(); }

            if (choix == 1) return new Jeu();
            if (choix == 2) return ChargeurPartie.chargerPartie("test");
            if (choix == 3) System.exit(0);

            System.out.print(ERREUR);
        }while(true);
    }

    public static void main(String[] args) {
        Jeu battleship = choisirOption();
    }
}