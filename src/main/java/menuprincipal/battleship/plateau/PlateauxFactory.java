package menuprincipal.battleship.plateau;

public class PlateauxFactory {

    public Plateau makePlateau(Plateau[] typePlateau, PlateauBateau plateauBateau) {
        Plateau plateau = null;
        if (typePlateau.getClass().getName().contains("PlateauBateau"))
            return new PlateauBateau();

        if (typePlateau.getClass().getName().contains("PlateauTir"))
            return new PlateauTir(plateauBateau); //mettre plateauBateau de l'adversaire ds constructeur de PlateauTir

        return null;
    }
}
