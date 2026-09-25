# :shipit: Battleship

Basic academic version of the Battleship game, built as a Java console-based project.

## 💕 Identificação

**Group:** M&MS  
**Course:** LEI

| Name           | Number |
|----------------|--------|
| Miguel Santos  | 125321 |
| Miguel Matos   | 129886 |
| Santiago Alves | 129861 |

## 1. Setup

Requirements:
- Java 17+
- Maven

To run the game from the project root:

```bash
mvn compile
mvn exec:java -Dexec.mainClass=iscteiul.ista.App
```

If you are using an IDE, you can also run the main class in `App.java` directly.

## 2. How to play

This version is a text-based game that runs in the terminal. The application waits for commands and then reacts depending on the command entered.

At the start, the game expects one of these commands:

| Command | What it does |
|---------|--------------|
| `nova` | Creates a new fleet and starts the setup process. |
| `estado` | Prints the current status of the fleet. |
| `mapa` | Shows the fleet map. |
| `rajada` | Fires a round of 3 shots. |
| `ver` | Shows all valid shots already fired. |
| `desisto` | Exits the game. |

### Fleet setup (`nova`)

When you type `nova`, the game starts asking for ships one by one.

For each ship you need to enter:
1. The ship type: `barca`, `caravela`, `nau`, `fragata`, `galeao`
2. The starting row
3. The starting column
4. The direction: `n`, `s`, `e`, `o`

The program validates the placement and rejects ships that:
- leave the board,
- overlap existing ships,
- are too close to another ship.

### Shooting (`rajada`)

When `rajada` is selected, the game asks for 3 shots. For each shot, enter:
- row
- column

The game then checks whether the shot is:
- a valid position,
- a repeated shot,
- a hit on a ship,
- a sunk ship.

When a ship is completely destroyed, the program reports it.

### Viewing the board

- `estado` shows the current fleet and ship information.
- `mapa` displays the fleet positions on the board.
- `ver` shows the positions that were already fired at and counted as valid shots.

### Exiting

Type `desisto` to leave the game.

## 3. Example flow

```text
nova
barca
0
0
e
caravela
1
2
n
estado
mapa
rajada
2
2
3
3
4
4
ver
desisto
```

The exact input may vary depending on how you build the fleet, but the structure remains the same: add ships, inspect them, shoot, then quit.

## 4. Ship types and sizes

| Image | Ship | Size | Number in fleet | Link |
|-------|------|------|-----------------|------|
| ![image info](https://thumb.wikimedia.org/wikipedia/commons/thumb/5/5a/Padre_Eterno_em_gravura_de_1683.jpg/500px-Padre_Eterno_em_gravura_de_1683.jpg?utm_source=en.wikipedia.org&utm_campaign=imageinfo&utm_content=thumbnail?download) | Galleon (Porta-aviões) | 5 | 1 | [Galleon](https://en.wikipedia.org/wiki/Galleon?utm_source=gemini) |
| ![image info](https://upload.wikimedia.org/wikipedia/commons/5/55/La_Boudeuse.jpg?utm_source=en.wikipedia.org&utm_campaign=imageinfo&utm_content=original) | Frigate (Navio de 4 canhões) | 4 | 1 | [Frigate](https://en.wikipedia.org/wiki/Frigate?utm_source=gemini) |
| ![image info](https://thumb.wikimedia.org/wikipedia/commons/thumb/c/c3/Vila_do_Conde_2018_%289%29.jpg/500px-Vila_do_Conde_2018_%289%29.jpg?utm_source=en.wikipedia.org&utm_campaign=imageinfo&utm_content=thumbnail) | Carrack (Navio de 3 canhões) | 3 | 2 | [Carrack](https://en.wikipedia.org/wiki/Carrack?utm_source=gemini) |
| ![image info](https://upload.wikimedia.org/wikipedia/commons/6/64/LaPinta.jpg?utm_source=en.wikipedia.org&utm_campaign=imageinfo&utm_content=original) | Caravel (Navio de 2 canhões) | 2 | 3 | [Caravel](https://en.wikipedia.org/wiki/Caravel?utm_source=gemini) |
| ![image info](https://upload.wikimedia.org/wikipedia/en/6/64/Dutch_barge.jpg?utm_source=en.wikipedia.org&utm_campaign=imageinfo&utm_content=original) | Barge (Submarino) | 1 | 4 | [Barge](https://en.wikipedia.org/wiki/Barge?utm_source=gemini) |

## 5. Notes

This project is mainly a learning exercise in Java OO design and Battleship rules. It is not a full two-player graphical game; it is a command-line game focused on fleet creation, board validation, shot tracking, and ship sinking logic.

