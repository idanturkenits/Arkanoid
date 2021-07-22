package levels;

import collidables.Block;
import game.GameValues;
import sprites.Sprite;
import physics.Velocity;
import shapes.Point;
import shapes.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the DiractHit class.
 */
public class DiractHit implements LevelInformation {
    private List<Block> blocks = new ArrayList<>();

    /**
     * This is the constructor.
     */
    public DiractHit() {
        blocks.add(new Block(new Rectangle(new Point(GameValues.WIDTH / 2 - 25, 100), 50, 50), Color.RED));
    }

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        l.add(new Velocity(1, -2));
        return l;
    }

    @Override
    public int paddleSpeed() {
        return 2;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Diract Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Background();
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    /**
     * This is the background of diract hit.
     */
    private class Background implements Sprite {
        @Override
        public void drawOn(DrawSurface d) {
            d.setColor(Color.darkGray);
            d.fillRectangle(0, 0, GameValues.WIDTH, GameValues.HEIGHT);
        }

        @Override
        public void timePassed() {
            return;
        }
    }
}
