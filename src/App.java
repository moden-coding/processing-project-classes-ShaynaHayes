import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;
import processing.core.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App extends PApplet {

    ArrayList<Obstacle> values;
    ArrayList<PowerUp> PowerUp;
    // ArrayList<Hero> hero;
    Hero hero;
    double highScore;
    double timer;
    double gameStart;
    int scene;

    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void setup() {
        // dots across the screen that disapers when the ball touches them 
        PowerUp = new ArrayList<>();
        PowerUp.add(new PowerUp(350, 290, 10, this));
        PowerUp.add(new PowerUp(475, 400, 10, this));
        PowerUp.add(new PowerUp(200, 200, 10, this));
        PowerUp.add(new PowerUp(80, 320, 10, this));
        PowerUp.add(new PowerUp(600, 200, 10, this));
        PowerUp.add(new PowerUp(745, 300, 10, this));

// Rectangles throught the screeen that reset the ball if it touches
        values = new ArrayList<>();
        values.add(new Obstacle(60, -50, this));
        values.add(new Obstacle(60, 420, this));
        values.add(new Obstacle(190, -200, this));
        values.add(new Obstacle(190, 340, this));
        values.add(new Obstacle(320, -100, this));
        values.add(new Obstacle(320, 420, this));
        values.add(new Obstacle(450, 0, this));
        values.add(new Obstacle(450, 520, this));
        values.add(new Obstacle(580, -200, this));
        values.add(new Obstacle(580, 300, this));
        values.add(new Obstacle(720, -100, this));
        values.add(new Obstacle(720, 400, this));
        // hero = new ArrayList<>();
        // moving ball
        hero = new Hero(20, 50, this);
        gameStart = millis();

    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        // end scene- total time, and high score 
        if (scene == 8) {
            displayEndScreen();
            return;
        }
        // game screen 
        background(241, 245, 176);
        for (Obstacle rectangle : values) {
            rectangle.display();
            hero.touching(rectangle);
            for (PowerUp circle : PowerUp) {

                circle.display();
            }
        }
// showing the methods from the classes hero into teh main class 
        hero.display();
        hero.draw();
        hero.Gravity();
        // hero.checkPowerUpCollision();
// timer used to see how long the user takes to complete the game
        fill(7, 8, 8);
        textSize(50);
        timer = millis() - gameStart;
        timer = ((int) timer / 100) / 10.0;
        text("" + timer, width - 150, 70);
// if ball reaches the end 
        if (hero.xPos() >= 750) {

            readHighScore();
// if the users time is greater than the current high score, it resets so the users time becomes the new high score 
            if (highScore == 0 || highScore > timer) {
                highScore = timer;
                saveHighScore();

            }
            // end scene 
            scene = 8;

            
        }
// power up throught the game that disapears if the ball touches them 
        for (int i = 0; i < PowerUp.size(); i++) {
            PowerUp powerUp = PowerUp.get(i);
                if (!powerUp.isCollected()) {
                    System.out.println("power up not collected");
// if the user touches the circle 
                    if (hero.checkPowerUpCollision(powerUp)) {
                        powerUp.collect();
                        System.out.println("PowerUp collected!");
                        PowerUp.remove(powerUp);

                    }
                    powerUp.display();
                }
            }
        // else {
        // // scene=2;{

        // // text("Score: " + timer, 280, 290);
        // // text("High score: " + highScore, 240, 390);
        // // }
        // }
        fill(200);
        rect(775, 0, 2, 700);
        // if(scene==8){

        // text("Score: " + timer, 280, 290);
        // text("High score: " + highScore, 240, 390);
        // }
        // if(hero.xPos==200){
        // scene=8;
        // }
        // System.out.println(hero.yPos());
        // ChatGPT
        // obstacle class being shown in the main method 
        for (Obstacle rectangle : values) {
            // rectangle.move(); // If you added movement
            if (hero.touching(rectangle)) {
                rectangle.randomizeColor(); // Change color on touch
            }
            // showing the display method in the obstacle class 
            rectangle.display();
        }
    }

    public void saveHighScore() {
// high score method 
        try (PrintWriter writer = new PrintWriter("highscore.txt")) {
            writer.println(highScore); // Writes the integer to the file
            writer.close(); // Closes the writer and saves the file

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        if (hero.yPos() == 630) {
            System.out.println("end");
        }
    }

    public void readHighScore() {
        try (Scanner scanner = new Scanner(Paths.get("highscore.txt"))) {

            // we read the file until all lines have been read
            while (scanner.hasNextLine()) {
                // we read one line
                String row = scanner.nextLine();
                // we print the line that we read
                highScore = Double.valueOf(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void keyPressed() {
        // if(key=='h'){
        // hero.xPos=770;
        // }
// moves the ball withteh arrow keys
        hero.keyPressed(keyCode);

    }

    public void keyReleased() {
// checks if the user is not touching keys 
        hero.keyReleased(keyCode);

    }

    void displayEndScreen() {
        // end screen display 
        background(0);
        fill(255);
        textSize(50);
        text("Score: " + timer, 280, 290);
        text("High score: " + highScore, 240, 390);
    }

    public void mouseMoved() {
        // getting the method setPosition from the hero class, the begining x position and the beginig y position 
        hero.setPosition(mouseX, mouseY);
    }

}
