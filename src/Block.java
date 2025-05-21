import processing.core.*;
import java.util.Timer;
import java.util.TimerTask;
import processing.core.PApplet;

public class Block {
    private int x;
    private int y;
    private int size;
    private PApplet screen;
    private int rColor;
    private int gColor;
    private int bColor;
    private boolean touching;
     long blinkEndTime = 0;
    


    // private int startFrame = -500;
    // private boolean normalColor = true;

      boolean isBlinking = false;

    private final Timer timer = new Timer(); // Shared timer instance per block


    // private int mouseX;
    // private int mouseY;

    public Block(int xPos, int yPos, PApplet s, int r, int g, int b) {
       this. x = xPos;
       this. y = yPos;
       this. size = 225;
       this. screen = s;
      this.  rColor = r;
       this. gColor = g;
       this. bColor = b;

    }

    public void display() {
        // long time = System.currentTimeMillis();
        if (isBlinking) {
            // System.out.println("other color");
            screen.fill(255);
            // screen.fill(rColor-100,gColor - 100, bColor -100);
            
        } else{
            screen.fill(rColor, gColor, bColor);
            
        }
        screen.rect(x, y, size, size);

    }
    // public void flash(){
    // blockOneWhite = new Block(175, 60, this, 255, 255, 255);

    // }

    public boolean touching(int mouseX, int mouseY) {
        // if (mouseX > x && mouseX < x + size) {
        // if (mouseY > y && mouseY < y + size) {
        // return;
        return mouseX > x && mouseX < x + size &&
                mouseY > y && mouseY < y + size;
    }
     public void blink(int durationMillis) {
        isBlinking = true;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isBlinking = false;
            }
        }, durationMillis);
    }
    

    // public void changeColor() {
    //     // rColor = (int) screen.random(255);
    //     // gColor = (int) screen.random(255);
    //     // bColor = (int) screen.random(255);
    //     startFrame = screen.frameCount;

    // }
    // return mouseX > x && mouseX < x + size && mouseY > y && mouseY < y + size;
    // else{
    // touching=false;
    // }
    // }
}

// return touching;

// if(mouseX > x && mouseX < x+size){
// if(mouseY > y && mouseY < y+size){
// touching=true;
// }

//