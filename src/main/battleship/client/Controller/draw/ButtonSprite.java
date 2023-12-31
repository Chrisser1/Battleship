package main.battleship.client.Controller.draw;

import java.util.function.Function;

import main.battleship.client.App.Button;
import processing.core.PImage;

public abstract class ButtonSprite extends Sprite{
  Button interaction;
  public ButtonSprite(int x, int y, PImage icon, int width, int height) {
    super(x, y, icon, width, height);
    Function<Integer,Void> func = this::OnClick; 
    interaction = new Button(x, y,func);
  }

  private Void OnClick(int ID){onClick(ID);return null;}
  public abstract void onClick(int ID);
}
