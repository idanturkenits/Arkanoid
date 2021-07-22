package animation;

import collections.SpriteCollection;
import game.GameValues;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This is the CountDownAnimation class.
 * ID = 326685815.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private double currentSecond;
    private boolean running = true;

    /**
     * This is the constructor.
     * @param numOfSeconds is the number of seconds the timer takes.
     * @param countFrom is the starting value of the timer.
     * @param gameScreen is the screen we want to stop.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.currentSecond = countFrom;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.getHSBColor(245, 100, 72));
        d.drawText(300, 400, String.valueOf(((int) (Math.ceil(this.currentSecond)))), 30);
        currentSecond -= ((1 / (float) GameValues.FRAMES_PER_SECOND) * (this.countFrom / this.numOfSeconds));
        this.running = (this.currentSecond > 0);
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
