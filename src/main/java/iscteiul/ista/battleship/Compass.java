package iscteiul.ista.battleship;

/**
 * The four supported ship orientations and the value used for an invalid orientation.
 */
public enum Compass {
    /** North orientation. */
    NORTH('n'),
    /** South orientation. */
    SOUTH('s'),
    /** East orientation. */
    EAST('e'),
    /** West orientation. */
    WEST('o'),
    /** Value used when an orientation character is not recognized. */
    UNKNOWN('u');

    private final char c;

    Compass(char c) {
        this.c = c;
    }

    /**
     * Returns the character used to represent this orientation.
     *
     * @return the orientation character
     */
    public char getDirection() {
        return c;
    }

    /**
     * Returns the orientation character as a string.
     *
     * @return the orientation character
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converts an orientation character to a compass value.
     *
     * @param ch the orientation character
     * @return the matching compass value, or {@link #UNKNOWN} when unrecognized
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
