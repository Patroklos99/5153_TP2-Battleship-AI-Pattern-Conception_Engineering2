package menuprincipal.controlleurs;

import menuprincipal.jeu.Jeu;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

@Data
public class ChargeurPartie {

    public static void chargerPartie() {
        Jeu jeu = Jeu.getInstance();
        JSONObject partie = chargerFichier();

        JSONObject joueur1 = partie.getJSONObject("joueur1");
        JSONObject joueur2 = partie.getJSONObject("joueur2");

        System.out.println(joueur1);
        System.out.println(joueur2);

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
