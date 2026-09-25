package iscteiul.ista.battleship;

import java.util.List;

/**
 * Defines the operations and statistics for a battleship game.
 */
public interface IGame {
    /**
     * Fires at a board position.
     *
     * @param pos the position targeted by the shot
     * @return the ship sunk by the shot, or {@code null} otherwise
     */
    IShip fire(IPosition pos);

    /** @return all valid, non-repeated shots fired so far */
    List<IPosition> getShots();

    /** @return the number of repeated shots */
    int getRepeatedShots();

    /** @return the number of shots outside the board */
    int getInvalidShots();

    /** @return the number of successful hits */
    int getHits();

    /** @return the number of ships sunk */
    int getSunkShips();

    /** @return the number of ships that are still afloat */
    int getRemainingShips();

    /** Prints the board positions at which valid shots were fired. */
    void printValidShots();

    /** Prints the positions occupied by the fleet. */
    void printFleet();
}
