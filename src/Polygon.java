public class Polygon {
    private Point[] points;

    public Polygon(Point[] points){
        this.points = points;
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
