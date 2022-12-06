package menuprincipal.controlleurs;

import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;
import menuprincipal.jeu.Jeu;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EnregistreurPartie {

    public static void enregistrerPartie(VisualiseurPartie visualiseurPartie) {
        JSONObject partie = new JSONObject();
        partie.put("plateaux", enregistrerPlateaux(visualiseurPartie));
        ecrireFichier(demanderFichier(), partie);
        System.out.println("Partie sauvegardée.");
    }

    static String demanderFichier(){
        System.out.print("Entrez le chemin vers le fichier de sauvegarde: ");
        return new Scanner(System.in).nextLine();
    }

    static JSONArray enregistrerPlateaux(VisualiseurPartie visualiseurPartie) {
        JSONArray plateaux = new JSONArray();
        for(String s : visualiseurPartie.timelinePlateau){
            plateaux.put(s);
        }
        return plateaux;
    }

    static void ecrireFichier(String nomFichier, JSONObject etatJeu){
        try {
            File partie = new File("./parties/"+ nomFichier);
            FileWriter writer = new FileWriter(partie);
            writer.write(etatJeu.toString(2));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la sauvegarde.");
        }
    }

}
