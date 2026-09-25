/**
 * Represents a Caravel ship in the Battleship game.
 * This class extends the {@link Ship} class and defines the specific
 * characteristics of a Caravel, which occupies 2 positions and is named "Caravela".
 */
package iscteiul.ista.battleship;

public class Caravel extends Ship {
    private static final Integer SIZE = 2;
    private static final String NAME = "Caravela";

    /**
     * Constructs a new Caravel ship.
     * Calculates the positions occupied by the ship on the board based on the
     * initial position and the chosen bearing (North/South for vertical,
     * East/West for horizontal).
     *
     * @param bearing the direction where the Caravel heads to (North, South, East, or West)
     * @param pos     the initial position for placing the Caravel on the board
     * @throws NullPointerException     if the provided bearing is null
     * @throws IllegalArgumentException if the provided bearing is invalid or unsupported
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /**
     * Gets the size of the Caravel.
     *
     * @return the number of positions the Caravel occupies on the board (which is 2)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}