package main.battleship.client.Controller.draw;

import processing.core.PGraphics;

public interface Art {
  public void draw(PGraphics g);
  public void setPosition(int x,int y);
}
