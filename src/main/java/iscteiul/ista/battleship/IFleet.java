package iscteiul.ista.battleship;

import java.util.List;

/**
 * Defines the collection of ships placed on the game board.
 */
public interface IFleet {
    /** The length and width of the square game board. */
    Integer BOARD_SIZE = 10;
    /** The maximum number of ships in a fleet. */
    Integer FLEET_SIZE = 10;

    /** @return all ships currently in the fleet */
    List<IShip> getShips();

    /**
     * Adds a ship when it fits on the board and does not conflict with another ship.
     *
     * @param s the ship to add
     * @return {@code true} when the ship was added
     */
    boolean addShip(IShip s);

    /**
     * Returns all ships with a given category.
     *
     * @param category the category to search for
     * @return ships whose category matches {@code category}
     */
    List<IShip> getShipsLike(String category);

    /** @return ships with at least one position that has not been hit */
    List<IShip> getFloatingShips();

    /**
     * Finds the ship occupying a position.
     *
     * @param pos the position to search for
     * @return the occupying ship, or {@code null} when no ship is there
     */
    IShip shipAt(IPosition pos);

    /** Prints the current fleet status. */
    void printStatus();
}
