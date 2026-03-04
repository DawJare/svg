public class Main {
    public static void main(String[] args) {
    Segment s1 = new Segment();

    s1.p1 = new Point();
    s1.p1.x = 0;
    s1.p1.y = 0;
    s1.p2 = new Point();
    s1.p2.x = 3;
    s1.p2.y = 4;
    Segment s2 = new Segment();
    s2.p1 = new Point();
    s2.p1.x = 0;
    s2.p1.y = 0;
    s2.p2 = new Point();
    s2.p2.x = 10;
    s2.p2.y = 10;
    Segment[] tablica = {s1, s2};
    Segment najdluzszy = Segment.longestSegment(tablica);
        System.out.println("Najdluzszy ma dlugosc: " + najdluzszy.length());
    }
}