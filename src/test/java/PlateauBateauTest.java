import menuprincipal.battleship.plateau.Case;
import menuprincipal.battleship.plateau.Coordonnee;
import menuprincipal.battleship.plateau.PlateauBateau;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class PlateauBateauTest {

    PlateauBateau plateauBateau;
    @BeforeEach
    public void setup() {
        plateauBateau = new PlateauBateau();
    }

    @AfterEach
    public void tearDown() {
        plateauBateau = null;
    }

    @Test
    public void placerBateauValide(){
        ArrayList<Coordonnee> coords = new ArrayList<Coordonnee>();

        coords.add(new Coordonnee(1,1));
        coords.add(new Coordonnee(1,2));
        coords.add(new Coordonnee(1,3));
        coords.add(new Coordonnee(1,4));

        plateauBateau.placerNouveauBateau(coords);

        Assertions.assertEquals(plateauBateau.cases[1][1], Case.BATEAU);
        Assertions.assertEquals(plateauBateau.cases[1][2], Case.BATEAU);
        Assertions.assertEquals(plateauBateau.cases[1][3], Case.BATEAU);
        Assertions.assertEquals(plateauBateau.cases[1][4], Case.BATEAU);
    }

    @Test
    public void placerBateauInvalide(){
        ArrayList<Coordonnee> coords = new ArrayList<Coordonnee>();

        coords.add(new Coordonnee(1,1));
        coords.add(new Coordonnee(1,2));
        coords.add(new Coordonnee(1,3));
        coords.add(new Coordonnee(1,4));

        plateauBateau.placerNouveauBateau(coords);

        Assertions.assertEquals(plateauBateau.cases[1][1], Case.BATEAU);
        Assertions.assertEquals(plateauBateau.cases[1][2], Case.BATEAU);
        Assertions.assertEquals(plateauBateau.cases[1][3], Case.BATEAU);
        Assertions.assertEquals(plateauBateau.cases[1][4], Case.BATEAU);
    }

    @Test
    public void ajouterTirRate() {
        Case resultat = plateauBateau.ajouterTir(new Coordonnee(1,1));
        Assertions.assertEquals(resultat,Case.RATE);
    }

    @Test
    public void ajouterTirTouche() {
        ArrayList<Coordonnee> coords = new ArrayList<Coordonnee>();

        coords.add(new Coordonnee(1,1));
        coords.add(new Coordonnee(1,2));

        plateauBateau.placerNouveauBateau(coords);

        Case resultat = plateauBateau.ajouterTir(new Coordonnee(1,1));
        Assertions.assertEquals(resultat,Case.TOUCHE);
    }

    @Test
    public void ajouterTirCoule() {
        ArrayList<Coordonnee> coords = new ArrayList<Coordonnee>();

        coords.add(new Coordonnee(1,1));
        coords.add(new Coordonnee(1,2));

        plateauBateau.placerNouveauBateau(coords);

        plateauBateau.ajouterTir(new Coordonnee(1,2));
        Case resultat = plateauBateau.ajouterTir(new Coordonnee(1,1));
        Assertions.assertEquals(resultat,Case.COULE);
    }

    @Test
    public void bateauxTousCoulesVrai() {
        ArrayList<Coordonnee> coords = new ArrayList<Coordonnee>();

        coords.add(new Coordonnee(1,1));
        coords.add(new Coordonnee(1,2));

        plateauBateau.placerNouveauBateau(coords);

        coords = new ArrayList<Coordonnee>();

        coords.add(new Coordonnee(3,1));
        coords.add(new Coordonnee(3,2));

        plateauBateau.placerNouveauBateau(coords);

        plateauBateau.ajouterTir(new Coordonnee(1,1));
        plateauBateau.ajouterTir(new Coordonnee(1,2));

        plateauBateau.ajouterTir(new Coordonnee(3,1));
        plateauBateau.ajouterTir(new Coordonnee(3,2));

        Boolean resultat = plateauBateau.bateauxTousCoules();
        Assertions.assertEquals(resultat,true);
    }

    @Test
    public void bateauxTousCoulesFaux() {
        ArrayList<Coordonnee> coords = new ArrayList<Coordonnee>();

        coords.add(new Coordonnee(1,1));
        coords.add(new Coordonnee(1,2));

        plateauBateau.placerNouveauBateau(coords);

        coords.add(new Coordonnee(3,1));
        coords.add(new Coordonnee(3,2));

        plateauBateau.placerNouveauBateau(coords);

        plateauBateau.ajouterTir(new Coordonnee(1,1));
        plateauBateau.ajouterTir(new Coordonnee(1,2));
        plateauBateau.ajouterTir(new Coordonnee(3,1));

        Boolean resultat = plateauBateau.bateauxTousCoules();
        Assertions.assertEquals(resultat,false);
    }

    @Test
    public void estCaseInnoccupeeVrai(){

        Boolean resultat = plateauBateau.estCaseInnoccupee(new Coordonnee(3,3));
        Assertions.assertEquals(resultat,true);
    }

    @Test
    public void estCaseInnoccupeeFaux(){
        ArrayList<Coordonnee> coords = new ArrayList<Coordonnee>();

        coords.add(new Coordonnee(1,1));
        coords.add(new Coordonnee(1,2));

        plateauBateau.placerNouveauBateau(coords);

        Boolean resultat = plateauBateau.estCaseInnoccupee(new Coordonnee(1,1));
        Assertions.assertEquals(resultat,false);
    }

    @Test
    public void estCaseInnoccupeeHorsPlateau(){

        Boolean resultat = plateauBateau.estCaseInnoccupee(new Coordonnee(9999,9999));
        Assertions.assertEquals(resultat,false);
    }


}
