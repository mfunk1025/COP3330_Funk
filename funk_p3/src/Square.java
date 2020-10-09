import java.math.BigDecimal;
import java.math.RoundingMode;

public class Square extends Shape2D{

    double side;

    public Square(double side){
        this.side = side;
    }


    String getName(){
        return "square";
    }

    double getArea(){
        return (side * side);
    }

}
