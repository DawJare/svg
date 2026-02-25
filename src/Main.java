public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");
        Point point = new Point();
        System.out.println(point.x + " " + point.y);
        point.x = 7;
        System.out.println(point.x + " " + point.y);
        System.out.println(point.toString());
    }
}