import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Shape polygon = new Polygon(new Vec2[]{new Vec2(100, 100), new Vec2(200, 100), new Vec2(150, 200)});
        Shape ellipse = new Ellipse(new Vec2(400, 150), 100, 50);

        Shape filledPolygon = new SolidFillShapeDecorator(polygon, "red");
        Shape filledEllipse = new SolidFillShapeDecorator(ellipse, "blue");

        Shape strokedAndFilledEllipse = new StrokeShapeDecorator(filledEllipse, "black", 5.0);

        TransformationDecorator.Builder builder = new TransformationDecorator.Builder();
        Shape fullyDecoratedPolygon = builder
                .translate(new Vec2(50, 50))
                .rotate(45, new Vec2(150, 150))
                .scale(new Vec2(1.5, 1.5))
                .build(filledPolygon);

        SvgScene scene = new SvgScene();
        scene.addShape(fullyDecoratedPolygon);
        scene.addShape(strokedAndFilledEllipse);

        scene.save("result_decorated.svg");
        System.out.println("Zapisano result_decorated.svg z użyciem dekoratorów!");
    }
}