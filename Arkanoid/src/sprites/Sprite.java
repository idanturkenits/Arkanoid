package sprites;

import biuoop.DrawSurface;

/**
 * @author Idan Turkenits
 * ID = 326685815
 */
public interface Sprite {
    /**
     * draws the sprite on the draw surface.
     * @param d is the draw surface.
     */
    void drawOn(DrawSurface d);

    /**
     * tells the sprite what to do when time passes.
     */
    void timePassed();
}