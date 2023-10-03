package main.battleship.client.Controller;

/**
 * Color
 */
public class Color {
    public final static Color RED = new Color(255, 0, 0);
    public final static Color GREEN = new Color(0, 255, 0);
    public final static Color BLUE = new Color(0, 0, 255);
    public final static Color YELLOW = new Color(255, 255, 0);
    public final static Color ORANGE = new Color(255, 165, 0);
    public final static Color PURPLE = new Color(128, 0, 128);
    public final static Color PINK = new Color(255, 192, 203);
    public final static Color CYAN = new Color(0, 255, 255);
    public final static Color BROWN = new Color(139, 69, 19);
    public final static Color LIME = new Color(50, 205, 50);
    public final static Color MAGENTA = new Color(255, 0, 255);
    public final static Color TEAL = new Color(0, 128, 128);

  public final int r,g,b;
  public Color(int r, int g, int b){
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public Color inverted(){
    return new Color(255-r,255-g,255-b);
  }
}
