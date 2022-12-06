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

    private static final String FIN_PARTIE = "Fin de la partie.";
    private static final String POSITION_INVALIDE = "Position invalide.";
    private static final String PLACER_PROCHAIN_BATEAU = "Appuyez sur 1 pour placer le prochain bateau";


    final int MAX_JOUEURS = 2;
    final int MAX_PLATEAUX = 2;
    final int NB_BATEAUX = 5;

    private Joueur[] joueurs = new Joueur[MAX_JOUEURS];
    private PlateauBateau[] plateauBateaux = new PlateauBateau[MAX_PLATEAUX];
    private PlateauTir[] plateauTirs = new PlateauTir[MAX_PLATEAUX];

    private final int JOUEUR_1 = 0;
    private final int JOUEUR_2 = 1;

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
            if (gagnant != null) System.out.println(FIN_PARTIE);
        }
    }

    private void determinerModeJeu() {
        joueurs[JOUEUR_1] = new Personne();
        joueurs[JOUEUR_2] = SelecteurModeJeu.determinerModeJeu();
    }

    private void initialiserPlateaux() {
        PlateauxFactory plateauxFactory = new PlateauxFactory();
        plateauBateaux[0] = (PlateauBateau) plateauxFactory.makePlateau(plateauBateaux, plateauBateaux[1]);
        plateauBateaux[1] = (PlateauBateau) plateauxFactory.makePlateau(plateauBateaux, plateauBateaux[1]);
        plateauTirs[0] = (PlateauTir) plateauxFactory.makePlateau(plateauTirs, plateauBateaux[1]);
        plateauTirs[1] = (PlateauTir) plateauxFactory.makePlateau(plateauTirs, plateauBateaux[0]);
    }

    private void placerBateaux() {
        final int BATEAUX_MAX = 5;
        List<Pair<Integer, Integer>> coords;
        for (int i = 0; i < BATEAUX_MAX; ++i) {
            AfficheurPartie.afficherPartie(plateauBateaux[0], plateauTirs[0]);
            coords = demanderPlacerBateau(JOUEUR_1, i);
            plateauBateaux[JOUEUR_1].placerBateau(coords);

            coords = demanderPlacerBateau(JOUEUR_2, i);
            plateauBateaux[JOUEUR_2].placerBateau(coords);
        }
    }

    private List<Pair<Integer, Integer>> demanderPlacerBateau(int joueur, int numeroBateau) {
        List<Pair<Integer, Integer>> coords;
        boolean estValide;
        do {
            coords = joueurs[joueur].demanderPlacerBateau(numeroBateau);
            estValide = estPlacementValide(coords, joueur);
            if (!estValide) System.out.println(POSITION_INVALIDE);
        } while (!estValide);
        return coords;
    }

    private boolean estPlacementValide(List<Pair<Integer, Integer>> coords, int joueur) {
        for (Pair<Integer, Integer> coord : coords) {
            if (!plateauBateaux[joueur].estCaseInnoccupee(coord)) return false;
        }
        return true;
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
        coordonnees = new Pair<Integer, Integer>(2, 2);
        plateauTirs[numeroJoueur].ajouterTir(coordonnees);

        if (joueurs[numeroJoueur] instanceof Personne) //Afficher si jouer humain,
            AfficheurPartie.afficherPartie(plateauBateaux[numeroJoueur], plateauTirs[numeroJoueur]);
        return coordonnees;
    }

    private Joueur determinerGagnant() {
        if (plateauBateaux[0].validerAllBateauCoules() || plateauBateaux[1].validerAllBateauCoules())
            return new Personne();
        return null;
    }

}
