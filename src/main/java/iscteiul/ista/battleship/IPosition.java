package iscteiul.ista.battleship;

/**
 * Describes a coordinate on the board and its occupancy and hit state.
 */
public interface IPosition {
    /**
     * Returns the row coordinate.
     *
     * @return the zero-based row
     */
    int getRow();

    /**
     * Returns the column coordinate.
     *
     * @return the zero-based column
     */
    int getColumn();

    /**
     * Compares this position with another object by row and column.
     *
     * @param other the object to compare with
     * @return {@code true} when both positions have the same coordinates
     */
    boolean equals(Object other);

    /**
     * Tests whether another position is at most one row and one column away.
     * Diagonal positions are considered adjacent.
     *
     * @param other the position to test
     * @return {@code true} when the positions are adjacent or equal
     */
    boolean isAdjacentTo(IPosition other);

    /** Marks this position as occupied by a ship. */
    void occupy();

    /** Marks this position as hit by a shot. */
    void shoot();

    /**
     * Tests whether a ship occupies this position.
     *
     * @return {@code true} when occupied
     */
    boolean isOccupied();

    /**
     * Tests whether this position has been hit.
     *
     * @return {@code true} when hit
     */
    boolean isHit();
}
