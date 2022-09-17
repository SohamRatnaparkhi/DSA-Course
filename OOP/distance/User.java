package OOP.distance;

public class User {
    public static void main(String[] args) {
        int x1 = -1;
        int y1 = -2;
        int z1 = 4;
        int x2 = -7; 
        int y2 = -1; 
        int z2 = -1; 
        Point2D p = new Point2D(x1, y1);
        double d1 = p.dist2D(new Point2D(x2, y2));
        p.printDistance(d1);
        Point3D p2 = new Point3D(x1, y1, z1);
        double d2 = p2.dist3D(new Point3D(x2, y2, z2));
        p2.printDistance(d2);
        
    }
}
