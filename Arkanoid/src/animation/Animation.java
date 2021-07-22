package animation;

import biuoop.DrawSurface;

/**
 * This is the Animation interface
 * ID = 326685815.
 */
public interface Animation {
    /**
     * what to do each frame.
     * @param d is the draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * returns true if the animation needs to stop, returns false otherwise.
     * @return boolean.
     */
    boolean shouldStop();

    /**
     * making the animation stop.
     */
    void stop();
}
