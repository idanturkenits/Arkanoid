package shapes;

/**
 * @author Idan Turkenits
 * ID :  326685815
 */

public class Point {

    // constructor
    private double x;
    private double y;

    /**
     * sets x to the parameter.
     * @param newX is the x.
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * setes y to the parameter.
     * @param newY is the parameter.
     */
    public void setY(double newY) {
        this.y = newY;
    }


    /**
     * This is the constructor.
     * @param x is the x position of the point.
     * @param y is the y position of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * returns the distance of this point to the other point.
     * @param other is the second point.
     * @return the distance from the second point.
     */
    public double distance(Point other) {
        return  Math.sqrt(Math.pow(this.x - other.getX(), 2) +  Math.pow((this.y - other.getY()), 2));
    }

    /**
     * returns true if this point equals the second point (the x position is the same and the y position is the same).
     * @param other is the other point.
     * @return true or false.
     */
    public boolean equals(Point other) {
        return (this.x <= other.getX() + Math.pow(10, -15) && this.x >= other.getX() - Math.pow(10, -15))
                && (this.y <= other.getY() + Math.pow(10, -15) && this.y >= other.getY() - Math.pow(10, -15));
    }

    /**
     * @return the x position of the point
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y position of the point
     */
    public double getY() {
        return this.y;
    }
}