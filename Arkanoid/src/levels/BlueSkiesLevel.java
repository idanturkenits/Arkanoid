package levels;

import collidables.Block;
import drawings.CloudDrawing;
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
 * This is the Blue Skies Level
 * ID = 326685815.
 */
public class BlueSkiesLevel implements LevelInformation {

    private List<Block> blocks = new ArrayList<>();
    private Sprite background;

    /**
     * This is the constructor.
     */
    public BlueSkiesLevel() {

        for (int i = 12; i >= 7; i--) {
            for (int j = 0; j < i; j++) {
                Block b = new Block(new Rectangle(new Point(GameValues.WIDTH - 75 - 50 * j, 450 - 25 * i),
                        50, 25), Color.GRAY);
                blocks.add(b);
            }
        }
        background = new BlueSkiesBackground();

    }

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        l.add(new Velocity(2, -1));
        l.add(new Velocity(-2, 2));
        return l;
    }

    @Override
    public int paddleSpeed() {
        return 4;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "Blue Skies";
    }

    @Override
    public Sprite getBackground() {
        return this.background;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 57;
    }

    /**
     * This is the background class.
     */
    private class BlueSkiesBackground implements Sprite {
        private CloudDrawing c = new CloudDrawing(250, 450);
        private CloudDrawing c2 = new CloudDrawing(100, 200);
        private CloudDrawing c3 = new CloudDrawing(100, 20);

        @Override
        public void drawOn(DrawSurface d) {
            d.setColor(new Color(127, 172, 245));
            d.fillRectangle(0, 0, GameValues.WIDTH, GameValues.HEIGHT);
            c3.drawOn(d);
            c.drawOn(d);
            c2.drawOn(d);
            c2.move(1, 0);
            c.move(-1, 0);
            c3.move(-1, 0);


        }

        @Override
        public void timePassed() {
            return;
        }
    }
}
