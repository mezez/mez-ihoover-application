import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Saisir la taille de la grille de la pièce......");

            System.out.print("x eg 10: ");
            int gridSizeX = scanner.nextInt();

            System.out.print("y eg 10: ");
            int gridSizeY = scanner.nextInt();

            System.out.println("Saisir la position initiale et l'orientation de l'aspirateur...");
            System.out.print("Coordonnée initiale x eg 5: ");
            int initialX = scanner.nextInt();
            while ((initialX < 0) || (initialX > gridSizeX - 1)) {
                System.out.println("La position initiale x ne peut pas être en dehors des limites de la pièce : entre 0 et " + (gridSizeX - 1));
                System.out.print("Coordonnée initiale x eg 5: ");
                initialX = scanner.nextInt();
            }

            System.out.print("Coordonnée initiale y eg 5:");
            int initialY = scanner.nextInt();
            while ((initialY < 0) || (initialY > gridSizeY - 1)) {
                System.out.println("La position initiale y ne peut pas être en dehors des limites de la pièce : entre 0 et " + (gridSizeY - 1));
                System.out.print("Coordonnée initiale y eg 5: ");
                initialY = scanner.nextInt();
            }

            System.out.print("Orientation initiale eg N: ");
            char initialOrientation = Character.toUpperCase(scanner.next().charAt(0));
            ArrayList<Character> acceptableCoordinates = new ArrayList<>();
            acceptableCoordinates.add('N');
            acceptableCoordinates.add('E');
            acceptableCoordinates.add('S');
            acceptableCoordinates.add('W');
            while (!acceptableCoordinates.contains(initialOrientation)) {
                System.out.println("L'orientation ne peut être que N, S, E ou W.");
                System.out.print("Orientation initiale eg N: ");
                initialOrientation = scanner.next().charAt(0);
            }

            System.out.println("Saisir les instructions eg DADADADAA: ");
            String instructions;
            while (true) {
                System.out.print("Saisir les instructions (seuls D, G et A peuvent être contenus dans la séquence d'instructions): ");
                instructions = scanner.next().toUpperCase();
                if (instructions.matches("[DGA]+")) {
                    break;
                }
                System.out.println("Instructions non valides. Veuillez saisir uniquement les caractères \"D\", \"G\" et \"A\".");
            }

            scanner.close();

            JanportHoover hoover = new JanportHoover(initialX, initialY, initialOrientation, gridSizeX, gridSizeY);
            hoover.runInstructions(instructions);

            System.out.println();
            System.out.println();
            System.out.println("Position finalw: x=" + hoover.getX() + " y=" + hoover.getY() +
                    " orientation=" + hoover.getOrientation());
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite. Veuillez vous assurer de saisir les types de données attendus pour chacune des entrées.");
            if (!e.getMessage().isEmpty()){
                System.out.println(e.getMessage());
            }
        }
    }

}