package menuprincipal.battleship.plateau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordonneeTest {

    @Test
    void testConstructeur(){
        Coordonnee coordonneeTest = new Coordonnee(1,3);
        assertEquals(1,coordonneeTest.posH);
        assertEquals(3,coordonneeTest.posV);
    }

    @Test
    void testIsValidVrai(){
        Coordonnee coordonneeTest = new Coordonnee(1,3);
        assertTrue(coordonneeTest.isValid());
    }

    @Test
    void testIsValidFauxPosH(){
        Coordonnee coordonneeTest = new Coordonnee(10,3);
        assertFalse(coordonneeTest.isValid());
    }

    @Test
    void testIsValidFauxPosV(){
        Coordonnee coordonneeTest = new Coordonnee(1,-3);
        assertFalse(coordonneeTest.isValid());
    }


}