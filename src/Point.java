public class Point{
    public double x;
    public double y;
    public String toString(){
        return "Punkt: (" + x + ", " + y + ")";
    }
    String toSvg(){
        return "<circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"5\" fill=\"black\" />";
    }
    public void translate(double dx, double dy){
        this.x += dx;
        this.y += dy;
    }
    public Point translated(double dx, double dy){
        Point nowyPunkt = new Point();
        nowyPunkt.x = this.x +dx;
        nowyPunkt.x = this.x + dx;
        nowyPunkt.y = this.y + dy;
        return nowyPunkt;
    }

}
