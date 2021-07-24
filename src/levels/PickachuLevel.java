package levels;

import collidables.Block;
import drawings.PikachuDrawing;
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
 * ID = 326685815.
 */
public class PickachuLevel implements LevelInformation {
    private List<Block> blocks = new ArrayList<>();
    private Sprite background;

    /**
     * constructor.
     */
    public PickachuLevel() {

        for (int i = 12; i >= 7; i--) {
            for (int j = 0; j < 15; j++) {
                Block b = new Block(new Rectangle(new Point(25 + 50 * j, 400 - 25 * i),
                        50, 25), new Color(204, 255, 0));
                blocks.add(b);
            }
        }
        background = new BackgroundDiractHit();

    }

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        l.add(new Velocity(1, -1.2));
        l.add(new Velocity(1, 2));
        return l;
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "PikaLevel";
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
        return 90;
    }


    /**
     * this is the background for this level.
     */

    private class BackgroundDiractHit implements Sprite {
        @Override
        public void drawOn(DrawSurface d) {
            d.setColor(Color.BLACK);
            d.fillRectangle(0, 0, GameValues.WIDTH, GameValues.HEIGHT);
            PikachuDrawing p = new PikachuDrawing(100, 300);
            PikachuDrawing p2 = new PikachuDrawing(300, 300);
            PikachuDrawing p3 = new PikachuDrawing(500, 300);
            p3.drawOn(d);
            p2.drawOn(d);
            p.drawOn(d);
        }

        @Override
        public void timePassed() {
            return;
        }
    }

}
