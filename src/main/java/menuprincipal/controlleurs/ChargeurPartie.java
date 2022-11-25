package menuprincipal.controlleurs;

import menuprincipal.jeu.Jeu;
import lombok.Data;

@Data
public class ChargeurPartie {

    public static void chargerPartie() {
        //TODO: charger le fichier JSON et initialiser le Jeu
        Jeu.getInstance();
    }

}
