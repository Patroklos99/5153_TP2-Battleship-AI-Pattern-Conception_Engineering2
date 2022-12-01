package menuprincipal.battleship.joueur;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class Joueur {
    public Pair<Integer, Integer> determinerTir() {
        Pair<Integer, Integer> tir = null;
        return null;
    }

    public Pair<Integer, Integer> demanderTir() {
        Pair<Integer, Integer> tir = null;
        return null;
    }

    public List<List<Pair<Integer, Integer>>> demanderPlacerBateau() {
        List<Pair<Integer,Integer>> porteAvion = new ArrayList<>(5);
        List<Pair<Integer,Integer>> croiseur = new ArrayList<>(4);
        List<Pair<Integer,Integer>> contreTorpilleurs = new ArrayList<>(3);
        List<Pair<Integer,Integer>> sousMarin = new ArrayList<>(3);
        List<Pair<Integer,Integer>> torpilleur = new ArrayList<>(2);
        List<List<Pair<Integer, Integer>>> listeBateaux = new ArrayList<>(List.of(porteAvion, croiseur, contreTorpilleurs, sousMarin, torpilleur));
        this.determinerPlacerBateau(listeBateaux);
        return listeBateaux;
    }

    protected void determinerPlacerBateau(List<List<Pair<Integer,Integer>>> coordonneBateau) {
        coordonneBateau.get(0).addAll(List.of(new Pair<>(0,0), new Pair<>(0,1), new Pair<>(0,2), new Pair<>(0,3), new Pair<>(0,4)));
        coordonneBateau.get(1).addAll(List.of(new Pair<>(2,0), new Pair<>(3,0), new Pair<>(4,0), new Pair<>(5,0)));
        coordonneBateau.get(2).addAll(List.of(new Pair<>(3,3), new Pair<>(3,4), new Pair<>(3,5)));
        coordonneBateau.get(3).addAll(List.of(new Pair<>(4,3), new Pair<>(4,2), new Pair<>(4,1)));
        coordonneBateau.get(4).addAll(List.of(new Pair<>(8,6), new Pair<>(8,7)));
    }
}
