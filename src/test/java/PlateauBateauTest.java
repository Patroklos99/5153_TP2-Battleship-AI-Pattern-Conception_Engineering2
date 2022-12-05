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

}
