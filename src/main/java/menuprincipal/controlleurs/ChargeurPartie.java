package menuprincipal.controlleurs;

import menuprincipal.jeu.Jeu;
import lombok.Data;

@Data
public class ChargeurPartie {

    public static Jeu chargerPartie(String nomFichier) {
        return new Jeu();
    }

}
