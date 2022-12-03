package menuprincipal.jeu;

import javafx.util.Pair;
import lombok.Data;
import menuprincipal.battleship.joueur.*;
import menuprincipal.battleship.plateau.*;
import menuprincipal.controlleurs.ChargeurPartie;
import menuprincipal.frontend.AfficheurPartie;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Data
public class Jeu {

    private static Jeu instanceJeu = null;

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
    private static final String FIN_PARTIE = "Fin de la partie.";
    private static final String CHOIX_INVALIDE = "Choix invalide";
    private static final String METHODE_NON_IMP = "Cette fonction n'est pas encore implémentée.";


    final int JOUEUR_1 = 0;
    final int JOUEUR_2 = 1;

    final int MAX_JOUEURS = 2;
    final int MAX_PLATEAUX = 2;

    private Joueur[] joueurs = new Joueur[MAX_JOUEURS];
    private PlateauBateau[] plateauBateaux = new PlateauBateau[MAX_PLATEAUX];
    private PlateauTir[] plateauTirs = new PlateauTir[MAX_PLATEAUX];

    private Jeu() {
    }

    public static Jeu getInstance() {
        if (instanceJeu == null)
            instanceJeu = new Jeu();
        return instanceJeu;
    }

    public void jouer() {
        Joueur gagnant = null;
        determinerModeJeu();
        initialiserPlateaux();
        placerBateaux();

        while (gagnant == null) {
            effectuerProchaintour();
            gagnant = determinerGagnant();
            if(gagnant != null) System.out.println(FIN_PARTIE);
        }
    }

    private void determinerDifficulte(){
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
                    joueurs[JOUEUR_2] = new IADebutant();
                    break;
                case 2:
                    joueurs[JOUEUR_2] = new IAAvance();
                    break;
                default:
                    System.out.print(CHOIX_INVALIDE);
            }
        } while (choix == -1);
    }

    private void determinerModeJeu() {
        int choix = -1;
        joueurs[JOUEUR_1] = new Personne();
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
                    determinerDifficulte();
                    break;
                case 2:
                    System.out.println(METHODE_NON_IMP);
                    System.exit(1);
                    break;
                default:
                    System.out.print(CHOIX_INVALIDE);
            }
        } while (choix == -1);
    }

    private void initialiserPlateaux() {
        PlateauxFactory plateauxFactory = new PlateauxFactory();
        plateauBateaux[0] = (PlateauBateau) plateauxFactory.makePlateau(plateauBateaux, plateauBateaux[1]);
        plateauBateaux[1] = (PlateauBateau) plateauxFactory.makePlateau(plateauBateaux, plateauBateaux[1]);
        plateauTirs[0] = (PlateauTir) plateauxFactory.makePlateau(plateauTirs, plateauBateaux[1]);
        plateauTirs[1] = (PlateauTir) plateauxFactory.makePlateau(plateauTirs, plateauBateaux[0]);
    }

    private void placerBateaux() {
        ArrayList<Pair<Integer, Integer>> localisatonBateaux_1 = joueurs[0].demanderPlacerBateau();
        plateauBateaux[0].placerBateau(localisatonBateaux_1);
        ArrayList<Pair<Integer, Integer>> localisatonBateaux_2 = joueurs[1].demanderPlacerBateau();
        plateauBateaux[1].placerBateau(localisatonBateaux_2);
    }

    private void effectuerProchaintour() {
        Pair<Integer, Integer> coordonnees_1 = demanderTirJoueur(0);
        Pair<Integer, Integer> coordonnees_2 = demanderTirJoueur(1);
        if (!plateauTirs[0].verifierTir(coordonnees_1, plateauBateaux[1]))
            plateauBateaux[0].cases[coordonnees_1.getKey()][coordonnees_1.getValue()] = Case.BATEAU;
        if (!plateauTirs[1].verifierTir(coordonnees_2, plateauBateaux[0]))
            plateauBateaux[1].cases[coordonnees_2.getKey()][coordonnees_2.getValue()] = Case.BATEAU;
    }

    private Pair<Integer, Integer> demanderTirJoueur(int numeroJoueur) {
        Pair<Integer, Integer> coordonnees = joueurs[numeroJoueur].demanderTir();

        //TEMPORAIRE: À supprimer arpès que demanderTir() soit implémenté
        coordonnees = new Pair<Integer,Integer>(2,2);

        plateauTirs[numeroJoueur].ajouterTir(coordonnees); ////// <<<<<<<<<<<<<<<<<<<<<<<<

        //TODO: Afficher seulement si le joueur est humain
        AfficheurPartie.afficherPartie(plateauBateaux[numeroJoueur], plateauTirs[numeroJoueur]);
        return coordonnees;
    }

    private Joueur determinerGagnant() {
        //TODO: Faire un check pour voir si un joueur est gagnant
        //Retourner le joueur gagnant, sinon, retourne null.
        //Retourne une Personne pour que le jeu s'arrête après avoir placé les bateaux
        return new Personne();
    }
}
