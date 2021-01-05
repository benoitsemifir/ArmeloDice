# Dés Armello

Ce projet présente un façon de faire le système de dés du jeu [Armello](https://armello.com/).

## Partie 1

Un dé à 6 faces, avec du random.

## Partie 2

On veux lancer plusieurs dés, il nous faut donc un gobelet, son rôle est de lancer plusieurs dés (un conteneur de dés).

## Partie 3

Les dés magiques d'Armello, la valeur du dé déclenche un événement :

- 1 - épée: ajoute un point d'attaque
- 2 - bouclier: ajoute un point de défense
- 3 - soleil: ajoute un point d'attaque le jour ou casse le dés la nuit
- 4 - lune: ajoute un point d'attaque la nuit ou casse le dés le jour
- 5 - Bien: ajoute un point d'attaque si le joueur choisi le chemin du bien et explose le dé*
- 6 - Mal: ajoute un point d'attaque si le joueur choisi le chemin du Mal et explose le dé*

*explose le dé: Le lancer est conservé et le dé est relancé.

## Partie 4

Implémenter le moteur de jeu:

- Ajouter le système jour / nuit => variant au cours de la partie, fixe durant les lancés.
- Ajouter le system bien / mal => propre au joueur (peux varier au cours de la partie).