public class SvgScene {
    private Polygon[] polygons;
    private int index;
    public SvgScene(){
        polygons = new Polygon[3];
        index = 0;
    }
    public void addPolygon(Polygon p){
        polygons[index] = p;
        index = (index + 1) % 3;
    }
}
