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

    public void visualiserPartie() {
        System.out.println(VISUALISER);
        for(String s : timelinePlateau){
            System.out.print(s);
            System.out.print(CONTINUER);
            new Scanner(System.in).nextLine();
        }
        System.out.println(FIN_VISUALISATION);
    }

    public void ajouterEtape(PlateauBateau plateauBateau, PlateauTir plateauTir) {
        timelinePlateau.add(plateauBateau.toString() + "\n" + plateauTir.toString());
    }
}
