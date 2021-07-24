package shapes;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Idan Turkenits.
 * ID = 326685815.
 */
public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor.
     * @param upperLeft is the top left point of the rectangle.
     * @param width is the width of the rectangle.
     * @param height is the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * @return the top left point of the rectangle.
     */
    public Point upperLeft() {
        return this.upperLeft;
    }

    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     * @param line is the given line.
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> list = new ArrayList<Point>();
        Line vertical1 = new Line(this.upperLeft().getX(), this.upperLeft().getY(),
                this.upperLeft().getX(), this.upperLeft().getY() + this.height);
        Line vertical2 = new Line(this.upperLeft().getX() + this.width, this.upperLeft().getY(),
                this.upperLeft().getX() + this.width, this.upperLeft().getY() + this.height);
        Line horisontal1 = new Line(this.upperLeft().getX(), this.upperLeft().getY(),
                this.upperLeft().getX() + this.width, this.upperLeft().getY());
        Line horisontal2 = new Line(this.upperLeft().getX(), this.upperLeft().getY() + this.height,
                this.upperLeft().getX() + this.width, this.upperLeft().getY() + this.height);

        if (line.intersectionWith(vertical1) != null) {
            list.add(line.intersectionWith(vertical1));
        }
        if (line.intersectionWith(vertical2) != null) {
            list.add(line.intersectionWith(vertical2));
        }
        if (line.intersectionWith(horisontal1) != null) {
            list.add(line.intersectionWith(horisontal1));
        }
        if (line.intersectionWith(horisontal2) != null) {
            list.add(line.intersectionWith(horisontal2));
        }

        return list;
    }

    /**
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectengle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * @param p is the point.
     * @return if the given point is on the border of the rectengle.
     */
    public boolean onBorder(Point p) {
       return (Math.abs(p.getX() -  this.upperLeft.getX()) <= Math.pow(10, -15)
                || Math.abs(p.getX() - (this.upperLeft.getX() + this.width)) <= Math.pow(10, -15)
                || Math.abs(p.getY() - (this.upperLeft.getY()) + this.height) <= Math.pow(10, -15)
                ||  Math.abs(p.getY() - (this.upperLeft.getY())) <= Math.pow(10, -15));
    }
}