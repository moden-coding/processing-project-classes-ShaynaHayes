import processing.core.PApplet;

public class PowerUp {
    private int r = 10;
private int d=20;
    private int x;
    private int y;
    private PApplet canvas;
    private int color;

    private boolean collected = false;

    // example size

    public PowerUp(int xPos, int yPos, int radius,PApplet c) {
        x = xPos;
        y = yPos;
        r=radius;
      
        canvas = c;
        color = canvas.color(80, 200, 80);

    }

    public void display() {
        // canvas.noStroke();
        canvas.fill(color);
        canvas.circle(x, y, r);
        if (!collected) {
            canvas.fill(255, 150, 0);
            canvas.noStroke();
            canvas.circle(x, y, r * 2);
        }

     
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return r;
    }

    public boolean isCollected() {
        return collected;
    }

    public void collect() {
        collected = true;
    }
public void RadiusC(){
    r=10;
}
}



// public PowerUp(int x, int y, PApplet c) {
// this.x = x;
// this.y = y;
// this.canvas = c;
// }

// public void display() {
// // if (!collected) {
// canvas.fill(255, 150, 0);
// canvas.noStroke();
// canvas.circle(x, y, radius * 2);
// }
// }

// public int getX() { return x; }
// public int getY() { return y; }
// public int getRadius() { return radius; }
// public boolean isCollected() { return collected; }
// public void collect() { collected = true; }
// }
