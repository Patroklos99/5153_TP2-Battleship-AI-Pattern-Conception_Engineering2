package menuprincipal.jeu;

import menuprincipal.battleship.joueur.IAAvance;
import menuprincipal.battleship.joueur.IADebutant;
import menuprincipal.battleship.joueur.Joueur;
import menuprincipal.battleship.joueur.Personne;
import menuprincipal.battleship.plateau.Coordonnee;
import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JeuTest {
    @Test
    void determinerModeJeu() {
        Jeu jeu = new Jeu();
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Joueur[] joueurs = {SelecteurModeJeu.determinerDifficulte(), new IAAvance()};
        Assertions.assertInstanceOf(IADebutant.class, joueurs[0]);
    }

    @Test
    void initialiserPlateaux() {
        Jeu jeu = new Jeu();
        jeu.initialiserPlateaux();
        PlateauBateau platBat = new PlateauBateau();
        PlateauTir platTir = new PlateauTir(platBat);

        Assertions.assertEquals(platBat.toString(), jeu.getPlateauBateaux()[0].toString());
        Assertions.assertEquals(platTir.toString(), jeu.getPlateauTirs()[0].toString());

        Assertions.assertEquals(platBat.toString(), jeu.getPlateauBateaux()[1].toString());
        Assertions.assertEquals(platTir.toString(), jeu.getPlateauTirs()[1].toString());
    }

    @Test
    void placerBateaux() {
        Jeu jeu = new Jeu();
        jeu.initialiserPlateaux();
        PlateauBateau platBat = new PlateauBateau();
        PlateauTir platTir = new PlateauTir(platBat);

        Assertions.assertEquals(platBat.toString(), jeu.getPlateauBateaux()[0].toString());
        Assertions.assertEquals(platTir.toString(), jeu.getPlateauTirs()[0].toString());

        Assertions.assertEquals(platBat.toString(), jeu.getPlateauBateaux()[1].toString());
        Assertions.assertEquals(platTir.toString(), jeu.getPlateauTirs()[1].toString());
    }

    @Test
    void demanderPlacerBateau() {
        System.setIn(new ByteArrayInputStream("a1 a2 a3 a4 a5".getBytes()));
        Jeu jeu = new Jeu();
        Joueur[] joueurs = {new Personne(), new Personne()};
        jeu.setJoueurs(joueurs);
        jeu.initialiserPlateaux();
        List<Coordonnee> coords = jeu.demanderPlacerBateau(0,0);

        assertEquals(coords.size(), 5);

        assertEquals(0,coords.get(0).posH);
        assertEquals(0,coords.get(0).posV);
        assertEquals(1,coords.get(1).posH);
        assertEquals(0,coords.get(1).posV);
        assertEquals(2,coords.get(2).posH);
        assertEquals(0,coords.get(2).posV);
        assertEquals(3,coords.get(3).posH);
        assertEquals(0,coords.get(3).posV);
        assertEquals(4,coords.get(4).posH);
        assertEquals(0,coords.get(4).posV);
    }

    @Test
    void effectuerProchainTourFinPartie() {
        System.setIn(new ByteArrayInputStream("a1 a2 a3 a4 a5".getBytes()));
        Jeu jeu = new Jeu();
        Joueur[] joueurs = {new IADebutant(), new IADebutant()};
        jeu.setJoueurs(joueurs);
        jeu.initialiserPlateaux();
        assertTrue(jeu.effectuerProchaintour());
    }

    @Test
    void effectuerProchainTour() {
        Jeu jeu = new Jeu();
        Joueur[] joueurs = {new IADebutant(), new IADebutant()};
        jeu.setJoueurs(joueurs);
        jeu.initialiserPlateaux();
        jeu.placerBateaux();
        assertFalse(jeu.effectuerProchaintour());
    }


    @Test
    void demanderTirJoueur() {
        Jeu jeu = new Jeu();
        Joueur[] joueurs = {new IADebutant(), new IADebutant()};
        jeu.setJoueurs(joueurs);
        jeu.initialiserPlateaux();
        jeu.placerBateaux();
        assertInstanceOf(Coordonnee.class, jeu.demanderTirJoueur(0));
    }

}