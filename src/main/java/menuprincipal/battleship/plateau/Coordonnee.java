package menuprincipal.battleship.plateau;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o){

        if(o == this)
            return true;

        if(!(o instanceof Coordonnee c))
            return false;

        if(!Objects.equals(c.posH, posH))
            return false;

        return (Objects.equals(c.posV, posV));

    }

    @Override
    public int hashCode(){
        return Objects.hash(posH,posV);
    }

    @Override
    public String toString() {
        return posH.toString() + "," + posV.toString();
    }
}
