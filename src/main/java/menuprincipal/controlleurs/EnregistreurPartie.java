package menuprincipal.controlleurs;

import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;
import menuprincipal.jeu.Jeu;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnregistreurPartie {

    public static void enregistrerPartie(String nomFichier, Jeu jeu) {
        JSONObject etatJeu = new JSONObject();
        etatJeu.put("plateaux", enregistrerPlateaux(jeu.getPlateauBateaux(), jeu.getPlateauTirs()));
        try {
            File partie = new File("/sauvegardes"+ nomFichier + ".json");
            FileWriter writer = new FileWriter(partie);
            writer.write(etatJeu.toString(2));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la sauvegarde.");
            System.exit(1);
        }
        System.out.println("Partie sauvegardée.");
        System.exit(0);
    }

    static JSONObject enregistrerPlateaux(PlateauBateau[] platBat, PlateauTir[] platTir) {
        JSONObject plateaux = new JSONObject();
        plateaux.put("joueur1", enregistrerPlateauxJoueur(platBat[0].toString(),platTir[0].toString()));
        plateaux.put("joueur2", enregistrerPlateauxJoueur(platBat[1].toString(),platTir[1].toString()));
        return plateaux;
    }

    static JSONArray enregistrerPlateauxJoueur(String platBat, String platTir) {
        JSONArray platJoueur = new JSONArray();
        JSONObject platBatJoueur = new JSONObject();
        JSONObject platTirJoueur = new JSONObject();

        platBatJoueur.put("plateauBateau", platBat);
        platTirJoueur.put("plateauTir", platTir);
        platJoueur.put(platBatJoueur);
        platJoueur.put(platTirJoueur);

        return platJoueur;
    }

}
