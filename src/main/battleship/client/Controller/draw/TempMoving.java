package main.battleship.client.Controller.draw;

import main.battleship.client.Controller.Draw;
import processing.core.PGraphics;

/**
 * TempMoving
 */
public class TempMoving implements Art{
  int x,y;
  int endx,endy;
  int framesRemaning;
  Art icon;
  Art onRemove;
  /**
   *
   * @param startX
   * @param startY
   * @param finalX
   * @param finalY
   * @param frames
   * @param icon
   * @param onRemove is added to ArtList and nothing else
   */
  public TempMoving(int startX, int startY, int finalX, int finalY, int frames, Art icon, Art onRemove){
    this.x = startX;
    this.y = startY;
    this.endx = finalX;
    this.endy = finalY;
    this.framesRemaning = frames;
    this.icon = icon;
    this.onRemove = onRemove;
  }
  @Override
  public void draw(PGraphics g) {
    icon.draw(g);
    if(framesRemaning == 0){
      Draw.getDraw().removeItem(this);
      Draw.getDraw().addItem(onRemove);
    }
    setPosition(
      x + ((endx - x) / framesRemaning),
      y + ((endy - y) / framesRemaning)
    );
    framesRemaning--;
  }
  @Override
  public void setPosition(int x, int y){
    this.x = x;
    this.y = y;
    icon.setPosition(x, y);
  }
}
