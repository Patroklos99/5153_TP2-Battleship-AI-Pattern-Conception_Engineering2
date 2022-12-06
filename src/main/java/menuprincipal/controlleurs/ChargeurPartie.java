package menuprincipal.controlleurs;

import lombok.Data;
import org.json.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

@Data
public class ChargeurPartie {

    public static void chargerPartie() {
        JSONObject partie = chargerFichier();
        JSONArray plateaux = new JSONArray();
        try {
            plateaux = partie.getJSONArray("plateaux");
        }catch (JSONException e){
            System.out.println("Fichier invalide.");
            System.exit(1);
        }
        visualiserPartie(plateaux);
    }

    static void visualiserPartie(JSONArray plateaux){
        VisualiseurPartie visualiseurPartie = new VisualiseurPartie();
        for (int i = 0; i < plateaux.length(); i++) {
            visualiseurPartie.ajouterEtapeChargee(plateaux.getString(i));
        }
        visualiseurPartie.visualiserPartie();
        System.exit(0);
    }

    static String demanderFichier(){
        System.out.print("Entrez le chemin vers le fichier de sauvegarde: ");
        return new Scanner(System.in).nextLine();
    }

    static JSONObject chargerFichier(){
        JSONObject partie = new JSONObject();
        try {
            String sauvegarde = new String(Files.readAllBytes(Paths.get(demanderFichier())));
            partie = new JSONObject(sauvegarde);
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement.");
            System.exit(1);
        }
        return partie;
    }
}
