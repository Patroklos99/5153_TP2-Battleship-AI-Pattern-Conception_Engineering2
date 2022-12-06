package menuprincipal.jeu;

import javafx.util.Pair;
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
            AfficheurPartie.afficherPartie(plateauBateaux[0], plateauTirs[0]);
            coords = demanderPlacerBateau(JOUEUR_1, i);
            plateauBateaux[JOUEUR_1].placerNouveauBateau(coords);

            coords = demanderPlacerBateau(JOUEUR_2, i);
            plateauBateaux[JOUEUR_2].placerNouveauBateau(coords);
        }
    }

    private List<Coordonnee> demanderPlacerBateau(int joueur, int numeroBateau) {
        List<Coordonnee> coords;
        boolean estValide;
        do {
            coords = joueurs[joueur].demanderPlacerBateau(numeroBateau);
            estValide = estPlacementValide(coords, joueur);
            if (!estValide) System.out.println(POSITION_INVALIDE);
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
        Coordonnee coordonnees_1 = demanderTirJoueur(0);
        plateauTirs[0].ajouterTir(coordonnees_1);

        Coordonnee coordonnees_2 = demanderTirJoueur(1);
        plateauTirs[1].ajouterTir(coordonnees_2);
        visualiseurPartie.ajouterEtape(plateauBateaux[0], plateauTirs[0]);
    }


    private Coordonnee demanderTirJoueur(int numeroJoueur) {
        Coordonnee coordonnees = joueurs[numeroJoueur].demanderTir();

        //TEMPORAIRE: À supprimer arpès que demanderTir() soit implémenté
        coordonnees = new Coordonnee(2, 2);
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
