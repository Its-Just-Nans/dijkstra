# INF103 : Dijkstra avec JAVA

## Le sujet du projet

Si vous avez bien réalisés les TPs, vous avez normalement une implémentation de l’algorithme de Dijkstra.

Le reste du projet consiste à concevoir, et réaliser une très belle interface graphique qui illustre l’algorithme de Dijkstra.

On attend de vous entre autres :

- un programme graphique interactif avec des boutons, des menus, etc.
- un affichage du graphe ;
- la définition d’un point de départ et d’arrivée en cliquant sur le graphe ;
- la résolution interactive du plus court chemin et son affichage ;
- la possibilité de charger un nouveau graphe, d’éditer un graphe et de sauver un graphe dans un fichier texte.

On pourra, par exemple mais **tout autre idée sera aussi bonne**, utiliser la notion de labyrinthe pour représenter la notion de graphe. Deux cases du labyrinthe sont connectées si elles sont contiguës et s’il n’y a pas de mur entre elles.

## Fonctionnement et historique

Au début du projet, j'ai voulu continuer sur une interface graphique avec des dessins, je trouve ça plus original qu'un simple labyrinthe et dans le sujet il y avait écrit `tout autre idée sera aussi bonne`. Mais après avoir fait une bonne partie du programme, le second professeur de JAVA (en TP), m'a dit qu'il fallait faire un labyrinthe et non pas un dessin graphique. J'ai demandé également à M.BELLOT son avis et il m' adit que l'interface dessin était bien. J'ai donc fait les deux interfaces : dessin et labyrinthe.

Le dessin étend la classe `Maze`, donc certaine méthodes sont ré-implémentés. Le labyrinthe utilise la classe `Maze` définit aux TP 6,7,8,9.

Les deux interface ainsi que les menus sont relativement bien organisés dans différent dossier (pour faciliter le développement).

Dans l'interface, on peut changer entre les deux interfaces (dessin et labyrinthe) avec le bouton "Changer" pour aller sur l'interface sélectionnée.

## Ajouts

J'ai pu faire quelques ajouts supplémentaires au programme :
- ajout d'un icône
- ajout d'une option "taille des cases"
- ajout d'un option de traduction des menus (Télécom Paris, école internationale !)
- script de compilation du projet
- création d'une classe `Modal` pour simplifier l'utiliser des affichages
- création d'une classe `Constant` pour la gestion des traductions et des constantes
- bouton d'aide pour décrire le fonctionnement des interfaces

## Outils

J'ai utilisé VSCode au lieu d'Eclipse car :
- VScode à une très bonne gestion du projet JAVA
- il faut installer Eclipse
- je trouve le debugger de VSCode beaucoup plus simple (surtout si on a l'habitude)

Ainsi, je recommande l'utilisation de VSCode !

## JavaDoc

Ma JavaDoc a été générée automatiquement. Je n'ai pas mis de commentaires supplémentaires car le nom des fonctions est parlant.

## Builder le projet

Il est possible que le build ne fonctionne pas sur Windows (car il nécessite des fonctions Unix), On peut néanmoins le construire sur Windows avec des outils comme `WSL` ou `GIT Bash`.

```
# download jdk
sudo apt install default-jdk
# download make
sudo apt install make

# run build command
make build
```

## LICENSE

Licensed under the MIT License - [LICENSE](LICENSE)
