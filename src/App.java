import java.util.ArrayList;
import java.util.Collections;

import processing.core.*;

public class App extends PApplet {
    public Block blockOne;
    public int scene;
    public Block blockTwo;
    public Block blockThree;
    public Block blockFour;
    ArrayList<Block> blocks;
    ArrayList<Block>randomOrder;
    public int random;
   

    // public int mouseX;
    // public int mouseY;

    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void setup() {
        background(200, 200, 200);
        // blockOne = new Block(175, 60, this, 255, 186, 217);
        // blockTwo = new Block(400, 60, this, 255, 255, 186);
        // blockThree = new Block(175, 285, this, 213, 255, 186);
        // blockFour = new Block(400, 285, this, 186, 255, 244);

        blocks = new ArrayList<>();
        {
            blockOne = new Block(175, 60, this, 255, 186, 217);
            blockTwo = new Block(400, 60, this, 255, 255, 186);
            blockThree = new Block(175, 285, this, 213, 255, 186);
            blockFour = new Block(400, 285, this, 186, 255, 244);
            blocks.add(blockOne);
            blocks.add(blockTwo);
            blocks.add(blockThree);
            blocks.add(blockFour);
        }

    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        if (scene == 0) {
            // text shown on instruction page
            textSize(80);
            background(200, 200, 200);
            fill(0, 170, 0);
            text("Simon Says!", 190, 190);
            textSize(55);
            fill(250, 248, 247);
            text("Keep track of the patten of colors,", 15, 310);

            text(" and click them in the right order!", 13, 410);
            textSize(40);
            text("Press the space bar to start", 165, 550);
        }
        if (scene == 1) {
            textSize(55);
            background(252, 252, 240);

            // blockOne.display();
            // blockTwo.display();
            // blockThree.display();
            // blockFour.display();
            for (Block b : blocks) {
                b.display();
            }
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
        if(key == 'r'){
// random(0,4);
System.out.println(random(0,4));
// for (int random = 0; random < 4; random++) {
            
        

//     }
        }
    }
    public void mousePressed() {
        if (blockOne.touching(mouseX, mouseY)) {
            System.out.println("touching one");

        }
        if (blockTwo.touching(mouseX, mouseY)) {
            System.out.println("touching two");

        }
        if (blockThree.touching(mouseX, mouseY)) {
            System.out.println("touching three");
        }
        if (blockFour.touching(mouseX, mouseY)) {
            System.out.println("touching four");
        }
    }

    public void randomOrder() {
randomOrder= new ArrayList<>(blocks);


    }

}
