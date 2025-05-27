import processing.core.PApplet;

public class Obstacle {
    private int rectWidth = 50;
   private int rectHeight = 300;
   private int x;
   private int y;
    private PApplet canvas;
     private int color;
     
  

    public Obstacle(int xPos, int yPos, PApplet c) {
        x = xPos;
        y = yPos;
        canvas = c;
         color = canvas.color(80, 200, 80);
    
    }
    public void display() {
        // canvas.noStroke();
        canvas.fill(color);
        canvas.rect(x, y, rectWidth,rectHeight);
        
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
     public int getWidth(){
        return rectWidth;
    }
    public int getHeight(){
        return rectHeight;
    }
}
