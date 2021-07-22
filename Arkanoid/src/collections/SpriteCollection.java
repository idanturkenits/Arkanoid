package collections;

import sprites.Sprite;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Idan Turkenits
 * ID = 326685815
 */
public class SpriteCollection {
    private List<Sprite> list = new ArrayList<Sprite>();

    /**
     * add the given sprite to the sprite collection.
     *
     * @param s is the given sprite.
     */
    public void addSprite(Sprite s) {
        list.add(s);
    }

    /**
     * removes the collidable from the list.
     *
     * @param c is the collidable we want to remove.
     */
    public void removeSprite(Sprite c) {
        list.remove(c);
    }

    /**
     * calling all sprite's timePassed function.
     */
    public void notifyAllTimePassed() {
        for (Sprite s : list) {
            int x = list.size();
            s.timePassed();
            if (list.size() != x) {
                return;
            }
        }
    }

    /**
     * drawing all sprites on the draw surface.
     *
     * @param d is the draw surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : list) {
            s.drawOn(d);
        }
    }
}