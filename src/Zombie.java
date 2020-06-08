/**
 * Defines a Zombie class that is a subclass of Person.
 * @author Jacob Parla
 * @version 1.0
 * @since 06/07/2020
 */
public class Zombie extends Person {

    public Zombie() {
    }
    public Zombie(World world, float xPos, float yPos, float size) {
        setWorld(world);
        setxPos(xPos);
        setyPos(yPos);
        setSize(size);
        setRadius(size/2);

    }


    @Override
    public void move() {
        int decision = (int) this.getWorld().random(100);
        if (decision < 20) {
            setxPos(getxPos()+1);
        }
        else if (decision < 40) {
            setxPos(getxPos()-1);
        }
        else if (decision < 80) {
            setyPos(getyPos()+1);
        }
        else {
            setyPos(getyPos()-1);
        }
    }
}
