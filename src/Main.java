import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Saisir la taille de la grille de la pièce......");
            int gridSizeX = getGridSize("x", scanner);
            int gridSizeY = getGridSize("y", scanner);

            System.out.println("Saisir la position initiale et l'orientation de l'aspirateur...");
            int initialX = getInitialPosition("x", scanner, gridSizeX);
            int initialY = getInitialPosition("y", scanner, gridSizeY);


            char initialOrientation = getInitialOrientation(scanner);

            String instructions = getInstructions(scanner);

            scanner.close();

            JanportHoover hoover = new JanportHoover(initialX, initialY, initialOrientation, gridSizeX, gridSizeY);
            hoover.runInstructions(instructions);

            System.out.println();
            System.out.println("Position finale: x=" + hoover.getX() + ", y=" + hoover.getY() +
                    ", orientation=" + hoover.getOrientation());
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite. Veuillez vous assurer de saisir les types de données attendus pour chacune des entrées.");
            if (!e.getMessage().isEmpty()){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getGridSize(String axis, Scanner scanner){
        System.out.print(axis +" eg 10: ");
        int gridSize = 0;
        try{
            gridSize= scanner.nextInt();
        }catch (Exception e){
            System.out.println("La taille de la grille pour l'axe "+ axis + " doit être un nombre entier");
            scanner.nextLine();
            gridSize = getGridSize(axis, scanner);
        }
        return gridSize;
    }

    public static int getInitialPosition(String axis, Scanner scanner, int axisGridSize){
        System.out.print("Coordonnée initiale " + axis + " eg 5: ");
        int initial = 0;
        try{
            initial = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Coordonnée initiale "+ axis + " doit être un nombre entier");
            scanner.nextLine();
            initial = getInitialPosition(axis, scanner, axisGridSize);
        }
        while ((initial < 0) || (initial > axisGridSize - 1)) {
            System.out.println("La position initiale x ne peut pas être en dehors des limites de la pièce : entre 0 et " + (axisGridSize - 1));
            System.out.print("Coordonnée initiale x eg 5: ");
            scanner.nextLine();
            initial = getInitialPosition(axis, scanner, axisGridSize);
        }
        return initial;
    }

    public static char getInitialOrientation(Scanner scanner){
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
            initialOrientation = Character.toUpperCase(scanner.next().charAt(0));
        }

        return initialOrientation;
    }

    public static String getInstructions(Scanner scanner){
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
        return instructions;
    }

}