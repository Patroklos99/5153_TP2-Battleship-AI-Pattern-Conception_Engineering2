package menuprincipal.battleship.joueur;

import menuprincipal.battleship.plateau.Coordonnee;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    @Test
    void testDeterminerPlacerBateauPorteAvion() {
        Joueur joueurPersonne = new Personne();
        String input = "a1 a2 a3 a4 a5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Coordonnee> bateauTest = new ArrayList<>();
        joueurPersonne.determinerPlacerBateau(bateauTest,0);

        assertEquals(5,bateauTest.size());

        assertEquals(0,bateauTest.get(0).posH);
        assertEquals(0,bateauTest.get(0).posV);
        assertEquals(1,bateauTest.get(1).posH);
        assertEquals(0,bateauTest.get(1).posV);
        assertEquals(2,bateauTest.get(2).posH);
        assertEquals(0,bateauTest.get(2).posV);
        assertEquals(3,bateauTest.get(3).posH);
        assertEquals(0,bateauTest.get(3).posV);
        assertEquals(4,bateauTest.get(4).posH);
        assertEquals(0,bateauTest.get(4).posV);
    }

    @Test
    void testDeterminerPlacerBateauCroiseur() {
        Joueur joueurPersonne = new Personne();
        String input = "a1 b1 c1 d1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Coordonnee> bateauTest = new ArrayList<>();
        joueurPersonne.determinerPlacerBateau(bateauTest,1);

        assertEquals(4,bateauTest.size());

        assertEquals(0,bateauTest.get(0).posH);
        assertEquals(0,bateauTest.get(0).posV);
        assertEquals(0,bateauTest.get(1).posH);
        assertEquals(1,bateauTest.get(1).posV);
        assertEquals(0,bateauTest.get(2).posH);
        assertEquals(2,bateauTest.get(2).posV);
        assertEquals(0,bateauTest.get(3).posH);
        assertEquals(3,bateauTest.get(3).posV);
    }

    @Test
    void testDeterminerPlacerBateauContreTor() {
        Joueur joueurPersonne = new Personne();
        String input = "a1 a2 a3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Coordonnee> bateauTest = new ArrayList<>();
        joueurPersonne.determinerPlacerBateau(bateauTest,2);

        assertEquals(3,bateauTest.size());

        assertEquals(0,bateauTest.get(0).posH);
        assertEquals(0,bateauTest.get(0).posV);
        assertEquals(1,bateauTest.get(1).posH);
        assertEquals(0,bateauTest.get(1).posV);
        assertEquals(2,bateauTest.get(2).posH);
        assertEquals(0,bateauTest.get(2).posV);

    }

    @Test
    void testDeterminerPlacerBateauSousMarin() {
        Joueur joueurPersonne = new Personne();
        String input = "a1 b1 c1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Coordonnee> bateauTest = new ArrayList<>();
        joueurPersonne.determinerPlacerBateau(bateauTest,3);

        assertEquals(3,bateauTest.size());

        assertEquals(0,bateauTest.get(0).posH);
        assertEquals(0,bateauTest.get(0).posV);
        assertEquals(0,bateauTest.get(1).posH);
        assertEquals(1,bateauTest.get(1).posV);
        assertEquals(0,bateauTest.get(2).posH);
        assertEquals(2,bateauTest.get(2).posV);
    }

    @Test
    void testDeterminerPlacerBateauTorp() {
        Joueur joueurPersonne = new Personne();
        String input = "a1 b1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Coordonnee> bateauTest = new ArrayList<>();
        joueurPersonne.determinerPlacerBateau(bateauTest,4);

        assertEquals(2,bateauTest.size());

        assertEquals(0,bateauTest.get(0).posH);
        assertEquals(0,bateauTest.get(0).posV);
        assertEquals(0,bateauTest.get(1).posH);
        assertEquals(1,bateauTest.get(1).posV);

    }


    @Test
    void determinerTir() {
        Joueur joueurPersonne = new Personne();
        String input = "f5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Coordonnee coordonneeTir = joueurPersonne.determinerTir(null);

        assertEquals(4,coordonneeTir.posH);
        assertEquals(5,coordonneeTir.posV);
    }
}