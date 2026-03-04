public class Segment{
    public Point p1;
    public Point p2;

    public double length(){
        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;
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
}