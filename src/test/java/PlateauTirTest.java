import menuprincipal.battleship.plateau.Case;
import menuprincipal.battleship.plateau.Coordonnee;
import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlateauTirTest {
    ArrayList<Coordonnee> coordonneesBateau;
    PlateauTir plateauTir;
    PlateauBateau plateauBateau;

    @BeforeEach
    public void setup() {
        coordonneesBateau = new ArrayList<Coordonnee>();

        coordonneesBateau.add(new Coordonnee(1,1));
        coordonneesBateau.add(new Coordonnee(1,2));
        coordonneesBateau.add(new Coordonnee(1,3));

        plateauBateau = new PlateauBateau();

        plateauBateau.placerNouveauBateau(coordonneesBateau);

        plateauTir = new PlateauTir(plateauBateau);
    }

    @AfterEach
    public void tearDown(){
        coordonneesBateau = null;
        plateauBateau = null;
        plateauTir = null;
    }

    @Test
    public void ajouterTirRate(){
        Coordonnee coord = new Coordonnee(3,3);
        Case resultat = plateauTir.ajouterTir(coord);
        Assertions.assertEquals(resultat,Case.RATE);
    }

    @Test
    public void ajouterTirTouche(){
        Coordonnee coord = new Coordonnee(1,1);
        Case resultat = plateauTir.ajouterTir(coord);
        Assertions.assertEquals(resultat,Case.TOUCHE);
    }

}
