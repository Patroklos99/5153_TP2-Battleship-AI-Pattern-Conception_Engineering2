package menuprincipal.battleship.joueur;

import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

public class Personne extends Joueur{

    private static final String ENONCE_PORTE_AVION = "Veuillez entrer les coordonnées du porte-avion qui utilise 5 cases de gauche à droite ou de haut en bas (exemple: A1 A2 A3 A4 A5):";
    private static final String ENONCE_CROISEUR = "Veuillez entrer les coordonnées du croiseur qui utilise 4 cases de gauche à droite ou de haut en bas (exemple: B1 B2 B3 B4):";
    private static final String ENONCE_CONTRE_TOR = "Veuillez entrer les coordonnées du contre-torpilleurs qui utilise 3 cases de gauche à droite ou de haut en bas (exemple: C1 C2 C3):";
    private static final String ENONCE_SOUS_MARIN = "Veuillez entrer les coordonnées du sous-marin qui utilise 3 cases de gauche à droite ou de haut en bas (exemple: D1 D2 D3):";
    private static final String ENONCE_TORPILLEUR = "Veuillez entrer les coordonnées du torpilleur qui utilise 2 cases de gauche à droite ou de haut en bas (exemple: E1 E2):";




    @Override
    protected void determinerPlacerBateau(List<Pair<Integer, Integer>> coordonneBateau, int numeroBateau) {
        /**
        switch(numeroBateau){
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
         */



        Scanner entreePersonne = new Scanner(System.in);
        String coordonnee;

        System.out.println("Veuillez entrer les coordonnées du porte-avion qui utilise 5 cases de gauche à droite ou de haut en bas (exemple: A1 A2 A3 A4 A5):");
        coordonnee = entreePersonne.nextLine();
        coordonnee.toLowerCase();

        String[] plusieursCoordonnees = coordonnee.split(" ");
        Boolean entreeCorrecte = true;
        if(plusieursCoordonnees.length != 5)
            entreeCorrecte = false;
        for(String coor: plusieursCoordonnees){
            if(!Character.isAlphabetic(coor.charAt(0)) || !Character.isDigit(coor.charAt(1)) || (coor.length() == 3 && !Character.isDigit(coor.charAt(2)))
            || (coor.length() != 2 && coor.length() != 3) || (coor.length() == 3 && !(coor.charAt(1) == '1' && coor.charAt(2) == '0'))
                    || (coor.charAt(0) < 'a' && coor.charAt(0) > 'j' )){
                entreeCorrecte = false;
                break;
            }
        }






        /**
        System.out.println("Veuillez entrer les coordonnées du croiseur qui utilise 4 cases de gauche à droite ou de haut en bas (exemple: B1 B2 B3 B4):");
        coordonnee = entreePersonne.nextLine();

        System.out.println("Veuillez entrer les coordonnées du contre-torpilleurs qui utilise 3 cases de gauche à droite ou de haut en bas (exemple: C1 C2 C3):");
        coordonnee = entreePersonne.nextLine();

        System.out.println("Veuillez entrer les coordonnées du sous-marin qui utilise 3 cases de gauche à droite ou de haut en bas (exemple: D1 D2 D3):");
        coordonnee = entreePersonne.nextLine();

        System.out.println("Veuillez entrer les coordonnées du torpilleur qui utilise 2 cases de gauche à droite ou de haut en bas (exemple: E1 E2):");
        coordonnee = entreePersonne.nextLine();
         */
    }
}
