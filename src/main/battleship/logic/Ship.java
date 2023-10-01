package main.battleship.logic;

public class Ship {
  enum ShipType {
    CARRIER (5),
    BATTLESHIP (4),
    CRUISER (3),
    SUBMARINE (3),
    DESTROYER (2);

    private final int holes;

    ShipType(int holes) {
      this.holes = holes;
    }

    public int getHoles() {
      return holes;
    }
  }

  private final ShipType type;
  private boolean isVertical;
  private int hitCount = 0;
  private boolean sunc = false;

  public Ship(ShipType type) {
    this.type = type;
    this.isVertical = false;
  }

  public void hit() {
    this.hitCount++;
  }

  public void checkState() {
    if (this.hitCount == this.type.holes) {
      this.sunc = true;
    }
  }

  public ShipType getType() {
    return type;
  }

  public boolean isVertical() {
    return isVertical;
  }

  public void changeRotation() {
    this.isVertical = !this.isVertical;
  }
}
