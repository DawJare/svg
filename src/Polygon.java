public class Polygon {
    private Point[] points;

    public Polygon(Point[] points){
        this.points = new Point[points.length];
        for(int i = 0; i < points.length; i++){
            this.points[i] = new Point(points[i]);
        }
    }
    public Polygon(Polygon other){
        this.points = new Point[other.points.length];
        for(int i = 0; i < other.points.length; i++){
            this.points[i] = new Point(other.points[i]);
        }
    }
    public String toString() {
        String res = "Wielokat: ";
        for (int i = 0; i < points.length; i++) {
            res += points[i].toString() + " ";
        }
        return res;
    }
    public String toSvg(){
        String coords = "";
        for(int i = 0; i < points.length; i++){
            coords += points[i].getX() + "," + points[i].getY() + " ";
        }
        return "<polygon points=\"" + coords + "\" fill=\"none\" stroke=\"black\" />";
    }
    public BoundingBox boundingBox(){
        double minX = points[0].getX();
        double minY = points[0].getY();
        double maxX = points[0].getX();
        double maxY = points[0].getY();
        for(int i = 1; i < points.length; i++){
            if(points[i].getX() < minX) minX = points[i].getX();
            if(points[i].getX() > maxX) maxX = points[i].getX();
            if(points[i].getY() < minY) minY = points[i].getY();
            if(points[i].getX() > maxY) maxY = points[i].getY();
        }
        return new BoundingBox(minX, minY, maxX - minX, maxY - minY);
    }
}
