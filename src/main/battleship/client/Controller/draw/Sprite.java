package main.battleship.client.Controller.draw;

import main.battleship.client.Controller.Draw;
import processing.core.PGraphics;
import processing.core.PImage;

public class Sprite implements Art{
  int x,y,width,height;
  PImage icon;
  public Sprite(int x, int y, PImage icon){
    this.x = x;
    this.y = y;
    this.icon = icon;
  }
  public Sprite(int x, int y, PImage icon, int width, int height){
    this.x = x;
    this.y = y;
    this.icon = icon;
    this.width = width;
    this.height = height;
  }
  public Sprite(int x, int y, String path){
    this.x = x;
    this.y = y;
    this.icon = Draw.getDraw().loadImage(path);
  }
  public int[] move(int x, int y){
    this.x += x;
    this.y += y;
    return new int[] {this.x, this.y};
  }
  @Override
  public void draw(PGraphics g) {
    if (width == 0 && height == 0) {
      g.image(icon, x, y);
    } else {
      g.image(icon, x, y, width, height);
    }
  }
  @Override
  public void setPosition(int x,int y){
    this.x = x;
    this.y = y;
  }
}
