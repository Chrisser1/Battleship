package main.battleship.logic;

public class Board {
  
  public static final int SIZE = 10;
  
  private Cell[][] cells;

  public Board() {
    cells = new Cell[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        cells[i][j] = new Cell();
      }
    }
  }

  public Cell[][] getCells() {
    return cells;
  }

  public boolean hasShip(int x, int y) {
    return cells[x][y].isOccupied();
  }

  public void placeShip(Ship ship, int x, int y, boolean isVertical) {
    int length = ship.getType().getHoles();
    

    for (int i = 0; i < length; i++) {
      if (isVertical) {
        cells[x][y + i].occupy(ship);
      } else {
        cells[x + i][y].occupy(ship);
      }
    }


  }

  public void receiveAttack(int x, int y) {
    cells[x][y].receiveAttack();
  }
}
