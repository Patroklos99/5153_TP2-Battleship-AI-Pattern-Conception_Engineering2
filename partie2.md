<br>
<div align="center">UNIVERSITÉ DU QUÉBEC À MONTRÉAL<br>
DÉPARTEMENT D'INFORMATIQUE

<br><br><br><br><br><br><br>


PROJET DE SESSION<br>
PARTIE 2




<br><br><br><br><br><br>




TRAVAIL PRÉSENTÉ À<br>
M. GNAGNELY SERGE DOGNY<br>
COURS INF5153 - GÉNIE LOGICIEL (CONCEPTION)<br>
GROUPE 040


<br><br>



PAR<br>
LYSANNE CHAGNON CHAL65550003<br>
FÉLIX PARADIS PARF04119608<br>
RENZO SALCEDO SALR02089408<br>
PHILIPPE BÉLANGER BELP07119706 <br>

<br><br><br>

11 décembre 2022
</div>
<div style="page-break-after: always;"></div>

----


# Diagramme de classes révisé
![Diagramme de classes](diagrammes_conception/images_diagrammes/diagrammes_patrons/diagramme_classes_patrons.png)<br/>

# Patrons de conception ajoutés
- Usine (Factory)
- État (State)
- Template method
- Façade

## État (State)

### Problématique
Il existe plusieurs phases dans l'exécution du jeu. En premier, on doit choisir quelle sorte de joueur sera notre adversaire,
ensuite on place nos bateaux, puis les deux joueurs s'échangent des tirs jusqu'à ce qu'un d'entre eux gagne, et finalement
on peut enregistrer la partie et la visualiser.

Dans notre implémentation précédente, les phases de jeu étaient écrites directement dans la classe Jeu, dans la méthode
*jouer()*. Cela peut potentiellement rendre la maintenance et l'ajout de nouveaux états difficile, surtout avec une méthode *jouer()* immense.

### Solution

![Diagramme de classes](diagrammes_conception/images_diagrammes/diagrammes_patrons/classes_état.png)<br/>

En utilisant le patron de conception **état**, on peut définir clairement ce que Jeu doit faire lorsqu'il est dans un état
spécifique. Pour chaque enfant de *PhaseJeu*, on redéfinit la méthode *prochaineAction()* pour qu'elle appelle la méthode de *Jeu* qui doit être exécuté durant l'état, 
puis, lorsque l'exécution est complétée, on passe à l'état suivant avec *effectuerPhase()*.

On améliore la maintenabilité du code, car si on veut ajouter plusieurs états, il s'agit simplement de créer une classe enfant de *PhaseJeu* qui appelle les bonnes méthodes de *Jeu*.

### Diagrammes de séquences

Durant le déroulement du jeu, 4 états sont utilisés. Les voici en ordre d'exécution :

#### PhaseSelectionnerJoueur
![Diagramme de classes](diagrammes_conception/images_diagrammes/diagrammes_patrons/sequence_état_1.png)<br/>

#### PhaseplacerBateaux
![Diagramme de classes](diagrammes_conception/images_diagrammes/diagrammes_patrons/sequence_état_2.png)<br/>

#### PhaseJouer
![Diagramme de classes](diagrammes_conception/images_diagrammes/diagrammes_patrons/sequence_état_3.png)<br/>

#### PhaseFinJeu
![Diagramme de classes](diagrammes_conception/images_diagrammes/diagrammes_patrons/sequence_état_4.png)<br/>

-----

## Facade

### Problématique

Les joueurs humains ne doivent pas avoir accès à l'implémentation des éléments
du jeu. Ils ne doivent pas pouvoir contrôler directement, les plateaux, les bateaux
ou encore la mécanique de vérification des tirs. C'est pourquoi il est naturel
d'utiliser le patron façade sur la classe jeu.


### Solution

Ce patron est bien représenté dans le diagramme de classes général:

![Diagramme de classes](diagrammes_conception/images_diagrammes/diagrammes_patrons/diagramme_classes_patrons.png)<br/>

En utilisant le patron de conception **facade**, on peut cacher l'implémentation du jeu de l'utilisateur. Celui-ci dispose
donc d'une interface avec laquelle il est facile d'interagir. Le jeu délègue ensuite les actions aux composants
du programme appropriés.

### Diagrammes de séquences

On peut voir ce patron en action dans plusieurs diagrammes de séquence ou le joueur
interragit avec le jeu, comme par-exemple :

![Diagramme de seq](diagrammes_conception/images_diagrammes/placer_navire.png)<br/>

![Diagramme de seq](diagrammes_conception/images_diagrammes/choisir_case.png)<br/>