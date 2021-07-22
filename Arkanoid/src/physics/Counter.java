package physics;

/**
 * this is the Pysics.Counter class.
 *
 * @author Idan Turkenits
 * ID = 326685815.
 */
public class Counter {
    private int state;

    /**
     * constructor.
     */
    public Counter() {
        this.state = 0;
    }

    /**
     * increasing the counter by the parameter.
     *
     * @param number is the incresent value.
     */
    public void increase(int number) {
        this.state += number;
    }

    /**
     * increasing the counter by the parameter.
     *
     * @param number is the decresement value.
     */
    public void decrease(int number) {
        this.state -= number;
    }

    /**
     * returning the value of the counter.
     *
     * @return this.state.
     */
    public int getValue() {
        return this.state;
    }

}