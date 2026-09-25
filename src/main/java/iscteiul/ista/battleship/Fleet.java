/**
 * Represents a fleet of ships in the Battleship game.
 * This class manages a collection of ships, handling operations such as
 * adding new ships, checking their status, and preventing collisions
 * or out-of-bounds placements.
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

public class Fleet implements IFleet {

    /**
     * Prints the details of all ships in a given list to the console.
     *
     * @param ships The list of ships to be printed
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    /**
     * The list of ships currently in the fleet.
     */
    private List<IShip> ships;

    /**
     * Constructs a new, empty Fleet.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Retrieves all the ships currently in the fleet.
     *
     * @return a list containing all the ships in the fleet
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Attempts to add a new ship to the fleet.
     * A ship is successfully added only if the fleet has not reached its maximum
     * capacity ({@code FLEET_SIZE}), the ship is placed entirely within the board
     * limits, and there is no risk of collision with existing ships.
     *
     * @param s The ship to be added to the fleet
     * @return {@code true} if the ship was successfully added, {@code false} otherwise
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Retrieves a list of ships that match a specific category (e.g., "Galeao", "Nau").
     *
     * @param category The category name to filter the ships by
     * @return a list of ships belonging to the specified category
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Retrieves a list of all ships in the fleet that are still floating
     * (i.e., not completely sunk).
     *
     * @return a list of floating ships
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Finds the ship occupying a specific position on the board.
     *
     * @param pos The position to check on the board
     * @return the {@link IShip} at the given position, or {@code null} if no ship occupies that position
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Checks if a given ship is placed entirely within the boundaries of the game board.
     *
     * @param s The ship to check
     * @return {@code true} if the ship is inside the board limits, {@code false} otherwise
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Checks if a given ship risks a collision by being placed too close to
     * any existing ship already in the fleet.
     *
     * @param s The ship to check for potential collisions
     * @return {@code true} if there is a collision risk, {@code false} if the placement is safe
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }

    /**
     * Prints the overall state of the fleet to the console.
     * This includes printing all ships, all floating ships, and a breakdown
     * of ships by their specific categories.
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Prints all ships in the fleet that belong to a particular category.
     *
     * @param category The category of ships of interest
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    /**
     * Prints all the ships in the fleet that are still floating (not yet sunk).
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Prints all the ships currently in the fleet, regardless of their status.
     */
    void printAllShips() {
        printShips(ships);
    }

}