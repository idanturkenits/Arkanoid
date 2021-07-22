package sprites;

import game.GameValues;
import listeners.HitListener;
import listeners.ScoreTrackingListener;
import biuoop.DrawSurface;

/**
 * This is the score text class.
 */
public class ScoreText implements Sprite {

    private HitListener score;

    /**
     * constructor.
     * @param score is the score.
     */
    public ScoreText(HitListener score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(GameValues.WIDTH / 2 - 50, 20, "Score: "
                + (((ScoreTrackingListener) this.score).getCounter().getValue()), 20);
    }

    @Override
    public void timePassed() {
        return;
    }
}
