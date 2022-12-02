package menuprincipal.battleship.joueur;

import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

public class Personne extends Joueur{




    @Override
    protected void determinerPlacerBateau(List<List<Pair<Integer, Integer>>> coordonneBateau) {
        Scanner entreePersonne = new Scanner(System.in);
        String coordonnee;

        System.out.println("Veuillez entrer les coordonnées du porte-avion qui utilise 5 cases (exemple: A1 A2 A3 A4 A5):");
        coordonnee = entreePersonne.nextLine();

        System.out.println("Veuillez entrer les coordonnées du croiseur qui utilise 4 cases (exemple: B1 B2 B3 B4):");
        coordonnee = entreePersonne.nextLine();

        System.out.println("Veuillez entrer les coordonnées du contre-torpilleurs qui utilise 3 cases (exemple: C1 C2 C3):");
        coordonnee = entreePersonne.nextLine();

        System.out.println("Veuillez entrer les coordonnées du sous-marin qui utilise 3 cases (exemple: D1 D2 D3):");
        coordonnee = entreePersonne.nextLine();

        System.out.println("Veuillez entrer les coordonnées du torpilleur qui utilise 2 cases (exemple: E1 E2):");
        coordonnee = entreePersonne.nextLine();
    }
}
