# Ihoover Application

## Auteur

Chimezirim Victor EKEMAM

## Environnement de développement
- Langage de programmation: Java
- Version: 17.0.6

## Exécution
Il suffit d'exécuter le fichier Main.java, de préférence dans l'IDE Intellij.

## Documentation:

Main.java
- Contient la méthode main utilisée pour l'exécution de l'application. Toutes les variables d'entrée sont prises au moment de l'exécution dans la méthode principale à l'aide de méthodes supplémentaires dans la classe omme décrit ci-dessous et transmises à la classe JanportHoover.
- Affiche la position finale et l'orientation de l'aspirateur à la fin de l'exécution.
- getGridSize : Récupère la taille des grilles pour les axes x et y de la pièce.
- getInitialPosition:Récupère la position initiale de l'aspirateur dans la pièce.
- getInitialOrientation : Récupère l'orientation initiale de l'aspirateur dans la pièce.
- getInstructions : Récupère la série d'instructions à exécuter.

JanportHoover.java
- Le constructor de JanportHoover initialise les propriétés de la classe en fonction des valeurs fournies par l'utilisateur.
- runInstructions traite et exécute la séquence d'instructions fournies par l'utilisateur.
- rotateRight: Tourne l'aspirateur de 90 degrés vers la droite par rapport à son orientation actuelle.
- rotateLeft: Tourne l'aspirateur de 90 degrés vers la gauche par rapport à son orientation actuelle.
- moveForward: Déplace l'aspirateur d'un pas vers l'avant par rapport à son orientation actuelle.
- La classe contient également les getters nécessaires.

Note : Le système a été conçu de manière à pouvoir traiter avec élégance les cas limites tels que les entrées erronées ou non valides de l'utilisateur sans que le système ne s'arrête. Certaines contraintes ont également été prises en compte par discrétion dans la mise en œuvre.