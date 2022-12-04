package menuprincipal.battleship.bateau;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Bateau {
    private int pointDeVie;
    private List<Pair<Integer, Integer>> positions;
    private Dictionary<Pair<Integer, Integer>,Boolean> caseEstTouche;

    public Bateau(List<Pair<Integer, Integer>> positions){
        this.positions = new ArrayList<Pair<Integer, Integer>>(positions);
        initCaseEstTouche();
        pointDeVie = this.positions.size();
    }

    private void initCaseEstTouche(){
        caseEstTouche = new Hashtable<Pair<Integer, Integer>,Boolean>();
        for(Pair<Integer, Integer> coord: positions){
            caseEstTouche.put(coord,false);
        }
    }

    public boolean estTouche () {
        return false;
    }

    public boolean estCoule() {
        return (pointDeVie == 0);
    }
}
