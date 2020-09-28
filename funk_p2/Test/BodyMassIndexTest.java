import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @Test
    void getbmi() {
        BodyMassIndex bmi1 = new BodyMassIndex(67,115);
        assertEquals(18.0, round(bmi1.getbmi(bmi1),1));

        BodyMassIndex bmi2 = new BodyMassIndex(67,130);
        assertEquals(20.4, round(bmi2.getbmi(bmi2),1));

        BodyMassIndex bmi3 = new BodyMassIndex(67,180);
        assertEquals(28.2, round(bmi3.getbmi(bmi3),1));

        BodyMassIndex bmi4 = new BodyMassIndex(67,200);
        assertEquals(31.3, round(bmi4.getbmi(bmi4),1));

    }

    @Test
    void getCategoryunderweight() {

        BodyMassIndex bmi1 = new BodyMassIndex(67,115);
        assertEquals("Underweight", bmi1.GetCategory(bmi1));

    }

    @Test
    void getCategoryNormalWeight(){

        BodyMassIndex bmi2 = new BodyMassIndex(67,130);
        assertEquals("Normal Weight", bmi2.GetCategory(bmi2));
    }

    @Test
    void getCategoryOverweight(){
        BodyMassIndex bmi3 = new BodyMassIndex(67,180);
        assertEquals("Overweight", bmi3.GetCategory(bmi3));
    }

    @Test
    void getCategoryObesity(){

        BodyMassIndex bmi4 = new BodyMassIndex(67,200);
        assertEquals("Obesity", bmi4.GetCategory(bmi4));
    }


        private static double round(double value, int places) {

        BigDecimal rounded = new BigDecimal(Double.toString(value));
        rounded = rounded.setScale(places, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }
}