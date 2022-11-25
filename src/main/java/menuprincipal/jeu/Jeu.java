package menuprincipal.jeu;

import lombok.Data;
import javafx.util.Pair;
import menuprincipal.battleship.joueur.Joueur;
import menuprincipal.battleship.plateau.Plateau;
import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;
import menuprincipal.frontend.AfficheurPartie;

@Data
public class Jeu {

    private static Jeu instanceJeu = null;

    final int MAX_JOUEURS = 2;

    private Joueur[] joueurs;
    private PlateauBateau[] plateauBateaux;
    private PlateauTir[] plateauTirs;


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
        //TODO: Initialiser plateaux vides.
    }
    private void placerBateaux() {
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
