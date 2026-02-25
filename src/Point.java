public class Point {

    public double x = 5;

    public double y = 10;

    public Point(double x, double y){
        this.x = x;
        this.y =y;
    }

    public String toString(){
        String napis = "x="+this.x + " y=" +y;
        return napis;
    }
    public String toSvg(){
        String napis = "<circle r=\"45\" cx=\""+x+ "\" cy=\"" +y+ "\" fill=\"red\" />";
        return napis;
    }
    public void translate(double dx, double dy){
    this.x += dx;
    this.y += dy;
    }
    public Point translated(double dx, double dy){
        return new Point(this.x+dx, this.y+dy);
    }

}
