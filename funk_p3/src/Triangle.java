import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle extends Shape2D{

    double base;
    double height;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }


    String getName() {
        return "triangle";
    }


    double getArea() {
        double area = round((.5 * (base * height)),3);
        return area;
    }

    private static double round(double value, int places) {

        BigDecimal rounded = new BigDecimal(Double.toString(value));
        rounded = rounded.setScale(places, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }
}
