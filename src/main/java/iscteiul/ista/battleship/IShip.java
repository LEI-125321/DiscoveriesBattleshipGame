package iscteiul.ista.battleship;

import java.util.List;

/**
 * Defines the state and behavior common to every ship in the game.
 */
public interface IShip {
    /** @return the ship category name */
    String getCategory();

    /** @return the number of board positions occupied by the ship */
    Integer getSize();

    /** @return the board positions occupied by the ship */
    List<IPosition> getPositions();

    /** @return the initial position supplied when the ship was created */
    IPosition getPosition();

    /** @return the ship's orientation */
    Compass getBearing();

    /**
     * Tests whether at least one occupied position has not been hit.
     *
     * @return {@code true} when the ship is still afloat
     */
    boolean stillFloating();

    /** @return the smallest row occupied by the ship */
    int getTopMostPos();

    /** @return the largest row occupied by the ship */
    int getBottomMostPos();

    /** @return the smallest column occupied by the ship */
    int getLeftMostPos();

    /** @return the largest column occupied by the ship */
    int getRightMostPos();

    /**
     * Tests whether the ship occupies a position.
     *
     * @param pos the position to test
     * @return {@code true} when the ship occupies {@code pos}
     */
    boolean occupies(IPosition pos);

    /**
     * Tests whether this ship is adjacent to another ship.
     *
     * @param other the ship to test
     * @return {@code true} when any positions of the ships are adjacent
     */
    boolean tooCloseTo(IShip other);

    /**
     * Tests whether this ship is adjacent to a position.
     *
     * @param pos the position to test
     * @return {@code true} when the ship is adjacent to {@code pos}
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Marks the matching occupied position as hit.
     *
     * @param pos the position targeted by the shot
     */
    void shoot(IPosition pos);
}
