package collidables;

import animation.GameLevel;
import sprites.Ball;
import sprites.Sprite;
import pysics.Velocity;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author Idan Turkenits.
 * ID - 326685815.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle shape;
    private Color color;
    private double speed = 3;

    /**
     * construtor.
     *
     * @param r is the rectengle.
     * @param c is the color of the paddle.
     */
    public Paddle(Rectangle r, Color c) {
        this.shape = r;
        this.color = c;
    }

    /**
     * constructor.
     *
     * @param s is the keyboard sensor.
     */
    public Paddle(KeyboardSensor s) {
        this.keyboard = s;
        this.shape = new Rectangle(new Point(400, 300), 50, 10);
        this.color = Color.black;
    }

    /**
     * setex the keyBoard sensor.
     *
     * @param g is the GUI.
     */
    public void setKeyboard(GUI g) {
        keyboard = g.getKeyboardSensor();
    }

    /**
     * sets x to be the parameter.
     *
     * @param x is the x.
     */
    public void setX(double x) {
        this.shape.upperLeft().setX(x);
    }

    /**
     * sets y to be the parameter.
     *
     * @param y is the parameter.
     */
    public void setY(double y) {
        this.shape.upperLeft().setY(y);
    }

    /**
     * @return x.
     */
    public double getX() {
        return this.getCollisionRectangle().getUpperLeft().getX();
    }

    /**
     * @return y.
     */
    public double getY() {
        return this.getCollisionRectangle().getUpperLeft().getY();
    }

    /**
     * if the paddle isnt on the edge, it moves one step to the left.
     */
    public void moveLeft() {
        if (this.getX() > 25) {
            this.setX(this.getX() - this.getSpeed());
        }
    }

    /**
     * if the paddle isnt on the edge, it moves one step to the right.
     */
    public void moveRight() {
        if (this.getX() < 775 - this.getWidth()) {
            this.setX(this.getX() + this.getSpeed());
        }
    }

    /**
     * @return the speed of the paddle.
     */
    private double getSpeed() {
        return this.speed;
    }

    /**
     * @return the width of the paddle.
     */
    public double getWidth() {
        return this.getCollisionRectangle().getWidth();
    }

    /**
     * @return the height of the paddle.
     */
    public double getHeight() {
        return this.getCollisionRectangle().getHeight();
    }

    /**
     * this is what the paddle does when the timer ticks.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draws the paddle on the draw surface.
     *
     * @param d is the draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.getX(), (int) this.getY(), (int) this.getWidth(), (int) this.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.getX(), (int) this.getY(), (int) this.getWidth(), (int) this.getHeight());
    }

    /**
     * @return the paddle rectengle.
     */
    public Rectangle getCollisionRectangle() {
        return new Rectangle(new Point(this.shape.getUpperLeft().getX(), this.shape.getUpperLeft().getY()),
                this.shape.getWidth(), this.shape.getHeight());
    }

    /**
     * @param b               is the ball.
     * @param collisionPoint  is the collisionPoint with the rectengle.
     * @param currentVelocity is the velocity when the object hits the rectengle.
     * @return the new velocty after the impact.
     */
    public Velocity hit(Ball b, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = currentVelocity;
        Line vertical1 = new Line(getX(), getY(), getX(), getY() + this.getHeight());
        Line vertical2 = new Line(getX() + this.getWidth(), getY(),
                getX() + this.getWidth(), getY() + this.getHeight());
        Line horisontal1 = new Line(getX(), getY(), getX() + this.getWidth(), getY());
        Line horisontal2 = new Line(getX(), getY() + this.getHeight(),
                getX() + this.getWidth(), getY() + this.getHeight());

        if (horisontal1.onSegment(collisionPoint)) {
            double cx = collisionPoint.getX();
            if (cx >= this.getX() && cx < this.getX() + this.getWidth() / 5) {
                newVelocity = Velocity.fromAngleAndSpeed(300, currentVelocity.getSize());
            } else if (cx >= this.getX() + this.getWidth() / 5 && cx <= this.getX() + 2 * this.getWidth() / 5) {
                newVelocity = Velocity.fromAngleAndSpeed(330, currentVelocity.getSize());
            } else if (cx >= this.getX() + 2 * this.getWidth() / 5 && cx <= this.getX() + 3 * this.getWidth() / 5) {
                newVelocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            } else if (cx >= this.getX() + 3 * this.getWidth() / 5 && cx <= this.getX() + 4 * this.getWidth() / 5) {
                newVelocity = Velocity.fromAngleAndSpeed(30, currentVelocity.getSize());
            } else if (cx >= this.getX() + 4 * this.getWidth() / 5 && cx <= this.getX() + 5 * this.getWidth() / 5) {
                newVelocity = Velocity.fromAngleAndSpeed(60, currentVelocity.getSize());
            }
        }
        if (horisontal2.onSegment(collisionPoint)) {
            newVelocity = new Velocity(newVelocity.getDx(), -newVelocity.getDy());
        }

        if ((vertical1.onSegment(collisionPoint) || vertical2.onSegment(collisionPoint))
                && !horisontal1.onSegment(collisionPoint)) {
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        return newVelocity;
    }

    /**
     * adds the paddle to the game.
     *
     * @param g is the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * set the speed of the paddle.
     * @param s is the speed.
     */
    public void setSpeed(int s) {
        this.speed = s;
    }

    /**
     * set the keyboard sensor of the paddle.
     * @param k is the sensor.
     */
    public void setKeyboard(KeyboardSensor k) {
        this.keyboard = k;
    }
}