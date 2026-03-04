public class Main {
    public static void main(String[] args) {
    Point p = new Point(5.5, 10.0);
        System.out.println("Prywatne pole x pobrane getterem: " + p.getX());
        Point pZio = new Point();
        System.out.println("Punkt domyślny: " +pZio.toString());
        Point Poryginal1 = new Point(0,0);
        Point Poryginal2 = new Point(10, 10);
        Segment s = new Segment (Poryginal1, Poryginal2);
        System.out.println("Oryginalny odcinek: " + s.toString());
        Poryginal1.setX(999);
        System.out.println("Zepsuty punkt: " + Poryginal1.toString());
        System.out.println("Odcinek pozostaje niewrazliwy: " +s.toString());
        Point[] punkty = {new Point(0,0), new Point(10, 0), new Point(0,10)};
        Polygon poly = new Polygon(punkty);
        System.out.println(poly.toString());
        System.out.println(poly.toSvg());
        Polygon polykopia = new Polygon(poly);
        System.out.println("Kopia wielokata: " +polykopia.toString());
        SvgScene scena = new SvgScene();
        scena.addPolygon(poly);
        System.out.println("Dodano do sceny!");
    }
}