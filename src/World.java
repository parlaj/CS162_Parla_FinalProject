import processing.core.PApplet;
public class World extends PApplet {
    Zombie zombie1;
    Human human1;

    public void settings() {size(500,500);}

    public void setup() {
        zombie1 = new Zombie(this, width/4, height/4,20 );
        human1 = new Human (this, 250, 480, 25);
    }
    public void draw() {
        while (zombie1.getyPos() <= height && human1.getyPos() >= 0) {
            zombie1.display();
            zombie1.move();
            human1.display();
            human1.move();
        }

    }
}
