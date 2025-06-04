import processing.core.PApplet;

public class Obstacle {
    // same width and height for all the obstacles
    private int rectWidth = 50;
   private int rectHeight = 300;
   private int x;
   private int y;
    private PApplet canvas;
     private int color;
     
  

    public Obstacle(int xPos, int yPos, PApplet c) {
        // making the obstacle an array list format  
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
        // rectangle x 
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
    public void changeColor(int r, int g, int b) {
    color = canvas.color(r, g, b);
}
// ChatGPT
public void randomizeColor() {
    // rectangle color changes each time the ball touches the rectnagle 
    int r = (int)canvas.random(256);
    int g = (int)canvas.random(256);
    int b = (int)canvas.random(256);
    color = canvas.color(r, g, b);
}

}
