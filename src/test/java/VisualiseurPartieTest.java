import menuprincipal.battleship.plateau.Case;
import menuprincipal.battleship.plateau.Coordonnee;
import menuprincipal.battleship.plateau.PlateauBateau;
import menuprincipal.battleship.plateau.PlateauTir;
import menuprincipal.controlleurs.VisualiseurPartie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VisualiseurPartieTest {

    @Test
    public void ajouterEtape(){
        VisualiseurPartie visualiseurPartie = new VisualiseurPartie();
        PlateauBateau platBat = new PlateauBateau();
        PlateauTir platTir = new PlateauTir(platBat);
        visualiseurPartie.ajouterEtape(platBat, platTir);
        Assertions.assertEquals(platBat.toString() + "\n" + platTir.toString(),
                visualiseurPartie.timelinePlateau.get(0));
    }

    @Test
    public void ajouterEtapeChargee(){
        VisualiseurPartie visualiseurPartie = new VisualiseurPartie();
        PlateauBateau platBat = new PlateauBateau();
        PlateauTir platTir = new PlateauTir(platBat);
        String plateaux = platBat.toString() + "\n" + platTir.toString();
        visualiseurPartie.ajouterEtapeChargee(plateaux);
        Assertions.assertEquals(plateaux,
                visualiseurPartie.timelinePlateau.get(0));
    }

}