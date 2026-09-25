classDiagram
direction BT

class Barge {
- Integer SIZE
- String NAME
}
class Caravel {
- String NAME
- Integer SIZE
}
class Carrack {
- String NAME
- Integer SIZE
}
class Compass {
<<enumeration>>
+ EAST
+ WEST
- char c
+ NORTH
+ UNKNOWN
+ SOUTH
}
class Fleet {
- List~IShip~ ships
}
class Galleon {
- Integer SIZE
- String NAME
}
class IFleet {
<<Interface>>
+ Integer FLEET_SIZE
+ Integer BOARD_SIZE
}
class IGame {
<<Interface>>
}
class IPosition {
<<Interface>>
}
class IShip {
<<Interface>>
}
class Position {
- boolean isHit
- int row
- boolean isOccupied
- int column
}
class Ship {
- String GALEAO
- String category
- String NAU
- Compass bearing
- String FRAGATA
- IPosition pos
- String CARAVELA
- String BARCA
# List~IPosition~ positions
}
class Tasks {
- String NOVAFROTA
- String RAJADA
- String DESISTIR
- Logger LOGGER
- String STATUS
- int NUMBER_SHOTS
- String VERTIROS
- String BATOTA
- String GOODBYE_MESSAGE
}

Barge --> Ship
Caravel --> Ship
Carrack --> Ship
Fleet ..> IFleet
Fleet "1" *--> "*" IShip : ships
Galleon --> Ship
Position ..> IPosition
Ship "1" *--> "1" Compass : bearing
Ship "1" *--> "*" IPosition : positions
Ship ..> IShip

O diagrama de classes apresenta a arquitetura e os componentes do modelo de dados para uma implementação do jogo da Batalha Naval (adaptado ao contexto dos Descobrimentos com caravelas, naus e galeões). A estrutura está organizada em interfaces principais — como IGame, IFleet, IShip e IPosition — que definem os contratos fundamentais do sistema, permitindo o desacoplamento e a modularidade do código.

A gestão do tabuleiro e do posicionamento baseia-se na classe Position (que implementa IPosition), responsável por guardar as coordenadas, se uma célula está ocupada e se já foi atingida. As embarcações concretas (Barge, Caravel, Carrack e Galleon) herdam de uma classe base Ship (que implementa IShip), a qual agrega um conjunto de posições ocupadas no mapa e uma orientação geográfica definida pela enumeração Compass (NORTH, SOUTH, EAST, WEST).

Por sua vez, a frota do jogador é representada pela classe Fleet (que implementa IFleet), responsável por agrupar e gerir uma coleção de instâncias de IShip. O sistema conta ainda com a classe Tasks, que funciona como centralizadora de comandos, mensagens de estado e regras de interação (como rajadas de tiros, desistências ou comandos de controlo de jogo).