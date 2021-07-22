package listeners;

import animation.GameLevel;
import collidables.Block;
import sprites.Ball;
import physics.Counter;

/**
 * this is the Listeners.BallRemover class.
 * @author Idan Turkenits
 * ID = 326685815
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter count = new Counter();

    /**
     * constructor.
     * @param g is the game.
     */
    public BallRemover(GameLevel g) {
        this.gameLevel = g;
    }

    /**
     * what to do when there is a hit.
     * @param beingHit is the block.
     * @param hitter is the ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.count.increase(1);
    }

    /**
     * returns the counter.
     * @return the counter.
     */
    public Counter getCounter() {
        return this.count;
    }

}
