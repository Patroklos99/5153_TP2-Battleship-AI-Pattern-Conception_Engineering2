package menuprincipal.battleship.plateau;

public class Coordonnee {

    public Integer posH;
    public Integer posV;

    /**
     * Représente une coordonnée sur un plateau.
     *
     * @param posHorizontal position horizontale, représenté par un nombre sur le plateau.
     * @param posVertical position verticale, représenté par une lettre sur le plateau.
     * */
    public Coordonnee(int posHorizontal,int posVertical){
        posH = posHorizontal;
        posV = posVertical;
    }
}
