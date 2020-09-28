import java.math.BigDecimal;
import java.math.RoundingMode;

public class BodyMassIndex{

    double h;
    double w;


    public BodyMassIndex(double height, double weight) {

        h = height;
        w = weight;

    }

    public double getbmi(BodyMassIndex bmi){

        return (703 * bmi.w / (bmi.h * bmi.h));

    }

    public String GetCategory(BodyMassIndex bmi){

        double category = round(getbmi(bmi),1);

        if (category < 18.5){
            return "Underweight";
        }

        else if (category >= 18.5 && category <= 24.9){
            return "Normal Weight";
        }

        else if (category >= 25 && category <= 29.9){
            return "Overweight";
        }

        else{

            return "Obesity";
        }

    }

    private static double round(double value, int places) {

        BigDecimal rounded = new BigDecimal(Double.toString(value));
        rounded = rounded.setScale(places, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }

}
