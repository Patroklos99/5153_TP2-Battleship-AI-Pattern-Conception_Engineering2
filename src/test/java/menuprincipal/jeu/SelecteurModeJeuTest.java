package menuprincipal.jeu;

import menuprincipal.battleship.joueur.IAAvance;
import menuprincipal.battleship.joueur.IADebutant;
import menuprincipal.battleship.joueur.Joueur;
import menuprincipal.battleship.joueur.Personne;
import menuprincipal.battleship.plateau.Coordonnee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


import static org.junit.jupiter.api.Assertions.*;

class SelecteurModeJeuTest {

    @Test
    void determinerDifficulteDebutant() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Assertions.assertInstanceOf(IADebutant.class, SelecteurModeJeu.determinerDifficulte());
    }

    @Test
    void determinerDifficulteAvance() {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        Assertions.assertInstanceOf(IAAvance.class, SelecteurModeJeu.determinerDifficulte());
    }

}