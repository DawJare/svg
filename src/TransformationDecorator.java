import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator{
    private String transform;
    public TransformationDecorator(Shape decoratedShape, String transform){
        super(decoratedShape);
        this.transform = transform;
    }
    public static class Builder{
        private String transform = "";
        public Builder translate(Vec2 translation){
            transform += String.format(Locale.ENGLISH, "translate(%f %f) ", translation.x(), translation.y());
            return this;
        }
    public Builder rotate(float angle, Vec2 center){
            transform += String.format(Locale.ENGLISH, "rotate(%f %f %f) ", angle, center.x(), center.y());
            return this;
        }
    public Builder scale(Vec2 scaleFactor){
            transform += String.format(Locale.ENGLISH, "scale(%f %f) ", scaleFactor.x(), scaleFactor.y());
            return this;
    }
    public TransformationDecorator build(Shape shape){
            return new TransformationDecorator(shape, transform);
        }
    }
}