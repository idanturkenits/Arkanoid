package animation;

import biuoop.DrawSurface;

/**
 * ID = 326685815.
 */
public class PauseScreen implements Animation {
    private boolean running;

    /**
     * constructor.
     */
    public PauseScreen() {
        this.running = true;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
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