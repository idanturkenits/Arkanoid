package listeners;

import collidables.Block;
import sprites.Ball;
import physics.Counter;

/**
 * This is the Listeners.ScoreTrackingListener class.
 * ID = 326685815
 * @author Idan Turkenits
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     * @param scoreCounter is the counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }

    /**
     * returning the counter.
     * @return the counter.
     */
    public Counter getCounter() {
        return this.currentScore;
    }
}