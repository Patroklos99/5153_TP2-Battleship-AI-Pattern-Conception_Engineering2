package menuprincipal.battleship.joueur;

import menuprincipal.battleship.plateau.Coordonnee;

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

    private static final String ENONCE_TIR = "Veuillez entrer la coordonnée du tir (exemple: A1):";


    //---------cette méthode n'a pas été testé (je suis trop lazy pour le faire lol), mais la logique est correcte--------------- -> à enlever après l'avoir testé
    //c'est aussi une méthode qu'on peut refactor si ça nous tente
    /**
     * Vérifie si les coordonnées du bateau se suivent
     * @param coordonneBateau les coordonnées du bateau
     * @return si c'est valide
     */
    private boolean verifierPositionCoordBateau(List<Coordonnee> coordonneBateau){
        boolean estCorrect = true;
        int precedent;
        int courant;
        if(Objects.equals(coordonneBateau.get(0).posH, coordonneBateau.get(1).posH)){
            for (int i = 1; i < coordonneBateau.size(); i++){
                precedent = coordonneBateau.get(i - 1).posV;
                courant = coordonneBateau.get(i).posV;
                if(precedent + 1 != courant)
                    estCorrect = false;
            }
        }else if(Objects.equals(coordonneBateau.get(0).posV, coordonneBateau.get(1).posV)){
            for (int i = 1; i < coordonneBateau.size(); i++){
                precedent = coordonneBateau.get(i - 1).posH;
                courant = coordonneBateau.get(i).posH;
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
            if(!verifierEntree(coor)){
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
    private void changerFormatEntreeBateau(String[] plusieursCoordonnees, List<Coordonnee> coordonneBateau){
        for(String coor: plusieursCoordonnees){
            coordonneBateau.add(changerFormatEntree(coor));
        }
    }

    /**
     * Vérifie si l'entrée de l'utlisateur est valide
     * @param plusieursCoordonnees l'entrée de l'utilisateur
     * @param tailleBateau la taille du bateau demandé
     * @param coordonneBateau les coordonnées du bateau
     * @return si c'est correct
     */
    private boolean verifierEntreeBateau(String[] plusieursCoordonnees, int tailleBateau, List<Coordonnee> coordonneBateau){
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

    /**
     * Transforme l'entrée de l'utilisateur en une coordonnée
     * @param coordonnee l'entrée de la coordonnée de l'utilisateur
     * @return la coordonnée
     */
    private Coordonnee changerFormatEntree(String coordonnee){
        System.out.println(coordonnee);
        int colonne;
        int rangee;
        rangee = coordonnee.charAt(0) - 'a';
        if(coordonnee.length() == 3)
            colonne = 9;
        else
            colonne = coordonnee.charAt(1) - '1';
        return new Coordonnee(colonne, rangee);
    }

    /**
     * Vérifie si l'entrée est valide
     * @param coordonnee l'entrée de l'utilisateur
     * @return si l'entrée est valide (coordonnée existe)
     */
    private boolean verifierEntree(String coordonnee){
        return Character.isAlphabetic(coordonnee.charAt(0)) && Character.isDigit(coordonnee.charAt(1)) && (coordonnee.length() != 3 || Character.isDigit(coordonnee.charAt(2)))
                && (coordonnee.length() == 2 || coordonnee.length() == 3) && (coordonnee.length() != 3 || coordonnee.charAt(1) == '1' && coordonnee.charAt(2) == '0')
                && (coordonnee.charAt(0) >= 'a' || coordonnee.charAt(0) <= 'j') && (coordonnee.length() != 2 || coordonnee.charAt(1) != '0');
    }

    /**
     * Obtient l'entrée de l'utilisateur de la coordonnée du tir
     * @return l'entrée de l'utilisateur
     */
    private String obtenirEntreeUtilisateurTir(){
        Scanner entreePersonne = new Scanner(System.in);
        String coordonnee;
        coordonnee = entreePersonne.nextLine();
        coordonnee = coordonnee.toLowerCase();
        return coordonnee;
    }

    @Override
    protected void determinerPlacerBateau(List<Coordonnee> coordonneBateau, int numeroBateau) {
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
            if(!estCorrect){
                System.out.println(MSG_ERREUR);
                coordonneBateau.clear();
            }

        }while(!estCorrect);

    }

    @Override
    protected Coordonnee determinerTir() {
        boolean estCorrect;
        String coordonnee;
        Coordonnee coordonneeTir;
        do {
            System.out.println(ENONCE_TIR);
            coordonnee = obtenirEntreeUtilisateurTir();
            estCorrect = verifierEntree(coordonnee);
            coordonneeTir = changerFormatEntree(coordonnee);

            if(!estCorrect){
                System.out.println(MSG_ERREUR);
            }
            
        }while(!estCorrect);
        return coordonneeTir;
    }
}
