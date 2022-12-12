#  Projet TP2 INF5153 - equipe9 

## _README_
Description des particularités présentes et du fonctionnement d'exécution

## Particularités
- Notre code respecte la convention d'écriture camel case.
- La langue choisie pour l'écriture du projet est l'anglais.
- Chacune des méthodes fait environs 10 lignes.
- Aucune ligne dans le projet ne dépasse 120 caractères.
- Peu de commentaires car les noms de variables/méthodes/attributs sont assez descriptifs.

## Patron de conception utilisé
- Factory
- State
- Template method
- Façade

## Instructions d'exécution
- A. Pour commencer une partie, exécutez le code à partir d'un IDE  
- B. Vous verrez le menu principal sur le terminal, selectionnez l'option désirée.
>~~~
>   1 - Joueur une nouvelle partie
>   2 - Visualiser une partie
>   3 - Quitter
>~~~
- B.1 option 1 choisie: Choisissez le mode de jeu
>~~~
>   1 - Jouer contre un ordinateur
>   2 - Jouer contre un humain
>~~~
- B.1.1 Option 1 choisie (joueur ordinateur): Choisissez la difficulté 
>~~~
>   1 - Ordinatur débutant
>   2 - Ordinateur avancé
- C. option 1 ou 2 choisie: Debut de la partie
>~~~
>   Tirs effectués :
>   A B C D E F G H I J
>  1  _ _ _ _ _ _ _ _ _ _
>  2  _ _ _ _ _ _ _ _ _ _
>  3  _ _ _ _ _ _ _ _ _ _
>  4  _ _ _ _ _ _ _ _ _ _
>  5  _ _ _ _ _ _ _ _ _ _
>  6  _ _ _ _ _ _ _ _ _ _
>  7  _ _ _ _ _ _ _ _ _ _
>  8  _ _ _ _ _ _ _ _ _ _
>  9  _ _ _ _ _ _ _ _ _ _
>  10 _ _ _ _ _ _ _ _ _ _
>~~~
- C.1 Choisissez l'amplacement de vos 5 bateaux dans le plateau bateau indexé
>~~~
>   Plateau de bateaux:
>   A B C D E F G H I J
>   1  B B B B B _ _ _ _ _
>   2  B B B B B _ _ _ _ _
>   3  B B B B _ _ _ _ _ _
>   4  B B _ _ _ _ _ _ _ _
>   5  B _ _ _ _ _ _ _ _ _
>   6  _ _ _ _ _ _ _ _ _ _
>   7  _ _ _ _ _ _ _ _ _ _
>   8  _ _ _ _ _ _ _ _ _ _
>   9  _ _ _ _ _ _ _ _ _ _
>   10 _ _ _ _ _ _ _ _ _ _
>~~~
- C.1.1 Si case non valide, recommencez votre choix
>~~~
>   Veuillez entrer les coordonnées du croiseur qui utilise 4 cases de gauche à droite ou de haut en bas (exemple: B1 B2 B3 B4):
>   a1 b1 b2 b3
>   Erreur, votre entrée n'est pas valide!
>~~~

- C.2 Votre adversaire place ses 5 bateaux
- C.3 Choisissez votre premier tir à partir du plateau Tir
>~~~
>   Veuillez entrer la coordonnée du tir (exemple: A1):
>   a1
>~~~
- C.3.1 Si case non valide, recommencez votre choix
>~~~
>   Veuillez entrer la coordonnée du tir (exemple: A1):
>   b11
>   Erreur, votre entrée n'est pas valide!
>   Veuillez entrer la coordonnée du tir (exemple: A1):
>~~~
- C.4 C'est le tour à votre adversaire.
- C.5 La partie continue jusqu'à ce qu'il y ait un gagnant 
- B.1.2 Option 2 choisie (jouer contre un humain): Faire étapes C à C.1.5
- B.2 Option 2 choisie: Visualiser une partie
- B.2.1 Chemin vers votre fichier
>~~~
>   Entrez le chemin vers le fichier de sauvegarde: ~/sauvegardes/exemple.json
>   Visualisation de la partie: 
>   1  B B B B B _ _ _ _ _
>   2  B B B B B _ _ _ _ _
>   3  B B B B _ _ _ _ _ _
>   4  B B _ _ _ _ _ _ _ _
>   5  B _ _ _ _ _ _ _ _ _
>   6  _ _ _ _ _ _ _ _ _ _
>   7  _ _ _ _ _ _ _ _ _ _
>   8  _ _ _ _ _ _ _ _ _ _
>   9  _ _ _ _ _ _ _ _ _ _
>   10 _ _ _ _ _ _ _ _ _ _
>
>   1  _ _ _ _ _ _ _ _ _ _
>   2  _ _ _ _ _ _ _ _ _ _
>   3  _ _ _ _ _ _ _ _ _ _
>   4  _ _ _ _ _ _ _ _ _ _
>   5  _ _ _ _ _ _ _ _ _ _
>   6  _ _ _ _ _ _ _ _ _ _
>   7  _ _ _ _ _ _ _ _ _ _
>   8  _ _ _ _ _ _ _ _ _ _
>   9  _ _ _ _ _ _ _ _ _ _
>   10 _ _ _ _ _ _ _ _ _ _
>   Appuyez sur entrée pour voir le prochain tour.

- B.2.1.1 Le programme se termine si le chemin vers le fichier est invalide
>~~~
>   Entrez le chemin vers le fichier de sauvegarde: asdda
>   Erreur lors du chargement. Le programme se terminera maintenant
>~~~
>
- B.2.2 Continuer la visualisation de la partie
>~~~
>  Appuyez sur entrée pour voir le prochain tour. 
>~~~
- B.3 Option 3 choisie: Sortie du jeu

## Type de joueurs
- Personne (2 max) 
- AIDébutant 
- AIAvancé