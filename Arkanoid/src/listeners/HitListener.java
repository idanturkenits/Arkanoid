package listeners;

import collidables.Block;
import sprites.Ball;

/**
 * This is the Listeners.HitListener class.
 * @author Idan Turkenits
 * ID = 326685815.
 */
public interface HitListener {
    /**
     *  This method is called whenever the beingHit object is hit.
     *  @param hitter is the Objects.Sprites.Ball that's doing the hitting.
     *  @param  beingHit is the block who's the ball is hitting on.
     */
    void hitEvent(Block beingHit, Ball hitter);

}