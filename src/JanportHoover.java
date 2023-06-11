public class JanportHoover {
    int x, y;
    char orientation;

    int gridSizeX, gridSizeY;

    static final char north = 'N';
    static final char south = 'S';
    static final char east = 'E';
    static final char west = 'W';
    static final char right = 'D';
    static final char left = 'G';
    static final char forward = 'A';

    public JanportHoover(int x, int y, char orientation, int gridSizeX, int gridSizeY) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;
    }

    /**
     * Exécuter les instructions
     */
    public void runInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case right -> rotateRight();
                case left -> rotateLeft();
                case forward -> moveForwardInCurrentDirection();
                default -> throw new IllegalStateException("Valeur instruction inattendue: " + instruction);
            }
        }
    }

    /**
     * Tourner à droite
     */
    private void rotateRight() {
        switch (orientation) {
            case north -> orientation = east;
            case east -> orientation = south;
            case south -> orientation = west;
            case west -> orientation = north;
            default -> throw new IllegalStateException("Valeur orientation inattendue: " + orientation);
        }
    }

    /**
     * Tourner à gauche
     */
    private void rotateLeft() {
        switch (orientation) {
            case north -> orientation = west;
            case east -> orientation = north;
            case south -> orientation = east;
            case west -> orientation = south;
            default -> throw new IllegalStateException("Valeur orientation inattendue: " + orientation);
        }
    }

    /**
     * Avancer
     */
    private void moveForwardInCurrentDirection() {
        switch (orientation) {
            case north -> {
                if (y < gridSizeY - 1) {
                    y++;
                }
            }
            case east -> {
                if (x < gridSizeX - 1) {
                    x++;
                }
            }
            case south -> {
                if (y > 0) {
                    y--;
                }
            }
            case west -> {
                if (x > 0) {
                    x--;
                }
            }
            default -> throw new IllegalStateException("Valeur orientation inattendue: " + orientation);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getOrientation() {
        return orientation;
    }

}
