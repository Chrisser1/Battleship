package main.battleship.logic;

public class Cell {
  private boolean attacked;
  private Ship ship;

  public Cell() {
    this.attacked = false;
    this.ship = null;
  }

  public boolean isOccupied() {
    return ship != null;
  }
  
  public void occupy(Ship ship) {
    this.ship = ship;
  }

  public void receiveAttack() {
    this.attacked = true;
    if (ship != null) {
      ship.hit();
      ship.checkState();
    }
  }
  
  public boolean isAttacked() {
    return attacked;
  }
}

