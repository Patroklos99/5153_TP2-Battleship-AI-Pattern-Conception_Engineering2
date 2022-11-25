package menuprincipal.jeu;

import lombok.Data;
import javafx.util.Pair;
import menuprincipal.battleship.plateau.Plateau;

@Data
public class Jeu {

    private static Jeu instanceJeu = null;

    private Jeu() {}

    public static Jeu getInstance() {
        if(instanceJeu == null)
            instanceJeu = new Jeu();

        return instanceJeu;
    }

    public void jouer() {

    }

    private void determinerModeJeu() {
        //
    }

    private void actualiserPlateau(Pair<Double, Double> pair, Plateau plateau) {

    }

    private void effectuerProchaintour() {

    }

    private void determinerGagnant() {}
}
