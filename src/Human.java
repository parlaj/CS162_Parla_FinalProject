public class Human extends Person {
    int color = 255;
    public Human() {
    }
    public Human(World world, float xPos, float yPos, float size) {
        setWorld(world);
        setxPos(xPos);
        setyPos(yPos);
        setSize(size);
    }

    @Override
    public void display() {
        this.getWorld().fill(color);
        this.getWorld().circle(this.getxPos(), this.getyPos(), 25);

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
        else if (decision < 60) {
            setyPos(getyPos()+1);
        }
        else {
            setyPos(getyPos()-1);
        }
    }
}
