package menuprincipal.battleship.joueur;

import javafx.util.Pair;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Personne extends Joueur{

    private static final String ENONCE_PORTE_AVION = "Veuillez entrer les coordonnées du porte-avion qui utilise 5 cases de gauche à droite ou de haut en bas (exemple: A1 A2 A3 A4 A5):";
    private static final String ENONCE_CROISEUR = "Veuillez entrer les coordonnées du croiseur qui utilise 4 cases de gauche à droite ou de haut en bas (exemple: B1 B2 B3 B4):";
    private static final String ENONCE_CONTRE_TOR = "Veuillez entrer les coordonnées du contre-torpilleurs qui utilise 3 cases de gauche à droite ou de haut en bas (exemple: C1 C2 C3):";
    private static final String ENONCE_SOUS_MARIN = "Veuillez entrer les coordonnées du sous-marin qui utilise 3 cases de gauche à droite ou de haut en bas (exemple: D1 D2 D3):";
    private static final String ENONCE_TORPILLEUR = "Veuillez entrer les coordonnées du torpilleur qui utilise 2 cases de gauche à droite ou de haut en bas (exemple: E1 E2):";

    private static final String MSG_ERREUR = "Erreur, votre entrée n'est pas valide!";


    //---------cette méthode n'a pas été testé (je suis trop lazy pour le faire lol), mais la logique est correcte--------------- -> à enlever après l'avoir testé
    //c'est aussi une méthode qu'on peut refactor si ça nous tente
    /**
     * Vérifie si les coordonnées du bateau se suivent
     * @param coordonneBateau les coordonnées du bateau
     * @return si c'est valide
     */
    private boolean verifierPositionCoordBateau(List<Pair<Integer, Integer>> coordonneBateau){
        boolean estCorrect = true;
        int precedent;
        int courant;
        if(Objects.equals(coordonneBateau.get(0).getKey(), coordonneBateau.get(1).getKey())){
            for (int i = 1; i < coordonneBateau.size(); i++){
                precedent = coordonneBateau.get(i - 1).getValue();
                courant = coordonneBateau.get(i).getValue();
                if(precedent + 1 != courant)
                    estCorrect = false;
            }
        }else if(Objects.equals(coordonneBateau.get(0).getValue(), coordonneBateau.get(1).getValue())){
            for (int i = 1; i < coordonneBateau.size(); i++){
                precedent = coordonneBateau.get(i - 1).getKey();
                courant = coordonneBateau.get(i).getKey();
                if(precedent + 1 != courant)
                    estCorrect = false;
            }
        }else{
            estCorrect = false;
        }
        return estCorrect;
    }

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
                    || (coor.charAt(0) < 'a' && coor.charAt(0) > 'j' ) || (coor.length() == 2 && coor.charAt(1) == '0')){
                estCorrect = false;
                break;
            }
        }
        return estCorrect;
    }

    /**
     * Reformater l'entrée de l'utilisateur pour que ce soit des coordonnées
     * @param plusieursCoordonnees l'entrée de l'utilisateur
     * @param coordonneBateau les coordonnées du bateau
     */
    private void changerFormatEntreeBateau(String[] plusieursCoordonnees, List<Pair<Integer, Integer>> coordonneBateau){
        int colonne;
        int rangee;
        for(String coor: plusieursCoordonnees){
            //TODO cette partie va être refactor pour pouvoir être utilisé pour les tirs (Lysanne fera ça) (et oui, j'ai écrit à la 3e personne pour que ce soit clair que c'est moi qui l'a écrit XD)
            colonne = coor.charAt(0) - 'a';
            if(coor.length() == 3)
                rangee = 9;
            else
                rangee = coor.charAt(1) - '1';
            //_________________________________________________________________________________________________
            coordonneBateau.add(new Pair<>(colonne, rangee));
        }
    }

    /**
     * Vérifie si l'entrée de l'utlisateur est valide
     * @param plusieursCoordonnees l'entrée de l'utilisateur
     * @param tailleBateau la taille du bateau demandé
     * @param coordonneBateau les coordonnées du bateau
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
            //méthodes pour transformer en coordonneBateau et vérifie si ça se suit
            changerFormatEntreeBateau(plusieursCoordonnees,coordonneBateau);
            estCorrect = verifierPositionCoordBateau(coordonneBateau);
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
        coordonnee = coordonnee.toLowerCase();

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
            if(!estCorrect)
                System.out.println(MSG_ERREUR);
        }while(!estCorrect);

    }
}
