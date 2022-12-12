package menuprincipal.battleship.joueur;

import menuprincipal.battleship.plateau.Coordonnee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IADebutantTest {

    @Test
    void testDeterminerTir() {
        Joueur joueurIA = new IADebutant();
        Coordonnee coordonneTest = joueurIA.determinerTir(null);
        assertTrue(coordonneTest.posH > -1 && coordonneTest.posH < 10);
        assertTrue(coordonneTest.posV > -1 && coordonneTest.posV < 10);
    }
}