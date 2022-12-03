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

    public List<Pair<Integer, Integer>> demanderPlacerBateau(int numeroBateau) {
        List<Pair<Integer,Integer>> bateau = new ArrayList<>();

        this.determinerPlacerBateau(bateau, numeroBateau);
        return bateau;
    }

    protected void determinerPlacerBateau(List<Pair<Integer,Integer>> coordonneBateau, int numeroBateau) {
        coordonneBateau.addAll(List.of(new Pair<>(0,0), new Pair<>(0,1), new Pair<>(0,2), new Pair<>(0,3), new Pair<>(0,4)));
    }
}
