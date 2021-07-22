package sprites;

import pysics.Counter;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this is the Objects.Sprites.ScoreIndicator class.
 * @author Idan Turkenits
 * ID = 326685815.
 */
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter;
    private int x, y;

    /**
     * this is the constructor.
     * @param c is the counter
     * @param x is the x
     * @param y is the y
     */
    public ScoreIndicator(Counter c, int x, int y) {
        this.scoreCounter = c;
        this.x = x;
        this.y = y;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(x, y, "Score: " + scoreCounter.getValue(), 20);
    }

    @Override
    public void timePassed() {
    }
}
