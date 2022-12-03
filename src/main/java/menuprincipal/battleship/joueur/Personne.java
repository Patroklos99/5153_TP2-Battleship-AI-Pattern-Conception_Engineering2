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

    /**
     * Vérifie si l'entrée de l'utilisateur est du bon format
     * @param plusieursCoordonnees l'entrée de l'utilisateur
     * @return si c'est valide
     */
    private boolean verifierFormatEntreeBateau(String[] plusieursCoordonnees){
        boolean estCorrect = true;
        for(String coor: plusieursCoordonnees){
            if(!Character.isAlphabetic(coor.charAt(0)) || !Character.isDigit(coor.charAt(1)) || (coor.length() == 3 && !Character.isDigit(coor.charAt(2)))
                    || (coor.length() != 2 && coor.length() != 3) || (coor.length() == 3 && !(coor.charAt(1) == '1' && coor.charAt(2) == '0'))
                    || (coor.charAt(0) < 'a' && coor.charAt(0) > 'j' )){
                estCorrect = false;
                break;
            }
        }
        return estCorrect;
    }

    /**
     * Vérifie si l'entrée de l'utlisateur est valide
     * @param plusieursCoordonnees l'entrée de l'utilisateur
     * @param tailleBateau la taille du bateau demandé
     * @param coordonneBateau les coordonneesBateau
     * @return si c'est correct
     */
    private boolean verifierEntreeBateau(String[] plusieursCoordonnees, int tailleBateau, List<Pair<Integer, Integer>> coordonneBateau){
        boolean estCorrect = true;
        if(plusieursCoordonnees.length != tailleBateau)
            estCorrect = false;
        else{
            estCorrect = verifierFormatEntreeBateau(plusieursCoordonnees);
        }
        if(estCorrect){
            //méthode pour transformer en coordonneBateau et vérifie si ça se suit
        }
        return estCorrect;
    }

    /**
     * Obtient l'entrée de l'utilisateur des coordonnées du bateau
     * @return l'entrée de l'utilisateur
     */
    private String[] obtenirEntreeUtilisateurBateau(){
        Scanner entreePersonne = new Scanner(System.in);
        String coordonnee;
        coordonnee = entreePersonne.nextLine();
        coordonnee.toLowerCase();

        return coordonnee.split(" ");
    }

    @Override
    protected void determinerPlacerBateau(List<Pair<Integer, Integer>> coordonneBateau, int numeroBateau) {
        boolean estCorrect = false;
        String[] coordonnees;
        do{
            switch(numeroBateau){
                case 0:
                    System.out.println(ENONCE_PORTE_AVION);
                    coordonnees = obtenirEntreeUtilisateurBateau();
                    estCorrect = verifierEntreeBateau(coordonnees,5, coordonneBateau);
                    break;
                case 1:
                    System.out.println(ENONCE_CROISEUR);
                    coordonnees = obtenirEntreeUtilisateurBateau();
                    estCorrect = verifierEntreeBateau(coordonnees,4, coordonneBateau);
                    break;
                case 2:
                    System.out.println(ENONCE_CONTRE_TOR);
                    coordonnees = obtenirEntreeUtilisateurBateau();
                    estCorrect = verifierEntreeBateau(coordonnees,3, coordonneBateau);
                    break;
                case 3:
                    System.out.println(ENONCE_SOUS_MARIN);
                    coordonnees = obtenirEntreeUtilisateurBateau();
                    estCorrect = verifierEntreeBateau(coordonnees,3, coordonneBateau);
                    break;
                case 4:
                    System.out.println(ENONCE_TORPILLEUR);
                    coordonnees = obtenirEntreeUtilisateurBateau();
                    estCorrect = verifierEntreeBateau(coordonnees,2, coordonneBateau);
                    break;
            }
        }while(!estCorrect);



        /**
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

         */







    }
}
