package collidables;

import animation.GameLevel;
import listeners.HitListener;
import listeners.HitNotifier;
import sprites.Ball;
import sprites.Sprite;
import physics.Velocity;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Idan Turkenits
 * ID = 326685815
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle shape;
    private java.awt.Color color;
    private List<HitListener> hitListeners = new ArrayList<HitListener>();

    /**
     * constractor.
     *
     * @param rect is the rectengle.
     * @param c    is the color.
     */
    public Block(Rectangle rect, java.awt.Color c) {
        this.shape = rect;
        this.color = c;
    }

    /**
     * constructor.
     *
     * @param rect is the rectengle.
     */
    public Block(Rectangle rect) {
        this.shape = rect;
        this.color = Color.black;
    }

    /**
     * @return the x position.
     */
    public double getX() {
        return this.getCollisionRectangle().getUpperLeft().getX();
    }

    /**
     * @return the y position.
     */
    public double getY() {
        return this.getCollisionRectangle().getUpperLeft().getY();
    }

    /**
     * @return the width of the block.
     */
    public double getWidth() {
        return this.getCollisionRectangle().getWidth();
    }

    /**
     * @return the height of the block.
     */
    public double getHeight() {
        return this.getCollisionRectangle().getHeight();
    }


    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = currentVelocity;
        Line vertical1 = new Line(getX(), getY(), getX(), getY() + this.getHeight());
        Line vertical2 = new Line(getX() + this.getWidth(), getY(),
                getX() + this.getWidth(), getY() + this.getHeight());
        Line horisontal1 = new Line(getX(), getY(), getX() + this.getWidth(), getY());
        Line horisontal2 = new Line(getX(), getY() + this.getHeight(),
                getX() + this.getWidth(), getY() + this.getHeight());
        if (vertical1.onSegment(collisionPoint)) {
            newVelocity = new Velocity(-newVelocity.getDx(), newVelocity.getDy());
        }
        if (vertical2.onSegment(collisionPoint)) {
            newVelocity = new Velocity(-newVelocity.getDx(), newVelocity.getDy());
        }
        if (horisontal1.onSegment(collisionPoint)) {
            newVelocity = new Velocity(newVelocity.getDx(), -newVelocity.getDy());
        }
        if (horisontal2.onSegment(collisionPoint)) {
            newVelocity = new Velocity(newVelocity.getDx(), -newVelocity.getDy());
        }
        this.notifyHit(hitter);
        return newVelocity;
    }

    /**
     * draws block on drawSurface.
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
     * ehat to do when timer ticks.
     */
    public void timePassed() {
        return;
    }

    /**
     * adds to game.
     *
     * @param g is the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * removing the block from the game.
     *
     * @param gameLevel is the game.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * notify all listeneer about the hit.
     * @param hitter is the ball who is hitting.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

}
