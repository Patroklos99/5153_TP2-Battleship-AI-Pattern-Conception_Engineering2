package menuprincipal.controlleurs;

import menuprincipal.jeu.Jeu;
import mockit.Mocked;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static menuprincipal.controlleurs.ChargeurPartie.*;
import static org.mockito.Mockito.mock;

class ChargeurPartieTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    void chargerPartieTest() throws IOException {
        System.setIn(new ByteArrayInputStream("sauvegardes/exemple.json".getBytes()));
        VisualiseurPartie v = new VisualiseurPartie();
        Assertions.assertNotNull(v.timelinePlateau);
    }

    @Test
    void visualiserPartieTest() throws IOException {
    }

    @Test
    void demanderFichierTest() {
        System.setIn(new ByteArrayInputStream("fichier.test".getBytes()));
       Assertions.assertEquals(ChargeurPartie.demanderFichier(), "fichier.test");
    }

    @Test
    void chargerFichierTest() throws IOException {
        System.setIn(new ByteArrayInputStream("sauvegardes/exemple.json".getBytes()));
        Assertions.assertNotNull(chargerFichier());
    }
}