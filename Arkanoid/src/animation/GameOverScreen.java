package animation;

import game.GameValues;
import listeners.HitListener;
import listeners.ScoreTrackingListener;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This is the GameOverScreen class.
 * ID = 326685815.
 */
public class GameOverScreen implements Animation {

    private HitListener score;
    private boolean running = true;

    /**
     * this is the constructor.
     * @param score is the score.
     */
    public GameOverScreen(HitListener score) {
        this.score = score;
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, GameValues.WIDTH, GameValues.HEIGHT);
        d.setColor(Color.WHITE);
        d.drawText(GameValues.WIDTH / 2 - 150, GameValues.HEIGHT / 2, "Game Over ): \n Your score is "
                + (((ScoreTrackingListener) this.score).getCounter().getValue()), 30);
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void stop() {
        this.running = false;
    }
}
