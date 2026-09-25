/**
 * Represents a Barge ship in the Battleship game.
 * This class extends the {@link Ship} class and defines the specific
 * characteristics of a Barge, which occupies 1 position and is named "Barca".
 */
package iscteiul.ista.battleship;

public class Barge extends Ship {
    private static final Integer SIZE = 1;
    private static final String NAME = "Barca";

    /**
     * Constructs a new Barge ship.
     * Sets the position occupied by the ship on the board based on the
     * initial position. Since a Barge only occupies a single position,
     * the bearing does not affect its placement coordinates.
     *
     * @param bearing the direction where the Barge heads to (North, South, East, or West)
     * @param pos     the initial (and only) position for placing the Barge on the board
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Gets the size of the Barge.
     *
     * @return the number of positions the Barge occupies on the board (which is 1)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}