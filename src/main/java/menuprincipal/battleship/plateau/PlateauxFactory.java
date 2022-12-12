package menuprincipal.battleship.plateau;

public class PlateauxFactory {

    /**
     * Crée l'instance du plateau désiré
     *
     * @param typePlateau le type de plateau désirer à créer.
     * @param plateauBateau instance nécessaire à la création d'un PlateauTir
     * @return instance du plateau désiré
     */
    public Plateau makePlateau(Plateau[] typePlateau, PlateauBateau plateauBateau) {
        Plateau plateau = null;
        if (typePlateau.getClass().getName().contains("PlateauBateau"))
            return new PlateauBateau();

        if (typePlateau.getClass().getName().contains("PlateauTir"))
            return new PlateauTir(plateauBateau); //mettre plateauBateau de l'adversaire ds constructeur de PlateauTir

        return null;
    }
}
