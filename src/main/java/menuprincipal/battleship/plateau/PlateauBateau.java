package menuprincipal.battleship.plateau;

import javafx.util.Pair;

import java.util.List;

public class PlateauBateau extends Plateau {

    public void ajouterTir(Pair<Integer, Integer> coordonee) {
        super.ajouterTir(coordonee);
    }

    public PlateauBateau() {
        super();
    }

    public void placerBateau(List<List<Pair<Integer, Integer>>> localisatonBateaux) {
        for (var listeListe : localisatonBateaux) {
            for (var listeCoord : listeListe) {
                if (cases[listeCoord.getKey()][listeCoord.getValue()] == Case.AUCUN)
                    cases[listeCoord.getKey()][listeCoord.getValue()] = Case.BATEAU;
            }
        }
    }

}
