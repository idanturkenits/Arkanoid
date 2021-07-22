package listeners;

import animation.GameLevel;
import collidables.Block;
import sprites.Ball;
import pysics.Counter;

/**
 * This is the blockRemover Class.
 * @author Idan Turkenits
 * ID = 326685815
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter blocksRemoved;

    /**
     * This is the constructor.
     * @param gameLevel is the game.
     * @param blocksRemoved is the counter.
     */
    public BlockRemover(GameLevel gameLevel, Counter blocksRemoved) {
        this.gameLevel = gameLevel;
        this.blocksRemoved = blocksRemoved;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.blocksRemoved.increase(1);
        beingHit.removeFromGame(this.gameLevel);
    }

    /**
     * returns the counter.
     * @return the counter.
     */
    public Counter getCounter() {
        return this.blocksRemoved;
    }
}