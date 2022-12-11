package menuprincipal.controlleurs;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class ChargeurPartieTest {

    @Test
    void chargerPartie() throws IOException {
        String sauvegarde = new String(Files.readAllBytes(Paths.get("sauvegardes/exemple.json")));
        JSONObject partie = new JSONObject(sauvegarde);
        JSONArray plateaux = partie.getJSONArray("plateaux");
        Assertions.assertNotNull(plateaux);
    }

    @Test
    void visualiserPartie() {
    }

    @Test
    void demanderFichier() {
        ByteArrayInputStream in = new ByteArrayInputStream("sauvegardes/monfichier.json".getBytes());
        String test = new Scanner(in).nextLine();
        Assertions.assertEquals(test, "sauvegardes/monfichier.json");
    }

    @Test
    void chargerFichier() throws IOException {
        String sauvegarde = new String(Files.readAllBytes(Paths.get("sauvegardes/exemple.json")));
        JSONObject partie = new JSONObject(sauvegarde);
        Assertions.assertNotNull(partie);
    }
}