package animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * This is the animation runner class.
 * ID = 326685815.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper = new Sleeper();

    /**
     * This is the constructor.
     * @param g is the GUI.
     * @param framesPerSecond is the number of FPS.
     */
    public AnimationRunner(GUI g, int framesPerSecond) {
        this.gui = g;
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * running the animation.
     * @param animation is the animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = (int) ((1 / (float) (this.framesPerSecond)) * 1000);
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}