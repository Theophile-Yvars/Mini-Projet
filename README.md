# Mini-Projet

--
## Contexte
----

Ce projet est réalisé dans le cadre d'une licence 3 informatique, à l'UPVD. Il répond à un mini projet en cours d'interphace graphique. C'est une premiere application pour nous exercer. Nous avions quelques consignes pour mettre en oeuvre cette application. 

## Exigence du projet 

Attendus techniques
- Vous avez à développer une application comportant plusieurs activités (au moins 4, la principale inclue), répondant à un
usage pratique, et appliquant les pratiques discutées en cours (persistance de données, utilisation des ressources pour la
traduction, etc).
- Par ailleurs, votre application doit proposer au moins un Intent implicite (l'activité résultante ne compte pas parmi les 4
attendues)
- De plus, l'utilisation d'un Spinner est imposée

## Electro Calcul

Electro calcul est le nom de mon application. Elle porte sur des calculs en electronique.
L'utilisateur à le choix de faire un calcul sur un AOP non inverseur, un filtre passe bas et le calcul d'une résistance pour une led.

### Main

<p align="center">
<img src="https://user-images.githubusercontent.com/79571637/109722911-a738ac80-7bad-11eb-9abd-fcdd6ad28b3b.jpg" width="200">
</p>

Dans le main, on peut choisir quelque calcul electronuique on veut faire. On peut aussi cliquer sur l'icone de google play pour acceder au site, pour avoir des propositions d'autres applications electroniques.

### Calcul d'un filtre passe-Bas

<p align="center">
<img width="200" src="https://user-images.githubusercontent.com/79571637/109723757-d26fcb80-7bae-11eb-837b-31d24a973c8d.jpg">
</p>

L'utilisateur peut entré les informations de 2 éléments sur 3. L'application se charge de faire les calculs pour trouver le 3 élémenents. On peut choisir de saisir la résistance, la capacité et/ou le fréquence de coupure du filtre.

### Calcul de la resistance pour un led

<p align="center">
<img src="https://user-images.githubusercontent.com/79571637/109723953-18c52a80-7baf-11eb-9cf2-2b1fc40daaac.jpg" width="200">
</p>

L'utilisateur indique simplement la tension d'alimentation de son systéme, puis l'application se charge de calculer la résistance.
La tension de la led est enregistré à 2.2V, et l'intensité de celle ci est enregistré à 20 mA. Ce sont des valeurs standard pour des leds.

### Calcul d'un Aop non-inverseur

<p align="center">
<img src="https://user-images.githubusercontent.com/79571637/109724101-51650400-7baf-11eb-932d-a56b266f0e94.jpg" width="200">
</p>

L'utilisateur indique 3 éléments sur 4. La saisie de la tension d'alimentation, Ve et il a le choix de saisir 2 informations parmis les 2 résistances et le gain de l'Aop.
L'application se chargera de trouver l'inconnu manquante.

## Réalisation

Théophile Yvars : Etudiant de L3 Informatique à l'UPVD. 2021

## Amélioration

L'application propose qu'un filtre et un Aop. Hors il existe toute une multitude d'Aop et de filtre.
L'application pourrait s'étendre à plusieur variété. 
