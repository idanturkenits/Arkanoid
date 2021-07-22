package collidables;

import sprites.Ball;
import pysics.Velocity;
import shapes.Point;
import shapes.Rectangle;

/**
 * @author Idan Turkenits
 * ID = 326685815
 */
public interface Collidable {
    /**
     * @return the rectengle.
     */
    Rectangle getCollisionRectangle();

    /**
     * @param b is the ball.
     * @param collisionPoint is the collisionPoint with the rectengle.
     * @param currentVelocity is the velocity when the object hits the rectengle.
     * @return the new velocity after the impact.
     */
    Velocity hit(Ball b, Point collisionPoint, Velocity currentVelocity);
}