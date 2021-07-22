package sprites;

import collections.GameEnvironment;
import collidables.CollisionInfo;
import physics.Velocity;
import shapes.Line;
import shapes.Point;
import biuoop.DrawSurface;
import animation.GameLevel;
/**
 * @author Idan Turkenits
 * ID :  326685815
 */

public class Ball implements Sprite {

    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v = null;
    private GameEnvironment gameEnvironment; // turn to private

    /**
     * this is a constructor.
     *
     * @param center is the point of the center of the ball
     * @param r      is the radius of the ball.
     * @param color  is the color of the ball.
     * @param g      is the gameEnviroment.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment g) {
        this.center = center;
        this.r = r;
        this.color = color;
        gameEnvironment = g;
    }

    /**
     * this is a constructor.
     *
     * @param center is the point of the center of the ball
     * @param r      is the radius of the ball.
     * @param color  is the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * setting the gameEnviromemt.
     *
     * @param ge is the game enviromemnt.
     */
    public void setGameEnvironment(GameEnvironment ge) {
        this.gameEnvironment = ge;
    }

    /**
     * this is a constructor.
     *
     * @param x     is the x position of the ball
     * @param y     is the y position of the ball
     * @param r     is the radius of the ball
     * @param color is the color of the ball
     * @param g     is the game enviroment.
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment g) {
        this(new Point(x, y), r, color, g);
    }

    /**
     * @return the balls center.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * returns the x position of the center of the ball.
     *
     * @return the x position of the center of the ball.
     */
    public double getX() {
        return this.center.getX();
    }

    /**
     * returns the y position of the center of the ball.
     *
     * @return the y position of the center of the ball.
     */
    public double getY() {
        return this.center.getY();
    }

    /**
     * the function returns the radius of the ball.
     *
     * @return the radius of the ball (this.r).
     */
    public int getSize() {
        return this.r;
    }

    /**
     * the function returns the color of the ball.
     *
     * @return the color of the ball (this.color).
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * set the velocity of the ball using dx, dy.
     *
     * @param dx is the x term of the velocity.
     * @param dy is the y term of the velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * set the velocity of the ball to v.
     *
     * @param velocity is the input velocity.
     */
    public void setVelocity(Velocity velocity) {
        this.v = velocity;
    }

    /**
     * returns the velocity of the ball.
     *
     * @return this.velocity
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * checking if the ball is off screen, if he is, the function changes thevelocity of the ball to stay on screen.
     * changing the position of the ball based on the velocity.
     *
     * @param width   the width of the screen.
     * @param height  the height of the screen.
     * @param windowX the x position of the top left of the screen.
     * @param windowY the y position of the top left of the screen.
     */
    public void moveOneStepCalculated(int width, int height, int windowX, int windowY) {
        Line trajectory = new Line(this.getX(), this.getY(), this.getX() + (1 * this.getVelocity().getDx()),
                this.getY() + (1 * this.getVelocity().getDy()));
        CollisionInfo info = gameEnvironment.getClosestCollision(trajectory);
        if (info != null) {
            Point future = this.getVelocity().applyToPoint(this.center);
            if ((int) new Line(future, trajectory.end()).length()
                    <= (int) new Line(info.collisionPoint(), trajectory.end()).length()) {
                this.v = info.collisionObject().hit(this, info.collisionPoint(), this.getVelocity());
                this.center = this.getVelocity().applyToPoint(this.center);
                return;
            }
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * The default version of the function move on step.
     */
    public void moveOneStep() {
        //this.setVelocity((int)(this.getVelocity().getDx()), (int)this.getVelocity().getDy());
        if (this.getVelocity() == null) {
            return;
        }
        this.moveOneStepCalculated(800, 600, 0, 0);
    }


    /**
     * the function draws the ball on the draw surface.
     *
     * @param surface is the draw surface who's on it the ball is drawn.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.getX(), (int) this.getY(), r);
    }

    /**
     * what to do when timer ticks.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * adds the ball to the game.
     *
     * @param g is the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * @return the game enviroment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * removing this from game.
     * @param g is the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}