import menuprincipal.battleship.joueur.IAAvance;
import menuprincipal.battleship.plateau.Case;
import menuprincipal.battleship.plateau.Coordonnee;
import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IAAvanceTest {


    IAAvance ia;
    PlateauTir plateauMock;
    Random randomNum;

    static final long SEED = 2L;


    @BeforeEach
    public void setup(){
        plateauMock = mock(PlateauTir.class);
        randomNum = new Random(SEED);
        ia = new IAAvance(randomNum);
    }

    @AfterEach
    public void tearDown(){
        ia = null;
        plateauMock = null;
        randomNum = null;
    }

    @Test
    //Tester si l'IA exécute un tir aléatoire comme premier tir
    public void determinerPremierTir(){
        Random rand = new Random(SEED);
        int expectedColonne = rand.nextInt(10);
        int expectedRangee = rand.nextInt(10);

        // Ordre de retour pour getCase() de plateauMock
        when(plateauMock.getCase(any(Coordonnee.class)))
                .thenReturn(Case.AUCUN);

        Coordonnee c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne,expectedRangee));
    }

    @Test
    //Tester si l'IA exécute son deuxième tir à côté du premier après avoir touché un bateau,
    //Puis, si le deuxieme tir est aussi touché, tester si l'IA continue à tirer vers la même direction
    public void determinerTirToucheContinue(){
        Random rand = new Random(SEED);
        int expectedColonne = rand.nextInt(10);
        int expectedRangee = rand.nextInt(10);

        // Ordre de retour pour getCase() de plateauMock
        when(plateauMock.getCase(any(Coordonnee.class)))
                .thenReturn(Case.AUCUN)
                .thenReturn(Case.TOUCHE)
                .thenReturn(Case.AUCUN)
                .thenReturn(Case.TOUCHE)
                .thenReturn(Case.AUCUN);

        Coordonnee c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne,expectedRangee));

        c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne,expectedRangee - 1));

        c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne,expectedRangee - 2));
    }

    @Test
    //Tester si l'IA exécute son deuxième tir à côté du premier après avoir touché un bateau,
    //Puis, si le deuxieme tir est raté, tester si l'IA commence à tirer dans l'autre direction
    public void determinerTirToucheChangerDirection(){
        Random rand = new Random(SEED);
        int expectedColonne = rand.nextInt(10);
        int expectedRangee = rand.nextInt(10);

        // Ordre de retour pour getCase() de plateauMock
        when(plateauMock.getCase(any(Coordonnee.class)))
                .thenReturn(Case.AUCUN)
                .thenReturn(Case.TOUCHE)
                .thenReturn(Case.AUCUN)
                .thenReturn(Case.RATE)
                .thenReturn(Case.AUCUN);

        Coordonnee c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne,expectedRangee));

        c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne,expectedRangee - 1));

        c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne,expectedRangee + 1));
    }

    @Test
    //Tester si l'IA exécute son deuxième tir à côté du premier après avoir touché un bateau,
    //Puis, si le deuxieme tir est raté, tester si l'IA commence à tirer dans l'autre direction
    public void determinerTirToucheChangerAxe(){
        Random rand = new Random(SEED);
        int expectedColonne = rand.nextInt(10);
        int expectedRangee = rand.nextInt(10);

        // Ordre de retour pour getCase() de plateauMock
        when(plateauMock.getCase(any(Coordonnee.class)))
                .thenReturn(Case.AUCUN)
                .thenReturn(Case.TOUCHE)
                .thenReturn(Case.AUCUN)
                .thenReturn(Case.RATE)
                .thenReturn(Case.AUCUN)
                .thenReturn(Case.RATE)
                .thenReturn(Case.AUCUN);

        Coordonnee c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne,expectedRangee));

        c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne,expectedRangee - 1));

        c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne,expectedRangee + 1));

        c = ia.determinerTir(plateauMock);
        Assertions.assertEquals(c,new Coordonnee(expectedColonne - 1,expectedRangee));
    }

    @Test
    public void ReinitialiserApresCoule(){
        Random rand = new Random(SEED);
        int expectedColonne = rand.nextInt(10);
        int expectedRangee = rand.nextInt(10);

        //Tester si l'IA se réinitialise après avoir coulé un bateau
        when(plateauMock.getCase(any(Coordonnee.class)))
                .thenReturn(Case.AUCUN)
                .thenReturn(Case.TOUCHE)
                .thenReturn(Case.AUCUN)
                .thenReturn(Case.COULE)
                .thenReturn(Case.AUCUN);

        Coordonnee c = ia.determinerTir(plateauMock);

        c = ia.determinerTir(plateauMock);

        Assertions.assertNotNull(ia.getTirPivot());

        c = ia.determinerTir(plateauMock);

        Assertions.assertNull(ia.getTirPivot());
    }

}
