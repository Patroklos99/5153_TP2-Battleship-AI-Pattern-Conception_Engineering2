package menuprincipal.jeu;

import javafx.util.Pair;
import lombok.Data;
import menuprincipal.battleship.joueur.Joueur;
import menuprincipal.battleship.plateau.Plateau;
import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;
import menuprincipal.battleship.plateau.PlateauxFactory;
import menuprincipal.frontend.AfficheurPartie;

import java.util.ArrayList;

@Data
public class Jeu {

    private static Jeu instanceJeu = null;

    final int MAX_JOUEURS = 2;
    final int MAX_PLATEAUX = 2;

    private Joueur[] joueurs;
    private PlateauBateau[] plateauBateaux = new PlateauBateau[MAX_PLATEAUX];
    private Plateau[] plateauTirs = new PlateauTir[MAX_PLATEAUX];


    private Jeu() {}
    public static Jeu getInstance() {
        if(instanceJeu == null)
            instanceJeu = new Jeu();

        return instanceJeu;
    }

    public void jouer() {
        determinerModeJeu();
        initialiserPlateaux();
        placerBateaux();

        Joueur gagnant = null;
        while(gagnant == null){
            effectuerProchaintour();
            gagnant = determinerGagnant();
        }

    }

    private void determinerModeJeu() {
        //TODO: Initialiser les joueurs basé sur le choix de l'utilisateur.
    }

    private void initialiserPlateaux() {
        PlateauxFactory plateauxFactory = new PlateauxFactory();
        plateauBateaux[0] = (PlateauBateau) plateauxFactory.makePlateau(plateauBateaux[0]);
        plateauBateaux[1] = (PlateauBateau) plateauxFactory.makePlateau(plateauBateaux[0]);
        plateauTirs [0] = plateauxFactory.makePlateau(plateauBateaux[0]);
        plateauTirs [1] = plateauxFactory.makePlateau(plateauBateaux[0]);
    }

    private void placerBateaux() {
        ArrayList<Pair<Integer,Integer>> localisatonBateaux = joueurs[0].demanderPlacerBateau();
        plateauBateaux[0].placerBateau(localisatonBateaux);
        joueurs[1].demanderPlacerBateau();
        //TODO: Demander aux joueurs de placer tout les bateaux.
    }

    private void effectuerProchaintour() {
        demanderTirJoueur(0);
        demanderTirJoueur(1);
    }

    private void demanderTirJoueur(int numeroJoueur){
        Pair<Integer,Integer> coordonnees;

        coordonnees = joueurs[numeroJoueur].demanderTir();
        plateauTirs[numeroJoueur].ajouterTir(coordonnees);

        //TODO: Afficher seulement si le joueur est humain
        AfficheurPartie.afficherPartie(plateauBateaux[numeroJoueur],plateauTirs[numeroJoueur]);
    }

    private Joueur determinerGagnant() {
        //TODO: Faire un check pour voir si un joueur est gagnant
        //Retourner le joueur gagnant, sinon, retourne null.
        return null;
    }
}
