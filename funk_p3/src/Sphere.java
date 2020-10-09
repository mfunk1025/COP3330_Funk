import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sphere extends Shape3D {

    double radius;

    public Sphere(double radius){
        this.radius = radius;
    }

    public String getName() {
        return "sphere";
    }


    double getArea() {
        return round((4 * Math.PI * (radius * radius)), 2);
    }


    double getVolume() {
        return round(((4 * Math.PI * (radius * radius * radius)) / 3), 2);
    }

    private static double round(double value, int places) {

        BigDecimal rounded = new BigDecimal(Double.toString(value));
        rounded = rounded.setScale(places, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }
}
