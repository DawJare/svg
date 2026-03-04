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
}
