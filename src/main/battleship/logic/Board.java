package main.battleship.logic;

public class Board {
  
  public static final int SIZE = 10;
  
  private Cell[][] cells;
  private int x, y, size;

  public Board(int x, int y, int size) {
    this.x = x;
    this.y = y;
    this.size = size;

    cells = new Cell[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        cells[i][j] = new Cell();
      }
    }
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getSize() {
    return this.size;
  }

  public Cell[][] getCells() {
    return cells;
  }

  public boolean hasShip(int x, int y) {
    return cells[x][y].isOccupied();
  }

  public boolean placeShip(Ship ship, int x, int y, boolean isVertical) {
    int length = ship.getType().getHoles();
    
    // Check if ship fits within the board
    if(isVertical) {
      if(y + length > SIZE) return false;
      for (int i = 0; i < length; i++) {
        if(cells[x][y + i].isOccupied()) return false;
      }
    } else {
      if(x + length > SIZE) return false;
      for (int i = 0; i < length; i++) {
        if(cells[x + i][y].isOccupied()) return false;
      }
    }
    
    // Place the ship
    for (int i = 0; i < length; i++) {
      if (isVertical) {
        cells[x][y + i].occupy(ship);
      } else {
        cells[x + i][y].occupy(ship);
      }
    }
    
    return true;
  }

  public void receiveAttack(int x, int y) {
    cells[x][y].receiveAttack();
  }
}
