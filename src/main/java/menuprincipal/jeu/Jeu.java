package menuprincipal.jeu;

import javafx.util.Pair;
import lombok.Data;
import menuprincipal.battleship.joueur.Joueur;
import menuprincipal.battleship.joueur.Personne;
import menuprincipal.battleship.plateau.Case;
import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;
import menuprincipal.battleship.plateau.PlateauxFactory;
import menuprincipal.frontend.AfficheurPartie;

import java.util.List;

@Data
public class Jeu {

    private static Jeu instanceJeu = null;

    final int MAX_JOUEURS = 2;
    final int MAX_PLATEAUX = 2;

    private Joueur[] joueurs = new Joueur[MAX_JOUEURS];
    private PlateauBateau[] plateauBateaux = new PlateauBateau[MAX_PLATEAUX];
    private PlateauTir[] plateauTirs = new PlateauTir[MAX_PLATEAUX];


    public Jeu() {
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
        }
    }

    private void determinerModeJeu() {
        //TODO: Initialiser les joueurs basé sur le choix de l'utilisateur.
        joueurs[0] = new Personne();
        joueurs[1] = new Personne();
    }

    private void initialiserPlateaux() {
        PlateauxFactory plateauxFactory = new PlateauxFactory();
        plateauBateaux[0] = (PlateauBateau) plateauxFactory.makePlateau(plateauBateaux, plateauBateaux[1]);
        plateauBateaux[1] = (PlateauBateau) plateauxFactory.makePlateau(plateauBateaux, plateauBateaux[1]);
        plateauTirs[0] = (PlateauTir) plateauxFactory.makePlateau(plateauTirs, plateauBateaux[1]);
        plateauTirs[1] = (PlateauTir) plateauxFactory.makePlateau(plateauTirs, plateauBateaux[0]);
    }

    private void placerBateaux() {
        // Demander aux joueurs de placer tout les bateaux.
        List<List<Pair<Integer, Integer>>> localisatonBateaux_1 = joueurs[0].demanderPlacerBateau();
        plateauBateaux[0].placerBateau(localisatonBateaux_1);
        List<List<Pair<Integer, Integer>>> localisatonBateaux_2 = joueurs[1].demanderPlacerBateau();
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
        return null;
    }
}
