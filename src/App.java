import processing.core.*;

public class App extends PApplet {
    public Block blockOne;
    public double scene;
    public Block blockTwo;
    public Block blockThree; 
    public Block blockFour; 

    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void setup() {
        background(200, 200, 200);
        
        blockOne = new Block(400,60, this,252,255,186);
        blockTwo= new Block(400, 285, this,186,255,244);
        blockThree= new Block(175, 60, this,255,186,217);
        blockFour= new Block(175, 285, this,224,225,186);
    }



    public void settings() {
        size(800, 600);
    }

    public void draw() {
        if (scene == 0) {
            // text shown on instruction page
            textSize(55);
            fill(0, 170, 0);
            text("Simon Says!", 250, 190);
            fill(250, 248, 247);
            text("Keep track of the patten of colors,", 15, 310);

            text(" and click them in the right order!", 15, 450);
        }
        if (scene == 1) {
            textSize(55);
            background(200, 200, 200);

            blockOne.display();
            blockTwo.display();
            blockThree.display();
            blockFour.display();
            // fill(252, 255, 186);
            // rect(400, 60, 225, 225);

            // fill(186, 255, 244);
            // rect(400, 285, 225, 225);

            // fill(255, 186, 217);
            // rect(175, 60, 225, 225);

            // fill(207, 255, 186);
            // rect(175, 285, 225, 225);
        }

    }

    public void keyPressed() {
        if (key == ' ' && scene == 0) {
            scene = 1;
        }

    }
}
