public class Segment{
    public Point p1;
    public Point p2;

    public double length(){
        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}