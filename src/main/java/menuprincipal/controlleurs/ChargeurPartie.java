package menuprincipal.controlleurs;

import menuprincipal.jeu.Jeu;
import lombok.Data;
import org.json.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

@Data
public class ChargeurPartie {

    public static void chargerPartie() {
        Jeu jeu = Jeu.getInstance();
        JSONObject partie = chargerFichier();

        try {
            JSONArray plateaux = partie.getJSONArray("plateaux");
            JSONArray joueur1 = plateaux.getJSONArray("joueur1");
            JSONArray joueur2 = plateaux.getJSONArray("joueur2");
        }catch (JSONException e){
            System.out.println("Fichier invalide...");
            System.exit(1);
        }

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
        }
        return partie;
    }
}
