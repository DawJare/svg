import java.util.Locale;
public class SolidFilledPolygon extends Polygon {
    private String color;

    public SolidFilledPolygon(Vec2[] points, String color) {
        super(points);
        this.color = color;
    }

    public String toSvg(String parameters) {
        String newParams = String.format(Locale.ENGLISH, "fill=\"%s\" %s ", color, parameters);
        return super.toSvg(newParams);
    }
}