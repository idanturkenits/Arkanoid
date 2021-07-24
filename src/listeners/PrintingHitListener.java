package listeners;

import collidables.Block;
import sprites.Ball;

/**
 * @author Idan Turkenits
 * ID = 326685815
 * IDK id we need this class
 */
public class PrintingHitListener implements HitListener {
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Collidables.Block was hit.");
    }
}