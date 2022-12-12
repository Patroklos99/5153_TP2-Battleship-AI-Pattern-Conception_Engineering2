package menuprincipal.jeu;

import lombok.Data;
import menuprincipal.battleship.joueur.Joueur;
import menuprincipal.battleship.joueur.Personne;
import menuprincipal.battleship.plateau.*;
import menuprincipal.controlleurs.EnregistreurPartie;
import menuprincipal.controlleurs.VisualiseurPartie;
import menuprincipal.frontend.AfficheurPartie;
import menuprincipal.jeu.phasesJeu.PhaseJeu;
import menuprincipal.jeu.phasesJeu.PhaseSelectionnerJoueurs;

import java.util.List;

@Data
public class Jeu {

    private static final String FIN_PARTIE = "Fin de la partie.";
    private static final String POSITION_INVALIDE = "Position invalide.";
    private static final String PLACER_PROCHAIN_BATEAU = "Appuyez sur 1 pour placer le prochain bateau";

    final int MAX_JOUEURS = 2;
    final int MAX_PLATEAUX = 2;
    final int NB_BATEAUX = 5;


    private PhaseJeu phase;

    private Joueur[] joueurs = new Joueur[MAX_JOUEURS];
    private PlateauBateau[] plateauBateaux = new PlateauBateau[MAX_PLATEAUX];
    private PlateauTir[] plateauTirs = new PlateauTir[MAX_PLATEAUX];

    public final int JOUEUR_1 = 0;
    public final int JOUEUR_2 = 1;

    private final VisualiseurPartie visualiseurPartie = new VisualiseurPartie();

    /**
     * Initialiser et commencer le jeu.
     * */
    public void jouer() {
        effectuerPhase(new PhaseSelectionnerJoueurs(this));
    }

    /**
     * Enregistrer le déroulement de la partie dans un fichier externe.
     * */
    public void enregistrer(){
        EnregistreurPartie.enregistrerPartie(visualiseurPartie);
    }

    /**
     * Visualiser le déroulement de la partie après la fin de la partie.
     * */
    public void visualiser() {
        visualiseurPartie.visualiserPartie();
    }

    /**
     * Exécuter la prochaine action à effectuer, tout dépendant de la phase de Jeu.
     * */
    public void prochaineAction(){
        phase.prochaineAction();
    }

    /**
     * Exécuter une phase de jeu.
     *
     * @param phase_ Prochaine phase à effectuer.
     * */
    public void effectuerPhase(PhaseJeu phase_){
        this.phase = phase_;
        prochaineAction();
    }

    /**
     * Demander à l'utilisateur contre qui jouer : un humain ou une IA.
     * */
    public void determinerModeJeu() {
        joueurs[JOUEUR_1] = new Personne();
        joueurs[JOUEUR_2] = SelecteurModeJeu.determinerModeJeu();
    }

    /**
     * Initialiser les plateaux de jeu des deux joueurs.
     * */
    public void initialiserPlateaux() {
        PlateauxFactory plateauxFactory = new PlateauxFactory();
        plateauBateaux[0] = (PlateauBateau) plateauxFactory.makePlateau(plateauBateaux, plateauBateaux[1]);
        plateauBateaux[1] = (PlateauBateau) plateauxFactory.makePlateau(plateauBateaux, plateauBateaux[1]);
        plateauTirs[0] = (PlateauTir) plateauxFactory.makePlateau(plateauTirs, plateauBateaux[1]);
        plateauTirs[1] = (PlateauTir) plateauxFactory.makePlateau(plateauTirs, plateauBateaux[0]);
    }

    /**
     * Demander au deux joueurs de placer leurs bateaux.
     * */
    public void placerBateaux() {
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
        ajouterEtapeVisualiseur();
    }

    /**
     * Demander aux deux joueurs d'effectuer leur tir sur les bateaux de leur adversaire.
     * Puis, tester s'il y a un gagnant et l'annoncer. Retourne vrai si un joueur est gagnant.
     *
     * @return Vrai si un des joueurs a coulé tous les bateaux de son adversaire.
     * */
    public boolean effectuerProchaintour() {
        Integer gagnant = null;

        if(effectuerTourJoueur(JOUEUR_1))
            gagnant = JOUEUR_1;
        else if (effectuerTourJoueur(JOUEUR_2)) {
            gagnant = JOUEUR_2;
        }

        AfficheurPartie.afficherPartie(plateauBateaux[JOUEUR_1], plateauTirs[JOUEUR_1]);
        visualiseurPartie.ajouterEtape(plateauBateaux[JOUEUR_1], plateauTirs[JOUEUR_1]);

        if(gagnant != null) {
            declarerGagnant(JOUEUR_1);
            return true;
        }

        return false;
    }

    /**
     * Demander à un joueur de placer ses bateaux. Retourne la réponse du joueur.
     *
     * @param joueurId ID du joueur à faire la demande (0 ou 1)
     * @param numeroBateau Le numero du bateau à placer, entre 0 à 4.
     *
     * @return Liste de coordonnées représentant la position des bateaux.
     * */
    public List<Coordonnee> demanderPlacerBateau(int joueurId, int numeroBateau) {
        List<Coordonnee> coords;
        boolean estValide;
        do {
            coords = joueurs[joueurId].demanderPlacerBateau(numeroBateau);
            estValide = estPlacementValide(coords, joueurId);
            if (!estValide && joueurs[joueurId] instanceof Personne) System.out.println(POSITION_INVALIDE);
        } while (!estValide);
        return coords;
    }

    private boolean estPlacementValide(List<Coordonnee> coords, int joueur) {
        for (Coordonnee coord : coords) {
            if (!plateauBateaux[joueur].estCaseInnoccupee(coord)) return false;
        }
        return true;
    }

    private boolean effectuerTourJoueur(int joueurId) {
        Coordonnee coordonnees = demanderTirJoueur(joueurId);
        plateauTirs[joueurId].ajouterTir(coordonnees);

        return plateauTirs[joueurId].aCouleTousBateaux();
    }

    /**
     * Demander à un joueur de tirer sur une case.
     *
     * @param numeroJoueur ID du joueur à faire la demande (0 ou 1)
     *
     * @return Coordonnée représentant la position d'un tir choisi par le joueur.
     * */
    public Coordonnee demanderTirJoueur(int numeroJoueur) {
        Coordonnee coord;
        boolean estValide;
        do {
            coord = joueurs[numeroJoueur].determinerTir(plateauTirs[numeroJoueur]);
            estValide = plateauBateaux[numeroJoueur].estCaseValide(coord);
            if (!estValide && joueurs[numeroJoueur] instanceof Personne) System.out.println(POSITION_INVALIDE);
        } while (!estValide);

        return coord;
    }

    private void ajouterEtapeVisualiseur(){
        visualiseurPartie.ajouterEtape(plateauBateaux[JOUEUR_1], plateauTirs[JOUEUR_1]);
    }

    private void declarerGagnant(Integer JoueurId) {
        JoueurId++;
        System.out.println(FIN_PARTIE);
        System.out.println("Gagnant: Joueur " + JoueurId.toString() + ".");
    }

}
