import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Shape2D{

  double radius;

  public Circle(double radius){
      this.radius = radius;
  }

  String getName(){
      return "circle";
  }


  double getArea(){
      return round((Math.PI * (radius * radius)),2);
  }

    private static double round(double value, int places) {

        BigDecimal rounded = new BigDecimal(Double.toString(value));
        rounded = rounded.setScale(places, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }

}
