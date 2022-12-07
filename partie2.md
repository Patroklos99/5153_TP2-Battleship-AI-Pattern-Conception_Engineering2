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

11 DÉCEMBRE 2022
</div>
<div style="page-break-after: always;"></div>

----

# TABLE DES MATIÈRES

### Patrons de conception
- **Decorator**
- **Singleton** <br/>
- **Template method** <br/>
- **Facade** <br/>

### Implémentation et différences de conception



<div style="page-break-after: always;"></div>

# Patrons de conception
***
## Decorator


![Diagramme de classes_decorator](diagrammes_conception/images_diagrammes/classes_decorator.png)<br/>

------
...description

-----

## Singleton

![Diagramme de classes_singleton](diagrammes_conception/images_diagrammes/classes_singleton.png)<br/>

![Diagramme de seq1_singleton](diagrammes_conception/images_diagrammes/sequence_singleton_charger_partie.png)<br/>

![Diagramme de seq2_singleton](diagrammes_conception/images_diagrammes/sequence_singleton_enregistrer_partie.png)<br/>

![Diagramme de seq3_singleton](diagrammes_conception/images_diagrammes/sequence_singleton_nouvelle_partie.png)<br/>

-----

...description

-----

## Template method

-----

![Diagramme de classes_template](diagrammes_conception/images_diagrammes/classes_template_method.png)<br/>
![Diagramme de seq_template](diagrammes_conception/images_diagrammes/sequence_template_method_1.png)<br/>
![Diagramme de seq_template](diagrammes_conception/images_diagrammes/sequence_template_method_2.png)<br/>

-----

## Facade

-----

![Diagramme de classes_decorator](diagrammes_conception/images_diagrammes/classes_decorator.png)<br/>

-----

L'objet Jeu représente ici le patron facade, en agissant comme interface pour
plusieurs sous-systèmes. Les joueurs communiquent avec le jeu, qui se charge de vérifier les règles
et d'appeler les bons objets.