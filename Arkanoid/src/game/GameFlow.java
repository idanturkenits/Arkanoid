package game;

import animation.AnimationRunner;
import animation.GameLevel;
import animation.GameOverScreen;
import animation.KeyPressStoppableAnimation;
import levels.LevelInformation;
import listeners.ScoreTrackingListener;
import pysics.Counter;
import biuoop.KeyboardSensor;
import animation.WinScreen;
import java.util.List;

/**
 * this is the gameFlow class.
 */
public class GameFlow {
    private KeyboardSensor ks;
    private AnimationRunner runner;
    private ScoreTrackingListener score;

    /**
     * This is the constructor.
     * @param ar is the animation runner.
     * @param ks is the keyBoard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ks = ks;
        this.runner = ar;
        score = new ScoreTrackingListener(new Counter());
    }

    /**
     * running the levels.
     * @param levels is the list of the levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo,
                    this.ks,
                    this.runner,
                    this.score);

            level.initialize();

            while (!level.shouldStop()) {
                level.run();
            }


            if (level.noMoreBalls()) {
                this.runner.run(new KeyPressStoppableAnimation(this.ks, "m", new GameOverScreen(this.score)));
                System.exit(1);
            }

        }
        this.runner.run(new KeyPressStoppableAnimation(this.ks, "m", new WinScreen(this.score)));
        System.exit(1);

    }
}