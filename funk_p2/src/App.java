
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.lang.Double;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    static double getUserHeight(){
        Scanner input = new Scanner(System.in);
        double height;

        System.out.println("What is your height in inches?");
        height = Double.parseDouble(input.nextLine());

        while (height <= 0){
            System.out.println("Sorry, the number you entered was negative. Please enter your height in inches.");
            height = Double.parseDouble(input.nextLine());
        }

        return height;
    }

    static double getUserWeight(){

        Scanner input = new Scanner(System.in);
        double weight;

        System.out.println("What is your weight in inches?");
        weight = Double.parseDouble(input.nextLine());

        while (weight <= 0) {
            System.out.println("Sorry, the number you entered was negative. Please enter your weight in inches.");
            weight = Double.parseDouble(input.nextLine());
        }

        return weight;

    }

    static boolean moreInput(){
        Scanner input = new Scanner(System.in);
        char answer;
        boolean yes = true;
        boolean no = false;

        System.out.println("Do you have another user to enter? (Y/N)");
        answer = input.next().charAt(0);

        if (answer == 'y' || answer == 'Y'){
            return yes;
        }

        else
            return no;

    }

    static void displayBmiInfo(BodyMassIndex bmi){
        System.out.println("BMI = " + round(bmi.getbmi(bmi),1));
        System.out.println("Category = " + bmi.GetCategory(bmi));

    }

    static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){

        double sum = 0;

        for (int i = 0; i < bmiData.size(); i++){
            BodyMassIndex temp = bmiData.get(i);
            sum += temp.getbmi(temp);
        }

        System.out.println("The average BMI score of the data is " + round((sum/bmiData.size()), 1));

    }

    private static double round(double value, int places) {

        BigDecimal rounded = new BigDecimal(Double.toString(value));
        rounded = rounded.setScale(places, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }

}
