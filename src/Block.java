import processing.core.*;

public class Block {
    private int x;
    private int y;
    private int size;
    private PApplet screen;
    private int rColor;
    private int gColor;
    private int bColor;
    private boolean touching;
    // private int mouseX;
    // private int mouseY;

    public Block(int xPos, int yPos, PApplet s, int r, int g, int b) {
        x = xPos;
        y = yPos;
        size = 225;
        screen = s;
        rColor = r;
        gColor = g;
        bColor = b;

    }

    public void display() {
        screen.fill(rColor, gColor, bColor);
        screen.rect(x, y, size, size);
    }

    public boolean touching(int mouseX, int mouseY) {
        if (mouseX > x && mouseX < x + size) {
            if (mouseY > y && mouseY < y + size) {
                return true;
            // return mouseX > x && mouseX < x + size && mouseY > y && mouseY < y + size;
            // else{
            // touching=false;
            // }
            // }
        }
        
    }
    return false;

}
}

// if(mouseX > x && mouseX < x+size){
// if(mouseY > y && mouseY < y+size){
// touching=true;
// }

//