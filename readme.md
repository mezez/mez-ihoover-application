# Ihoover Application

## Auteur

Chimezirim Victor EKEMAM


## Exécution
Il suffit d'exécuter le fichier Main.java, de préférence dans l'IDE Intellij.

## Documentation:

Main.java
- Contient la méthode principale utilisée pour l'exécution de l'application. Toutes les variables d'entrée sont prises au moment de l'exécution dans la méthode principale et transmises à la classe JanportHoover.
- Affiche la position finale et l'orientation de l'aspirateur à la fin de l'exécution.

JanportHoover.java
- Le constructor de JanportHoover initialise les propriétés de la classe en fonction des valeurs fournies par l'utilisateur.
- runInstructions traite et exécute la séquence d'instructions fournies par l'utilisateur.
- rotateRight: Tourne l'aspirateur de 90 degrés vers la droite par rapport à son orientation actuelle.
- rotateLeft: Tourne l'aspirateur de 90 degrés vers la gauche par rapport à son orientation actuelle.
- moveForward: Déplace l'aspirateur d'un pas vers l'avant par rapport à son orientation actuelle.
- La classe contient également les getters nécessaires.