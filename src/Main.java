public class Main {
    public static void main(String[] args) {
    Segment seg = new Segment();

    seg.p1 = new Point();
    seg.p1.x = 0;
    seg.p1.y = 0;
    seg.p2 = new Point();
    seg.p2.x = 3;
    seg.p2.y = 4;
        System.out.println("Dlugosc: " +seg.length());
    }
}