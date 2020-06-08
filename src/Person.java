import processing.core.PApplet;
/**
 * Defines a Person class that is able to display itself and move across the screen.
 * @author Jacob Parla
 * @version 1.0
 * @since 06/07/2020
 */
public abstract class Person extends PApplet {
    int color = (int) random(100,250);
    private float xPos, yPos, size;
    private World world;
    private float radius;

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public boolean contact(Person person) {
        float distance = world.dist(this.xPos, this.yPos, person.xPos, person.yPos);
        if (distance <= this.radius + person.radius) {
            return true;
    }
        else{return false;}


    }

    public void display() {
        this.getWorld().fill(color);
        this.getWorld().circle(this.getxPos(), this.getyPos(), getSize());
    }
    public abstract void move();

}
