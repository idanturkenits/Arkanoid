package collections;

import collidables.Collidable;
import collidables.CollisionInfo;
import shapes.Line;
import shapes.Point;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Idan Turkenits
 * ID = 326685815
 */
public class GameEnvironment {
    private List<Collidable> list = new ArrayList<Collidable>();

    /**
     * adding a collidable to the list.
     *
     * @param c is the collidable we want to add.
     */
    public void addCollidable(Collidable c) {
        list.add(c);
    }

    /**
     * removes the collidable from the list.
     *
     * @param c is the collidable we want to remove.
     */
    public void removeCollidable(Collidable c) {
        list.remove(c);
    }

    /**
     * @return the collidables list.
     */
    public List<Collidable> getCollidableList() {
        return this.list;
    }

    /**
     * @param trajectory is the trajectory of the ball
     * @return the collidable that the ball is going to hit first, and the collision point.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        double shortestDistance = trajectory.length();
        Point closestPoint = null;
        Collidable closestCollidable = null;
        for (Collidable c : list) {
            Point touch = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (touch != null) {
                double len = new Line(touch, trajectory.start()).length();
                if (len <= shortestDistance) {
                    closestPoint = touch;
                    shortestDistance = len;
                    closestCollidable = c;
                }
            }

        }
        if (closestPoint == null) {
            return null;
        }
        return new CollisionInfo(closestPoint, closestCollidable);
    }

}