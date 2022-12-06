package menuprincipal.controlleurs;

import javafx.util.Pair;
import menuprincipal.battleship.plateau.Plateau;
import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VisualiseurPartie {

    private final String VISUALISER = "Visualisation de la partie: ";
    private final String CONTINUER = "Appuyez sur entrée pour voir le prochain tour.";
    private final String FIN_VISUALISATION = "Fin de la visualisation.";

    public ArrayList<String> timelinePlateau;

    public VisualiseurPartie(){
        timelinePlateau = new ArrayList<>();
    }

    /**
     * Affiche à l'écran le contenu de timelinePlateau.
     *
     */
    public void visualiserPartie() {
        System.out.println(VISUALISER);
        for(String s : timelinePlateau){
            System.out.print(s);
            System.out.print(CONTINUER);
            new Scanner(System.in).nextLine();
        }
        System.out.println(FIN_VISUALISATION);
    }

    /**
     * Ajoute une étape au timelinePlateau à partir des
     * plateaux passés en argument.
     *
     * @param plateauBateau Le plateau de bateau du joueur
     * @param plateauTir Le plateau de tir du joueur
     */
    public void ajouterEtape(PlateauBateau plateauBateau, PlateauTir plateauTir) {
        timelinePlateau.add(plateauBateau.toString() + "\n" + plateauTir.toString());
    }

    /**
     * Ajoute une étape au timelinePlateau à partir des
     * String passés en argument.
     *
     * @param plateaux Le plateau de bateau et de tir, sous forme
     *                de String.
     */
    public void ajouterEtapeChargee(String plateaux) {
        timelinePlateau.add(plateaux);
    }
}
