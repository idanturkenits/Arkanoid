import animation.AnimationRunner;
import biuoop.GUI;
import game.GameFlow;
import game.GameValues;
import levels.BlueSkiesLevel;
import levels.DiractHit;
import levels.LevelInformation;
import levels.StickManLevel;
import levels.PickachuLevel;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Idan Turkenits
 * ID = 326685815
 */
public class Ass6Game {
    /**
     * This is the main function.
     *
     * @param args are the argumants.
     */
    public static void main(String[] args) {
        GUI g = new GUI(GameValues.TITLE, GameValues.WIDTH, GameValues.HEIGHT);
        List<LevelInformation> l = new LinkedList<>();
        if (args.length == 0) {
            l.add((new DiractHit()));
            l.add((new StickManLevel()));
            l.add(new BlueSkiesLevel());
            l.add(new PickachuLevel());
        }
        for (String s : args) {
            if (s.equals("1")) {
                l.add(new DiractHit());
            }
            if (s.equals("2")) {
                l.add(new StickManLevel());
            }
            if (s.equals("3")) {
                l.add(new BlueSkiesLevel());
            }
            if (s.equals("4")) {
                l.add(new PickachuLevel());
            }
        }
        GameFlow f = new GameFlow(new AnimationRunner(g, GameValues.FRAMES_PER_SECOND), g.getKeyboardSensor());
        f.runLevels(l);
    }
}
