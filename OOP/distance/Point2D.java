package OOP.distance;

public class Point2D {
    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double dist2D(Point2D p) {
        double dist = 0;
        int x1 = this.x, y1 = this.y;
        int x2 = p.x, y2 = p.y;
        dist = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        return dist;
    }

    public void printDistance(double d) {
        System.out.println(Math.ceil(d));
    }
}
