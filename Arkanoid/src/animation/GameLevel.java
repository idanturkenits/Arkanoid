package animation;

import collections.SpriteCollection;
import collections.GameEnvironment;
import collidables.Block;
import collidables.Collidable;
import collidables.Paddle;
import game.GameValues;
import levels.LevelInformation;
import listeners.BallRemover;
import listeners.BlockRemover;
import sprites.Ball;
import sprites.LevelNameText;
import sprites.ScoreText;
import pysics.Counter;
import shapes.Point;
import shapes.Rectangle;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import listeners.ScoreTrackingListener;
import listeners.HitListener;
import sprites.Sprite;

/**
 * @author Idan Turkenits
 * ID - 326685815
 */
public class GameLevel implements Animation {

    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private HitListener score;
    private HitListener hl = new BlockRemover(this, new Counter());
    private HitListener ballRemover = new BallRemover(this);
    private boolean running = true;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private LevelInformation info;
    private GUI gui;

    /**
     * Game constructor.
     * @param info is the GUI.
     * @param k is the keyboard sensor.
     * @param ar is the animation runner.
     * @param score is the score.
     */
    public GameLevel(LevelInformation info, KeyboardSensor k, AnimationRunner ar, HitListener score) {
        this.keyboard = k;
        this.runner = ar;
        this.info = info;
        this.score = score;

    }

    /**
     * @return the game envaiorment.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * @return sprite collection.
     */
    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * add the collidable to the list.
     *
     * @param c is the collidable.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * add the sprite to the list.
     *
     * @param s is the sprite.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * remove the collidable to the envioement.
     *
     * @param c is the collidable.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * remove the sprite to the envioement.
     *
     * @param s is the sprite.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Objects.
     * Sprites.Ball (and Collidables.Paddle) and add them to the game.
     */
    public void initialize() {

        // adding the background
        sprites.addSprite(info.getBackground());

        // making the border blocks
        Block b1 = new Block(new Rectangle(new Point(775, 0), 25, 600), Color.GRAY);
        Block b2 = new Block(new Rectangle(new Point(0, 0), 25, 600), Color.GRAY);
        Block b3 = new Block(new Rectangle(new Point(0, 0), 800, 25), Color.GRAY);
        Block b4 = new Block(new Rectangle(new Point(0, 625), 800, 25), Color.RED);
        b4.addHitListener(ballRemover);
        environment.addCollidable(b4);

        sprites.addSprite(b1);
        sprites.addSprite(b2);
        sprites.addSprite(b3);
        environment.addCollidable(b1);
        environment.addCollidable(b2);
        environment.addCollidable(b3);

        // adding the score text
        ScoreText s = new ScoreText(this.score);
        LevelNameText ln = new LevelNameText(this.info.levelName());
        sprites.addSprite(ln);
        sprites.addSprite(s);

        // adding the blocks
        for (Block b : info.blocks()) {
            sprites.addSprite(b);
            environment.addCollidable(b);
            b.addHitListener(hl);
            b.addHitListener(score);
        }
        // adding the balls
        for (int i = 0; i < info.numberOfBalls(); i++) {
            Ball b = new Ball(new Point(400, 590), 5, new Color(251, 114, 0), this.environment);
            b.setVelocity(info.initialBallVelocities().get(i));
            sprites.addSprite(b);
        }
        // adding the paddle
        Paddle p = new Paddle(new Rectangle(new Point(GameValues.WIDTH / 2 - info.paddleWidth() / 2, 590),
                info.paddleWidth(), 10), new Color(130, 237, 170));
        p.setSpeed(info.paddleSpeed());
        p.setKeyboard(this.keyboard);
        sprites.addSprite(p);
        environment.addCollidable(p);

    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.notifyAllTimePassed();
        this.sprites.drawAllOn(d);

        if (((BlockRemover) hl).getCounter().getValue() == info.numberOfBlocksToRemove()) {
            ((ScoreTrackingListener) score).getCounter().increase(100);
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen()));
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running || noMoreBalls();
    }

    /**
     * return true if there are no balls left, false otherwise.
     * @return boolean
     */
    public boolean noMoreBalls() {
        return (((BallRemover) ballRemover).getCounter().getValue() == info.numberOfBalls());
    }

    @Override
    public void stop() {
        this.running = false;
    }
}
