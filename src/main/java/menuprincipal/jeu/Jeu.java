package menuprincipal.jeu;

import lombok.Data;
import javafx.util.Pair;
import menuprincipal.battleship.joueur.Joueur;
import menuprincipal.battleship.plateau.Plateau;
import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;

@Data
public class Jeu {

    private static Jeu instanceJeu = null;

    private Joueur joueur1, joueur2;
    private PlateauBateau plateauBateau_joueur1, plateauBateau_joueur2;
    private PlateauTir plateauTir_joueur1, plateauTir_joueur2;


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

    private void actualiserPlateau(Pair<Integer, Integer> pair, PlateauTir plateau) {
        //TODO: actualiser la case d'un plateau, avec le tir choisi par un joueur.
    }

    private void effectuerProchaintour() {
        //TODO: Demander aux deux joueurs de choisir une case où tirer.
    }

    private Joueur determinerGagnant() {
        //TODO: Faire un check pour voir si un joueur est gagnant
        //Retourner le joueur gagnant, sinon, retourne null.
        return null;
    }
}
