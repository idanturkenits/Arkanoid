package shapes;

import java.util.List;
/**
 * @author Idan Turkenits
 * ID :  326685815
 */

public class Line {
    // fields
    private Point start;
    private Point end;

    /**
     *  this function creates a new line using 2 points.
     * @param start is the start point.
     * @param end is the end point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * this function creates a new line using the x and y coordinates of the 2 points.
     * @param x1 is the x coordinate of the first point.
     * @param y1 is the y coordinate of the first point.
     * @param x2 is the x coordinate of the second point.
     * @param y2 is the y coordinate of the second point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * @return the length of the line.
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * @return the middle point of the line.
     */
    public Point middle() {
        double middleX = (this.start.getX() + this.end.getX()) / 2;
        double middleY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(middleX, middleY);
    }

    /**
     * the function returns the start point of the line.
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * the function returns the end point of the line.
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * it returns a boolean (true / false).
     * it returns true if the given point is on the boundaries of the line.
     * it returns false if the given point isnt on boundaries of the line.
     * @param p is the point.
     * @return a boolean (true or false).
     */
    public boolean onSegment(Point p) {
        boolean cond1 = ((p.getY() + Math.pow(10, -10) >= Math.min(this.start.getY(), this.end.getY())
                || p.getY() - Math.pow(10, -10) >=  Math.min(this.start.getY(), this.end.getY()))
                &&  (p.getY() - Math.pow(10, -10) <=  Math.max(this.start.getY(), this.end.getY())
                ||  p.getY() + Math.pow(10, -10) <=  Math.max(this.start.getY(), this.end.getY())));

        boolean cond2 = ((p.getX() + Math.pow(10, -10) >= Math.min(this.start.getX(), this.end.getX())
                || p.getX() - Math.pow(10, -10) >=  Math.min(this.start.getX(), this.end.getX()))
                &&  (p.getX() - Math.pow(10, -10) <=  Math.max(this.start.getX(), this.end.getX())
                ||  p.getX() + Math.pow(10, -10) <=  Math.max(this.start.getX(), this.end.getX())));

        boolean cond3 = Math.abs((new Line(this.start(), p).length() + new Line(this.end(), p).length())
                - this.length())  <= Math.pow(10, -10);

        return cond1 && cond2 && cond3;
    }

    /**
     * The function returns the oriantation of the 3 points.
     * @param p1 is the first point.
     * @param p2 is the second point.
     * @param p3 is the third point.
     * @return the oriantaion (-1/0/1).
     */
    private int orientation(Point p1, Point p2, Point p3) {
        double val = ((p2.getY() - p1.getY()) * (p3.getX() - p2.getX()))
                    - ((p2.getX() - p1.getX()) * (p3.getY() - p2.getY()));
        if (val == 0) {
            return 0;
        } else if (val > 0) {
            return 1;
        }
        return -1;
    }

    /**
     * The function returns true if the lines are intersectioning.
     * The function returns false if the lines are not intesecting.
     * @param other is the secind Shapes.Line.
     * @return boolean(true or false).
     */
    public boolean isIntersecting(Line other) {
       Point p1 = this.start();
       Point q1 = this.end();

       Point p2 = other.start();
       Point q2 = other.end();

       int o1 = orientation(p1, q1, p2);
       int o2 = orientation(p1, q1, q2);
       int o3 = orientation(p2, q2, p1);
       int o4 = orientation(p2, q2, q1);

       if (o1 != o2 && o3 != o4) {
            return true;
        }
       if (o1 == 0 && this.onSegment(p2)) {
           return true;
       }
       if (o2 == 0 && this.onSegment(q2)) {
           return true;
       }
       if (o3 == 0 && other.onSegment(p1)) {
           return true;
       }
        if (o4 == 0 && other.onSegment(q1)) {
            return true;
        }
        return false;
    }

    /**
     * The function gets an other line and returns the point of intersection with the other line.
     * @param other is the other given line.
     * @return is the intersection point.
     */
    public Point intersectionWith(Line other) {
        // using https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection#Given_two_points_on_each_line
        if (!this.isIntersecting(other) || this.equals(other)) {
            return null;
        }
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();

        double x3 = other.start.getX();
        double y3 = other.start.getY();
        double x4 = other.end.getX();
        double y4 = other.end.getY();


        if (x1 - x2 != 0 && x3 - x4 != 0) {
            double m1 = (y2 - y1) / (x2 - x1);
            double m2 = (y4 - y3) / (x4 - x3);
            if (Math.abs(m1 - m2) <= Math.pow(10, -15)) {
                double lengthOfBothLines = Math.max(new Line(this.start(), other.end()).length(),
                                           Math.max(new Line(this.end(), other.end()).length(),
                                           Math.max(new Line(this.start(), other.start()).length(),
                                           new Line(this.end(), other.start()).length())));
                if (Math.abs(this.length() + other.length() - lengthOfBothLines) > Math.pow(10, -15)) {
                    return null;
                }
                if (this.start().equals(other.end()) || this.start().equals(other.start())) {
                    return this.start();
                }
                if (this.end().equals(other.end()) || this.end().equals(other.start())) {
                    return this.end();
                }

            }
        }
        if (x1 - x2 == 0 && x3 - x4 == 0) {
                double lengthOfBothLines = Math.max(new Line(this.start(), other.end()).length(),
                        Math.max(new Line(this.end(), other.end()).length(),
                                Math.max(new Line(this.start(), other.start()).length(),
                                        new Line(this.end(), other.start()).length())));
                lengthOfBothLines = Math.max(new Line(other.start(), other.end()).length(),
                        Math.max(lengthOfBothLines, new Line(this.start(), this.end()).length()));
                if (Math.abs(this.length() + other.length() - lengthOfBothLines) > Math.pow(10, -15)) {
                    return null;
                }
                if (this.start().equals(other.end()) || this.start().equals(other.start())) {
                    return this.start();
                }
                if (this.end().equals(other.end()) || this.end().equals(other.start())) {
                    return this.end();
                }
        }

        if (y1 - y2 == 0 && y3 - y4 == 0) {
            if (this.start().equals(other.end()) || this.start().equals(other.start())) {
                return this.start();
            }
            if (this.end().equals(other.end()) || this.end().equals(other.start())) {
                return this.end();
            }
        }
        if (x1 == x2 && y1 == y2) {
            if (new Line(x3, y3, x4, y4).onSegment(new Point(x1, y1))) {
                return new Point(x1, y1);
            }
            return null;
        }
        if (x3 == x4 && y3 == y4) {
            if (new Line(x1, y1, x2, y2).onSegment(new Point(x3, y4))) {
                return new Point(x3, y4);
            }
            return null;
        }
        double d = (x1 - x2) * (y3 - y4) - ((y1 - y2) * (x3 - x4));

        double intersectionX = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
        double intersectionY = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;
        return new Point(intersectionX, intersectionY);
    }

    /**
     * the function returns true if this line, and the other line are the same line.
     * the function returns false if this line, and the other line are not the same line.
     * @param other is the other line
     * @return boolean (true or false) based on the condition above.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start()) && this.end.equals(other.end()))
                || (this.start.equals(other.end()) && this.end.equals(other.start()));
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     * @param rect is the rectangle.
     * @return is closest point (or null).
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list;
        Point closest = null;
        double minDis = this.length();
        list = rect.intersectionPoints(this);
        if (list.size() == 0) {
            return null;
        }
        for (Point p : list) {
            if (p.distance(this.start()) <= minDis) {
                minDis = p.distance(this.start());
                closest = p;
            }
        }
        return closest;
    }
}