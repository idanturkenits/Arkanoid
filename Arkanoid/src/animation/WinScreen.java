package animation;

import game.GameValues;
import listeners.HitListener;
import listeners.ScoreTrackingListener;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * this is the WinScreen class.
 */
public class WinScreen implements Animation {

    private HitListener score;
    private boolean running = true;

    /**
     * constructor.
     * @param score is the score the player ended the game with.
     */
    public WinScreen(HitListener score) {
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.YELLOW);
        d.fillRectangle(0, 0, GameValues.WIDTH, GameValues.HEIGHT);
        d.setColor(Color.BLACK);
        d.drawText(GameValues.WIDTH / 2 - 170, GameValues.HEIGHT / 2, "You Won! Your score was "
                + Integer.toString(((ScoreTrackingListener) this.score).getCounter().getValue()), 30);
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
