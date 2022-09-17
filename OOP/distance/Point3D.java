package OOP.distance;

public class Point3D extends Point2D {
    int z;
    Point3D (int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    public double dist3D(Point3D p) {
        int x1 = this.x, y1 = this.y, z1 = this.z;
        int x2 = p.x, y2 = p.y, z2 = p.z;
        double dist = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
        return dist;
    }
    public void printDistance(double d) {
        System.out.println(Math.ceil(d));
    }
}
