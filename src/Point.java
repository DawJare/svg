public class Point{
    private double x;
    private double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x = x;
    }
    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }
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
