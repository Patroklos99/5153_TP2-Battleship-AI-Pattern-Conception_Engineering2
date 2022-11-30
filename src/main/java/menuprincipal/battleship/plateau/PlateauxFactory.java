package menuprincipal.battleship.plateau;

public class PlateauxFactory {

    public Plateau makePlateau(Plateau typePlateau) {
        Plateau plateau = null;

        if (typePlateau instanceof PlateauBateau)
            return new PlateauBateau();

        if (typePlateau instanceof PlateauTir)
            return new PlateauTir();

        return null;
    }
}
