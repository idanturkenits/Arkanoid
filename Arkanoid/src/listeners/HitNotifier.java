package listeners;

/**
 * this is the Listeners.HitNotifier class.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl is the hit listener we want to add.
     */
    void addHitListener(HitListener hl);

    /**
     * remove hl as a listener to hit events.
     * @param hl is the hit listener we want to remove.
     */
    void removeHitListener(HitListener hl);
}