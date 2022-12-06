import menuprincipal.battleship.bateau.Bateau;
import menuprincipal.battleship.plateau.Case;
import menuprincipal.battleship.plateau.Coordonnee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BateauTest {

    ArrayList<Coordonnee> coords;
    Bateau bateau;
    @BeforeEach
    public void setup() {
        coords = new ArrayList<Coordonnee>();
        coords.add(new Coordonnee(1,1));
        coords.add(new Coordonnee(2,1));
        coords.add(new Coordonnee(3,1));

        bateau = new Bateau(coords);
    }

    @AfterEach
    public void tearDown() {
        bateau = null;
        coords = null;
    }

    @Test
    public void tireSurRate(){
        Coordonnee coord = new Coordonnee(4,4);
        Case resultat = bateau.tirerSur(coord);

        Assertions.assertEquals(resultat,Case.RATE);
    }

    @Test
    public void tireSurRateDejaTouche(){
        Coordonnee coord = new Coordonnee(1,1);
        bateau.tirerSur(coord);
        Case resultat = bateau.tirerSur(coord);

        Assertions.assertEquals(resultat,Case.RATE);
    }

    @Test
    public void tireSurTouche(){
        Coordonnee coord = new Coordonnee(1,1);
        Case resultat = bateau.tirerSur(coord);

        Assertions.assertEquals(resultat,Case.TOUCHE);
    }

    @Test
    public void tireSurCoule(){
        bateau.tirerSur(new Coordonnee(1,1));
        bateau.tirerSur(new Coordonnee(2,1));
        Case resultat = bateau.tirerSur(new Coordonnee(3,1));

        Assertions.assertEquals(resultat,Case.COULE);
    }

    @Test
    public void estCouleVrai(){
        bateau.tirerSur(new Coordonnee(1,1));
        bateau.tirerSur(new Coordonnee(2,1));
        bateau.tirerSur(new Coordonnee(3,1));

        Boolean resultat = bateau.estCoule();

        Assertions.assertEquals(resultat,true);
    }

    @Test
    public void estCouleFaux(){
        bateau.tirerSur(new Coordonnee(1,1));
        bateau.tirerSur(new Coordonnee(2,1));

        Boolean resultat = bateau.estCoule();

        Assertions.assertEquals(resultat,false);
    }


}
