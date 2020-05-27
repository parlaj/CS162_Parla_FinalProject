public abstract class Person {
    private float xPos, yPos, position, size;

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

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void move(float xDistance, float yDistance) {
        setxPos(getxPos()+xDistance);
        setyPos(getyPos()+yDistance);
    }

}
