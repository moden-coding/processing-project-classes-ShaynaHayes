import processing.core.*;

public class Block {
    private int x;
    private int y;
    private int size;
    private PApplet screen;
    private int rColor;
    private int gColor;
    private int bColor;
    


    public Block(int xPos, int yPos, PApplet s, int r, int g, int b){
        x = xPos;
        y = yPos;
        size = 225;
        screen = s;
        rColor = r;
        gColor = g;
        bColor = b;
      
    }

    public void display(){
        screen.fill(rColor, gColor, bColor);
        screen.rect(x, y, size, size);
    }
   

    //  fill(252, 255, 186);
    //         rect(400, 60, 225, 225);
    
}
