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

    /**
     * Enregistre une partie à partir des données contenues dans
     * le visualiseur de partie.
     */
    public static void enregistrerPartie(VisualiseurPartie visualiseurPartie) {
        JSONObject partie = new JSONObject();
        partie.put("plateaux", enregistrerPlateaux(visualiseurPartie));
        ecrireFichier(demanderFichier(), partie);
        System.out.println("Partie sauvegardée.");
    }

    /**
     * Demande à l'utilisateur d'entrer le nom du fichier souhaité.
     */
    static String demanderFichier(){
        System.out.print("Entrez le nom du fichier de sauvegarde: ");
        return new Scanner(System.in).nextLine();
    }

    /**
     * Enregistre les plateaux contenus dans le visualiseurPartie
     * sous forme de JSONArray.
     */
    static JSONArray enregistrerPlateaux(VisualiseurPartie visualiseurPartie) {
        JSONArray plateaux = new JSONArray();
        for(String s : visualiseurPartie.timelinePlateau){
            plateaux.put(s);
        }
        return plateaux;
    }

    /**
     * Écrit le contenu de la partie dans un fichier.
     */
    static void ecrireFichier(String nomFichier, JSONObject jeu){
        try {
            File partie = new File("./sauvegardes/"+ nomFichier);
            FileWriter writer = new FileWriter(partie);
            writer.write(jeu.toString(2));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la sauvegarde.");
        }
    }

}
