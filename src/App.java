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
        // first=;
        PowerUp = new ArrayList<>();
        PowerUp.add(new PowerUp(350, 290, 10, this));
        PowerUp.add(new PowerUp(475, 400, 10, this));
        PowerUp.add(new PowerUp(200, 200, 10, this));
        PowerUp.add(new PowerUp(80, 320, 10, this));
        PowerUp.add(new PowerUp(600, 200, 10, this));
        PowerUp.add(new PowerUp(745, 300, 10, this));

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
        hero = new Hero(20, 50, this);
        gameStart = millis();

    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        if (scene == 8) {
            displayEndScreen();
            return;
        }
        background(241, 245, 176);
        for (Obstacle rectangle : values) {
            rectangle.display();
            hero.touching(rectangle);
            for (PowerUp circle : PowerUp) {

                circle.display();
            }
        }

        hero.display();
        hero.draw();
        hero.Gravity();
        // hero.checkPowerUpCollision();

        fill(7, 8, 8);
        textSize(50);
        timer = millis() - gameStart;
        timer = ((int) timer / 100) / 10.0;
        text("" + timer, width - 150, 70);

        if (hero.xPos() >= 750) {

            readHighScore();

            if (highScore == 0 || highScore > timer) {
                highScore = timer;
                saveHighScore();

            }
            scene = 8;
            

            for (PowerUp powerUp : PowerUp) {
    if (!powerUp.isCollected() && hero.checkPowerUpCollision(powerUp)) {
        powerUp.collect();
        System.out.println("PowerUp collected!");
        // Add score increment or effect here
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
        System.out.println(hero.yPos());
        // ChatGPT
        for (Obstacle rectangle : values) {
            // rectangle.move(); // If you added movement
            if (hero.touching(rectangle)) {
                rectangle.randomizeColor(); // Change color on touch
            }
            rectangle.display();
        }
    }

    public void saveHighScore() {

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

        hero.keyPressed(keyCode);

    }

    public void keyReleased() {

        hero.keyReleased(keyCode);

    }

    void displayEndScreen() {
        background(0);
        fill(255);
        textSize(50);
        text("Score: " + timer, 280, 290);
        text("High score: " + highScore, 240, 390);
    }

    public void mouseMoved() {
        hero.setPosition(mouseX, mouseY);
    }

    
}
