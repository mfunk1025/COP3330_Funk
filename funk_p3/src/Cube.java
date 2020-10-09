import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cube extends Shape3D{

    double edge;

    public Cube(double edge){
       this.edge = edge;
    }

    public String getName() {
        return "cube";
    }

    double getArea() {
        return (6 * (edge * edge));
    }

    double getVolume() {
        return round((edge * edge * edge),2);
    }

    private static double round(double value, int places) {

        BigDecimal rounded = new BigDecimal(Double.toString(value));
        rounded = rounded.setScale(places, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }
}
