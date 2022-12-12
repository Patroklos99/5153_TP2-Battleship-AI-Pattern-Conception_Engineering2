package menuprincipal.battleship.joueur;

import menuprincipal.battleship.plateau.Coordonnee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void testDeterminerTir() {
        Joueur joueurTest = new IADebutant();
        Coordonnee coordonneeTest = joueurTest.determinerTir(null);
        assertTrue(coordonneeTest.posH > -1 && coordonneeTest.posH < 10);
        assertTrue(coordonneeTest.posV > -1 && coordonneeTest.posV < 10);
    }

    @Test
    void testDemanderPlacerBateau() {
        Joueur joueurTest = new IADebutant();
        List<Coordonnee> coordonneesBateau = joueurTest.demanderPlacerBateau(0);
        assertEquals(5,coordonneesBateau.size());
    }

    @Test
    void testDeterminerPlacerBateauIA5Cases() {
        Joueur joueurTest = new IADebutant();
        List<Coordonnee> coordonneesBateau = new ArrayList<>();
        joueurTest.determinerPlacerBateau(coordonneesBateau,0);
        assertEquals(5,coordonneesBateau.size());

        for(Coordonnee coordonneTest: coordonneesBateau){
            assertTrue(coordonneTest.posH > -1 && coordonneTest.posH < 10);
            assertTrue(coordonneTest.posV > -1 && coordonneTest.posV < 10);
        }

        if(coordonneesBateau.get(0).posH < coordonneesBateau.get(1).posH){
            for(int i = 1; i < 5; i++){
                assertEquals(coordonneesBateau.get(i -1).posH + 1, coordonneesBateau.get(i).posH);
            }
        }else{
            for(int i = 1; i < 5; i++){
                assertEquals(coordonneesBateau.get(i -1).posV + 1, coordonneesBateau.get(i).posV);
            }
        }
    }

    @Test
    void testDeterminerPlacerBateauIA4Cases() {
        Joueur joueurTest = new IADebutant();
        List<Coordonnee> coordonneesBateau = new ArrayList<>();
        joueurTest.determinerPlacerBateau(coordonneesBateau,1);
        assertEquals(4,coordonneesBateau.size());

        for(Coordonnee coordonneTest: coordonneesBateau){
            assertTrue(coordonneTest.posH > -1 && coordonneTest.posH < 10);
            assertTrue(coordonneTest.posV > -1 && coordonneTest.posV < 10);
        }

        if(coordonneesBateau.get(0).posH < coordonneesBateau.get(1).posH){
            for(int i = 1; i < 4; i++){
                assertEquals(coordonneesBateau.get(i -1).posH + 1, coordonneesBateau.get(i).posH);
            }
        }else{
            for(int i = 1; i < 4; i++){
                assertEquals(coordonneesBateau.get(i -1).posV + 1, coordonneesBateau.get(i).posV);
            }
        }
    }

    @Test
    void testDeterminerPlacerBateauIA3Cases() {
        Joueur joueurTest = new IADebutant();
        List<Coordonnee> coordonneesBateau = new ArrayList<>();
        joueurTest.determinerPlacerBateau(coordonneesBateau,2);
        assertEquals(3,coordonneesBateau.size());

        for(Coordonnee coordonneTest: coordonneesBateau){
            assertTrue(coordonneTest.posH > -1 && coordonneTest.posH < 10);
            assertTrue(coordonneTest.posV > -1 && coordonneTest.posV < 10);
        }

        if(coordonneesBateau.get(0).posH < coordonneesBateau.get(1).posH){
            for(int i = 1; i < 3; i++){
                assertEquals(coordonneesBateau.get(i -1).posH + 1, coordonneesBateau.get(i).posH);
            }
        }else{
            for(int i = 1; i < 3; i++){
                assertEquals(coordonneesBateau.get(i -1).posV + 1, coordonneesBateau.get(i).posV);
            }
        }
    }

    @Test
    void testDeterminerPlacerBateauIA2Cases() {
        Joueur joueurTest = new IADebutant();
        List<Coordonnee> coordonneesBateau = new ArrayList<>();
        joueurTest.determinerPlacerBateau(coordonneesBateau,4);
        assertEquals(2,coordonneesBateau.size());

        for(Coordonnee coordonneTest: coordonneesBateau){
            assertTrue(coordonneTest.posH > -1 && coordonneTest.posH < 10);
            assertTrue(coordonneTest.posV > -1 && coordonneTest.posV < 10);
        }

        if(coordonneesBateau.get(0).posH < coordonneesBateau.get(1).posH){
            assertEquals(coordonneesBateau.get(0).posH + 1, coordonneesBateau.get(1).posH);
        }else{
            assertEquals(coordonneesBateau.get(0).posV + 1, coordonneesBateau.get(1).posV);
        }
    }
}