package pysics;

import shapes.Point;

/**
 * this is the velocity class.
 * @author Idan Turkenits
 * ID : 326685815
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * this is a constructor.
     * @param dx is the x velocity.
     * @param dy is the y velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * The function calculated the velocity of the ball from the speed and angle.
     * @param angle is the angle of the ball.
     * @param speed is the speed of the ball.
     * @return the velocity of the ball based on the speed and angle.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * @return the size of the velocity.
     */
    public double getSize() {
        return Math.sqrt(Math.pow(this.getDx(), 2) + Math.pow(getDy(), 2));
    }

    /**
     * adding to the old point the velocity and returns a new point.
     * @param p is the point.
     * @return the new point after the addition of the velocity.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * returns the x velocity.
     * @return this.dx, the x velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * returns the y velocity.
     * @return this.dy, the y velocity.
     */
    public double getDy() {
        return this.dy;
    }
}
