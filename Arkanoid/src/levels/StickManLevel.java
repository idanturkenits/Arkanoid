package levels;

import collidables.Block;
import drawings.SquareDrawing;
import drawings.Stickman;
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
 * This is the StickManLevel class.
 * ID = 326685815
 */
public class StickManLevel implements LevelInformation {

    private List<Block> blocks = new ArrayList<>();
    private Sprite background;

    /**
     * this is the constructor.
     */
    public StickManLevel() {
        java.awt.Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.PINK, Color.GREEN};

        for (int i = 0; i < 15; i++) {
            Block b = new Block(new Rectangle(new Point(25 + 50 * i, 200),
                    50, 25), colors[(i / 3) + 1]);
            blocks.add(b);
        }


        background = new StickMenLevelBackground();
    }

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        l.add(new Velocity(2, 1));
        l.add(new Velocity(-1.7, 1.3));
        l.add(new Velocity(-1, -2));
        return l;
    }

    @Override
    public int paddleSpeed() {
        return 4;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "StickMan Level";
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
        return 15;
    }

    /**
     * This is the StickMenLevelBackground class.
     */
    private class StickMenLevelBackground implements Sprite {
        @Override
        public void drawOn(DrawSurface d) {
            d.setColor(new Color(255, 255, 255));
            d.fillRectangle(0, 0, GameValues.WIDTH, GameValues.HEIGHT);
            Stickman s = new Stickman(100, 20);
            Stickman s2 = new Stickman(400, 20);
            SquareDrawing sd = new SquareDrawing(300, 300);
            s2.drawOn(d);
            s.drawOn(d);
            sd.drawOn(d);
        }

        @Override
        public void timePassed() {
            return;
        }
    }

}
