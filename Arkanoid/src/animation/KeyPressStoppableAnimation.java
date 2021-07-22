package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * This is the KeyPressStoppableAnimation class.
 * ID = 326685815
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor ks;
    private String key;
    private Animation animation;
    private boolean running = true;
    private boolean isAlreadyPressed = true;

    /**
     * constructor.
     *
     * @param sensor    is the keyboard sensor.
     * @param key       is the key.
     * @param animation is the animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.ks = sensor;
        this.key = key;
        this.animation = animation;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (!this.ks.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
        this.animation.doOneFrame(d);
        if (this.ks.isPressed(this.key) && !this.isAlreadyPressed) {
            this.running = false;
            this.isAlreadyPressed = true;
        }


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
