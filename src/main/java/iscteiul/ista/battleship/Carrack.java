/**
 * Represents a Carrack ship in the Battleship game.
 * This class extends the {@link Ship} class and defines the specific
 * characteristics of a Carrack, which occupies 3 positions and is named "Nau".
 */
package iscteiul.ista.battleship;

public class Carrack extends Ship {
    private static final Integer SIZE = 3;
    private static final String NAME = "Nau";

    /**
     * Constructs a new Carrack ship.
     * Calculates the positions occupied by the ship on the board based on the
     * initial position and the chosen bearing (North/South for vertical,
     * East/West for horizontal).
     *
     * @param bearing the direction where the Carrack heads to (North, South, East, or West)
     * @param pos     the initial position for placing the Carrack on the board
     * @throws IllegalArgumentException if the provided bearing is invalid or unsupported
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Gets the size of the Carrack.
     *
     * @return the number of positions the Carrack occupies on the board (which is 3)
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}