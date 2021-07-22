package levels;

import collidables.Block;
import sprites.Sprite;
import pysics.Velocity;

import java.util.List;

/**
 * ID = 326685815.
 */
public interface LevelInformation {
    /**
     * returns number of balls.
     * @return int
     */
    int numberOfBalls();

    /**
     * returns The initial velocity of each ball.
     * @return List<Velocity>
     */
    List<Velocity> initialBallVelocities();

    /**
     * returns the paddle speed.
     * @return int
     */
    int paddleSpeed();

    /**
     * returns the paddle width.
     * @return int.
     */
    int paddleWidth();

    /**
     * returns the level name.
     * @return String.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     * @return Sprite.
     */
    Sprite getBackground();

    /**
     * returns the block of the level.
     * @return List<Block>
     */
    List<Block> blocks();

    /**
     *  return the Number of blocks that should be removed.
     *  before the level is considered to be "cleared".
     *  This number should be <= blocks.size();
     * @return int
     */
    int numberOfBlocksToRemove();

}