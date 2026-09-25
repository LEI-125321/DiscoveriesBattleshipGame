# Arquitetura do Jogo Batalha Naval

O diagrama de classes apresenta a arquitetura e os componentes do modelo de dados para uma implementação do jogo da Batalha Naval (adaptado ao contexto dos Descobrimentos com caravelas, naus e galeões). A estrutura está organizada em interfaces principais — como IGame, IFleet, IShip e IPosition — que definem os contratos fundamentais do sistema, permitindo o desacoplamento e a modularidade do código.

A gestão do tabuleiro e do posicionamento baseia-se na classe Position (que implementa IPosition), responsável por guardar as coordenadas, se uma célula está ocupada e se já foi atingida. As embarcações concretas (Barge, Caravel, Carrack e Galleon) herdam de uma classe base Ship (que implementa IShip), a qual agrega um conjunto de posições ocupadas no mapa e uma orientação geográfica definida pela enumeração Compass (NORTH, SOUTH, EAST, WEST).

Por sua vez, a frota do jogador é representada pela classe Fleet (que implementa IFleet), responsável por agrupar e gerir uma coleção de instâncias de IShip. O sistema conta ainda com a classe Tasks, que funciona como centralizadora de comandos, mensagens de estado e regras de interação (como rajadas de tiros, desistências ou comandos de controlo de jogo).

Este projeto foi desenvolvido com o auxílio de modelos de linguagem baseados em Inteligência Artificial. GitHub Copilot, Gemini e ChatGPT foram utilizados como ferramentas de suporte para programação, depuração de erros e documentação.

Abaixo encontra-se o diagrama de classes do projeto:

```mermaid
classDiagram
  direction BT

  class IFleet {
    <<interface>>
    + Integer FLEET_SIZE
    + Integer BOARD_SIZE
  }
  class IGame {
    <<interface>>
  }
  class IPosition {
    <<interface>>
  }
  class IShip {
    <<interface>>
  }

  class Compass {
    <<enumeration>>
    + EAST
    + WEST
    + NORTH
    + SOUTH
    + UNKNOWN
    - char c
  }

  class Fleet {
    - List~IShip~ ships
  }
  class Position {
    - boolean isHit
    - boolean isOccupied
    - int row
    - int column
  }
  class Ship {
    - String GALEAO
    - String NAU
    - String FRAGATA
    - String CARAVELA
    - String BARCA
    - String category
    - Compass bearing
    - IPosition pos
    # List~IPosition~ positions
  }

  class Barge {
    - Integer SIZE
    - String NAME
  }
  class Caravel {
    - Integer SIZE
    - String NAME
  }
  class Carrack {
    - Integer SIZE
    - String NAME
  }
  class Galleon {
    - Integer SIZE
    - String NAME
  }

  class Tasks {
    - String NOVAFROTA
    - String RAJADA
    - String DESISTIR
    - String STATUS
    - String VERTIROS
    - String BATOTA
    - String GOODBYE_MESSAGE
    - int NUMBER_SHOTS
    - Logger LOGGER
  }

  %% Implementações de Interfaces
  Fleet ..|> IFleet 
  Position ..|> IPosition 
  Ship ..|> IShip 

  %% Heranças
  Barge --|> Ship 
  Caravel --|> Ship 
  Carrack --|> Ship 
  Galleon --|> Ship 

  %% Composições
  Fleet "1" *-- "*" IShip : ships
  Ship "1" *-- "1" Compass : bearing
  Ship "1" *-- "*" IPosition : positions
```
