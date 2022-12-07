package menuprincipal.jeu;

import lombok.Data;
import menuprincipal.battleship.joueur.Joueur;
import menuprincipal.battleship.joueur.Personne;
import menuprincipal.battleship.plateau.*;
import menuprincipal.controlleurs.EnregistreurPartie;
import menuprincipal.controlleurs.VisualiseurPartie;
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

    private final VisualiseurPartie visualiseurPartie = new VisualiseurPartie();

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
        visualiseurPartie.ajouterEtape(plateauBateaux[0], plateauTirs[0]);

        while (gagnant == null) {
            effectuerProchaintour();
            gagnant = determinerGagnant();
            if (gagnant != null) System.out.println(FIN_PARTIE);
        }
        EnregistreurPartie.enregistrerPartie(visualiseurPartie);
        visualiseurPartie.visualiserPartie();
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
        List<Coordonnee> coords;
        for (int i = 0; i < BATEAUX_MAX; ++i) {
            AfficheurPartie.afficherPartie(plateauBateaux[JOUEUR_1], plateauTirs[JOUEUR_1]);
            coords = demanderPlacerBateau(JOUEUR_1, i);
            plateauBateaux[JOUEUR_1].placerNouveauBateau(coords);

            coords = demanderPlacerBateau(JOUEUR_2, i);
            plateauBateaux[JOUEUR_2].placerNouveauBateau(coords);
        }
        AfficheurPartie.afficherPartie(plateauBateaux[JOUEUR_1], plateauTirs[JOUEUR_1]);
    }

    private List<Coordonnee> demanderPlacerBateau(int joueur, int numeroBateau) {
        List<Coordonnee> coords;
        boolean estValide;
        do {
            coords = joueurs[joueur].demanderPlacerBateau(numeroBateau);
            estValide = estPlacementValide(coords, joueur);
            if (!estValide && joueurs[joueur] instanceof Personne) System.out.println(POSITION_INVALIDE);
        } while (!estValide);
        return coords;
    }

    private boolean estPlacementValide(List<Coordonnee> coords, int joueur) {
        for (Coordonnee coord : coords) {
            if (!plateauBateaux[joueur].estCaseInnoccupee(coord)) return false;
        }
        return true;
    }

    private void effectuerProchaintour() {
        Coordonnee coordonnees_1 = demanderTirJoueur(JOUEUR_1);
        plateauTirs[JOUEUR_1].ajouterTir(coordonnees_1);


        Coordonnee coordonnees_2 = demanderTirJoueur(JOUEUR_2);
        plateauTirs[JOUEUR_2].ajouterTir(coordonnees_2);

        AfficheurPartie.afficherPartie(plateauBateaux[JOUEUR_1], plateauTirs[JOUEUR_1]);
        visualiseurPartie.ajouterEtape(plateauBateaux[JOUEUR_1], plateauTirs[JOUEUR_1]);
    }


    private Coordonnee demanderTirJoueur(int numeroJoueur) {

        Coordonnee coord;
        boolean estValide;
        do {
            coord = joueurs[numeroJoueur].demanderTir();
            estValide = plateauBateaux[numeroJoueur].estCaseValide(coord);
            if (!estValide && joueurs[numeroJoueur] instanceof Personne) System.out.println(POSITION_INVALIDE);
        } while (!estValide);

        return coord;
    }

    private Joueur determinerGagnant() {
        if (plateauBateaux[JOUEUR_1].validerAllBateauCoules() || plateauBateaux[JOUEUR_1].validerAllBateauCoules())
            return joueurs[JOUEUR_1];
        return null;
    }

}
