package menuprincipal.battleship.plateau;

public class PlateauxFactory {

    public Plateau makePlateau(Plateau[] typePlateau) {
        Plateau plateau = null;

        String test = typePlateau.getClass().getName();
        if (typePlateau.getClass().getName().contains("PlateauBateau"))
            return new PlateauBateau();

        if (typePlateau.getClass().getName().contains("PlateauTir"))
            //mettre plateauBateau de l'adversaire dans le constructeur de PlateauTir
            return new PlateauTir(new PlateauBateau());

        return null;
    }
}
