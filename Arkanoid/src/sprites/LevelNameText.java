package sprites;

import biuoop.DrawSurface;
import game.GameValues;

/**
 * ID = 326685815.
 */
public class LevelNameText implements Sprite {
    private String name;

    /**
     * This is the constructor.
     * @param name is the name of the level.
     */
    public LevelNameText(String name) {
        this.name = name;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(GameValues.WIDTH - 300, 20, "Level Name: " + this.name, 15);
    }

    @Override
    public void timePassed() {
        return;
    }
}
