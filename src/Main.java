public class Main {
    public static void main(String[] args) {
    Point p = new Point(5.5, 10.0);
        System.out.println("Prywatne pole x pobrane getterem: " + p.getX());
        Point pZio = new Point();
        System.out.println("Punkt domyślny: " +pZio.toString());
    }
}