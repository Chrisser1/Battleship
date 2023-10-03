package main.battleship.client.Controller.draw;

import main.battleship.client.Controller.Color;
import processing.core.PGraphics;

public class TextBox implements Art{
  String text; // Text in textBox
  int x,y; // Coordinates
  Color color; // Color
  boolean hasBorder;
  int borderSize; // For border size manipulation
  int textSize; // To set the text size
  float strokeWidth; // Border width
  
  public TextBox(String text,int x, int y, Color color, boolean hasBorder, int borderSize, int textSize, float strokeWidth){
    setPosition(x,y);
    this.color = color;
    this.hasBorder = hasBorder;
    this.borderSize = borderSize;
    this.textSize = textSize;
    this.strokeWidth = strokeWidth;
    this.text = text;
  }

  private void addBorder(PGraphics g, int borderSize){
    if (hasBorder) {
      g.noFill(); // This makes the rectangle transparent. Only the border will be seen.
      g.stroke(color.r, color.g, color.b); // This sets the border color.
      g.strokeWeight(strokeWidth); // Setting border width
      g.rect(x - g.textWidth(text)/2 - borderSize, y - g.textAscent()/2 - borderSize, g.textWidth(text) + 2*borderSize, g.textAscent() + g.textDescent() + 2*borderSize);
    }
  }

  public String getText(){
    return text;
  }

  public void increaseBorderSize(int increaseAmount){
    this.borderSize += increaseAmount;
  }

  public void setStrokeWidth(float newStrokeWidth){
    this.strokeWidth = newStrokeWidth;
  }

  @Override
  public void draw(PGraphics g) {
    g.fill(color.r, color.g, color.b); // Text color
    g.textSize(textSize); // Text size
    if(hasBorder) addBorder(g, borderSize);
    g.text(text, x - g.textWidth(text)/2, y + g.textAscent()/2); // Centering the text
    g.strokeWeight(1);
  }

  @Override
  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
