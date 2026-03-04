public class Segment{
    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2){
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }

    public double length(){
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
    public static Segment longestSegment(Segment[] arr){
        Segment max = arr[0];
        for(int i =1; i < arr.length; i++){
            if(arr[i].length() > max.length()){
                max = arr[i];
            }
        }
        return max;
    }
    public String toString(){
        return "Odcinek: " + p1.toString() + " - " + p2.toString();
    }
}