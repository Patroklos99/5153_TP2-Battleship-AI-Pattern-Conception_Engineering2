package menuprincipal.controlleurs;

import lombok.Data;
import org.json.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

@Data
public class ChargeurPartie {


    /**
     * Charge une partie à partir d'un fichier de sauvegarde
     * json.
     *
     */
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

    /**
     * Ajoute le contenu du fichier au visualiseur de partie,
     * puis visualise celle-ci.
     *
     * @param plateaux Les plateaux à ajouter.
     */
    static void visualiserPartie(JSONArray plateaux){
        VisualiseurPartie visualiseurPartie = new VisualiseurPartie();
        for (int i = 0; i < plateaux.length(); i++) {
            visualiseurPartie.ajouterEtapeChargee(plateaux.getString(i));
        }
        visualiseurPartie.visualiserPartie();
        System.exit(0);
    }

    /**
     * Demande à l'utilisateur d'entrer le chemin
     * vers le fichier de sauvegarde.
     */
    static String demanderFichier(){
        System.out.print("Entrez le chemin vers le fichier de sauvegarde: ");
        return new Scanner(System.in).nextLine();
    }

    /**
     * Charge un fichier à partir du chemin entré par l'utilisateur
     */
    static JSONObject chargerFichier(){
        JSONObject partie = new JSONObject();
        try {
            String sauvegarde = new String(Files.readAllBytes(Paths.get(demanderFichier())));
            partie = new JSONObject(sauvegarde);
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement. Le programme se terminera maintenant");
            System.exit(1);
        }
        return partie;
    }
}
