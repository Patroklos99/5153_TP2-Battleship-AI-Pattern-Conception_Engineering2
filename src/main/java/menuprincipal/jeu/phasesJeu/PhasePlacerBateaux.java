package menuprincipal.jeu.phasesJeu;

import menuprincipal.jeu.Jeu;

public class PhasePlacerBateaux extends PhaseJeu{

    public PhasePlacerBateaux(Jeu jeu_) {
        super(jeu_);
    }

    @Override
    public void prochaineAction() {
        jeu.initialiserPlateaux();
        jeu.placerBateaux();
        jeu.ajouterEtapeVisualiseur();
        jeu.effectuerPhase(new PhaseJouer(jeu));
    }
}
