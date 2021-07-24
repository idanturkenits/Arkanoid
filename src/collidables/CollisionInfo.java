package collidables;

import shapes.Point;

/**
 * @author Idan Turkenits
 * ID = 326685815
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor.
     * @param p is the collision point.
     * @param c is the collision object.
     */
    public CollisionInfo(Point p, Collidable c) {
        this.collisionPoint = p;
        this.collisionObject = c;
    }

    /**
     * @return the collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return the collision object.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}