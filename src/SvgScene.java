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
    public String toSvg(){
        String result = "";
        for(int i = 0; i < polygons.length; i++) {
            if(polygons[i] != null){
                result += polygons[i].toSvg() + "\n";
            }
        }
        return result;
    }
}
