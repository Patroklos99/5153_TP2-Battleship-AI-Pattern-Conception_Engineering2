package menuprincipal.battleship.plateau;

public class PlateauxFactory {

    public Plateau makePlateau(Plateau typePlateau) {
        Plateau plateau = null;

        if (typePlateau instanceof PlateauBateau)
            return new PlateauBateau();

        if (typePlateau instanceof PlateauTir)
            //mettre plateauBateau de l'adversaire dans le constructeur de PlateauTir
            return new PlateauTir(new PlateauBateau());

        return null;
    }
}
