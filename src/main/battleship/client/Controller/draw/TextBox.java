package main.battleship.client.Controller.draw;

import processing.core.PGraphics;

public class TextBox implements Art{
    int x,y;
    int r,g,b;
    boolean hasBorder;
    public TextBox(int x, int y, int r, int g, int b, boolean hasBorder){
      setPosition(x,y);

    }

    private void addBorder(int x, int y, int r, int g, int b){

    }

    public void increaseBorderSize(){

    }

    @Override
    public void draw(PGraphics g) {
      g.text("hello",x,y);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
