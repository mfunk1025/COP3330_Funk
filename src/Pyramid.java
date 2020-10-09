import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pyramid extends Shape3D{

    double length, width, height;

    public Pyramid(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return "pyramid";
    }

    double getArea() {
        return round(getSurfaceArea(length, width, height),2);
    }

    double getVolume() {
        return round((length * width) * (height / 3),2);
    }

    public double getSurfaceArea(double length, double width, double height){
        double area = ((length * width) +
                (length * Math.sqrt(((width * width)/4) + (height * height))) +
                (width *  Math.sqrt(((length * length)/4) + (height * height))));
        return area;
    }

    private static double round(double value, int places) {

        BigDecimal rounded = new BigDecimal(Double.toString(value));
        rounded = rounded.setScale(places, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }

}
