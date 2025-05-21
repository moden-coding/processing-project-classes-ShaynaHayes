import java.util.ArrayList;
import java.util.Collections;
import processing.core.PApplet;
import java.util.*;
import processing.core.*;

public class App extends PApplet {
    public Block blockOne;
    public int scene;
    public Block blockTwo;
    public Block blockThree;
    public Block blockFour;
    ArrayList<Block> blocks;
    ArrayList<Block> sequence = new ArrayList<>();
    ArrayList<Block> randomOrder;
    public Block blockOneWhite;
    public Block blockTwoWhite;
    public Block blockThreeWhite;
    public Block blockFourWhite;
    public int randomNumber;
    public int startFrame = 100;

    int currentSequenceIndex = 0; // Track the user's progress in the sequence
    boolean isUserTurn = false; // Track whether it's the user's turn to click
    int delayBetweenBlocks = 1000;

    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void setup() {
        background(200, 200, 200);
   

        blocks = new ArrayList<>();
        randomOrder = new ArrayList<>();

        blockOne = new Block(175, 60, this, 255, 186, 217);
        blockTwo = new Block(400, 60, this, 255, 255, 186);
        blockThree = new Block(175, 285, this, 213, 255, 186);
        blockFour = new Block(400, 285, this, 186, 255, 244);
   
        blocks.add(blockOne);
        blocks.add(blockTwo);
        blocks.add(blockThree);
        blocks.add(blockFour);
     
        chooseRandomBlock();
        playSequence();
    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {

        // System.out.println(frameCount);
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
            // if (frameCount > startFrame && frameCount < startFrame + 100) {
            // // rect(100,100,300,300);
            // }
        }
        if (scene == 1) {
            // textSize(55);
            background(252, 252, 240);

            // blockOne.display();
            // blockTwo.display();
            // blockThree.display();
            // blockFour.display();
            for (Block b : blocks) {
                b.display();
            }

            
        }

    }

    public void keyPressed() {
        if (key == ' ' && scene == 0) {
            scene = 1;
        }
        if (key == 's' && scene == 1) {
            // random(0,4);
            chooseRandomBlock();
            Block last = randomOrder.get(0);
            last.blink(700);

        }

        // if(key == 's'){
        // for(Block b: randomOrder){
        // b.changeColor();

        // }
        // }
        // if (value == 1) {
        // blockOne += randomOrder;
        // }
        // if (value == 2) {
        // blockTwo += randomOrder;

        // }
        // if(value == 3){

        // }
        // if(value == 4){

        // }
    }

    public void mousePressed() {
        if (!isUserTurn)
            return; // Do nothing if it's not the user's turn

        // Check if the clicked block matches the current block in the sequence
        if (checkUserInput(mouseX, mouseY)) {
            // If the user clicked the right block, move to the next block in the sequence
            currentSequenceIndex++;
            if (currentSequenceIndex == randomOrder.size()) {
                // If the user has completed the entire sequence, add a new block and play the
                // sequence
                chooseRandomBlock();
                playSequence();
            }
        } else {
            // If the user clicked the wrong block, handle the error (e.g., reset the game)
            System.out.println("Wrong block clicked! Game Over.");
            resetGame();
        }

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
        randomOrder = new ArrayList<>(blocks);

    }

    public boolean checkUserInput(int mouseX, int mouseY) {
        Block currentBlock = randomOrder.get(currentSequenceIndex);
        return currentBlock.touching(mouseX, mouseY); // Check if the mouse is on the correct block
    }

    public void chooseRandomBlock() {
        // int randomNumber = (int) random(0, 4);
        // // Block chosen = blocks.get(randomNumber);
        // // randomOrder.add(chosen);
        // System.out.println(randomNumber);
        // // for (int random = 0; random < 4; random++) {
        // randomOrder.add(blocks.get(randomNumber));
        // int randomIndex = (int) random(0, blocks.size());
            // int randomIndex = (int) random(0, blocks.size());
            int randomIndex = (int) random(0, 3);
            System.out.println(randomIndex);
        Block chosenBlock = blocks.get(randomIndex);
        randomOrder.add(chosenBlock);
        // System.out.println("Random block: " + randomNumber);
    }

    public void randomNumberOrder() {
        // if (scene==1) {
        // fill(255);
        // rect(175, 60, 255, 255);
        // }
    }

    public void playSequence() {
        // After adding a new block, start playing the sequence
        currentSequenceIndex = 0; // Reset user progress
        isUserTurn = false; // Make sure it's not user turn while sequence plays

        // Play back the sequence with delay between each block
        for (int i = 0; i < randomOrder.size(); i++) {
            Block block = randomOrder.get(i);
            int delay = i * delayBetweenBlocks; // Delay between each block in sequence

            // Blink each block for a certain period
            int finalI = i;
            delay(delay); // Wait before starting the next block
            block.blink(600); // Blink block for 500ms

            // Set isUserTurn to true after sequence ends
            if (i == randomOrder.size() - 1) {
                isUserTurn = true; // Let the user start clicking after sequence ends
            }
        }
    }

    public void resetGame() {
        randomOrder.clear(); // Clear the sequence
        chooseRandomBlock(); // Start with a new block
        playSequence();
        scene = 0; // Play the sequence
    }

}
