import processing.core.PApplet;

public class Hero {
    int circleXSpeed = 5;

    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;
    int scene = 0;

    private int x;
    private int y;
    private PApplet canvas;
    private int color;
    private int circleD;

    public void draw() {

        if (right == true) {
            x += circleXSpeed;
        }

        if (left == true) {
            x -= circleXSpeed;

        }
        if (up == true) {
            y -= 5;
        }
        if (down == true) {
            y += 5;
        }
        if (y==630){
System.out.println("end");
        }

    }
    public void setPosition(int mx, int my){
x=mx;
y=my;
    }

    public Hero(int xPos, int yPos, PApplet c) {
        x = xPos;
        y = yPos;
        canvas = c;
        color = canvas.color(186, 255, 255);

    }

    public void display() {
        canvas.noStroke();
        circleD = 50;
        canvas.fill(color);
        canvas.circle(x, y, circleD);

    }

    public void keyPressed(int keyCode) {
        if (keyCode == canvas.RIGHT) {
            right = true;
        }
        if (keyCode == canvas.LEFT) {
            left = true;
        }
        if (keyCode == canvas.UP) {
            up = true;
        }
        if (keyCode == canvas.DOWN) {
            down = true;
        }
        if(keyCode=='h'){
    x=770;
}
    }

    public void keyReleased(int keyCode) {
        if (keyCode == canvas.RIGHT) {
            right = false;
        }
        if (keyCode == canvas.LEFT) {
            left = false;
        }
        if (keyCode == canvas.UP) {
            up = false;
        }
        if (keyCode == canvas.DOWN) {
            down = false;
        }
    }

    public boolean touching(Obstacle obs) {

        // Checks if the green ball is touching any rectangles in the game
        float closestX = canvas.constrain(x, obs.getX(), obs.getX() + obs.getWidth());
        float closestY = canvas.constrain(y, obs.getY(), obs.getY() + obs.getHeight());

        // circle(closestX,closestY, 15);
        // checks if the red ball is touching the green circle
        if (canvas.dist(x, y, closestX, closestY) <= 25) {
            // System.out.println("touching");
            x = 20;
            y = 50;
            // circleX = 0;
            return true;
        }
        return false;
    }

    public void Gravity() {
        y = y + 2;

    }
    public int xPos(){
return x;
    }
     public int yPos(){
return y;
    }
   public boolean checkPowerUpCollision(PowerUp p) {
    float d = canvas.dist(x, y, p.getX(), p.getY());
    float heroRadius = circleD / 2;  
    if (d <= (heroRadius + p.getRadius())) {
        return true;
        
    }
    return false;
}
}
