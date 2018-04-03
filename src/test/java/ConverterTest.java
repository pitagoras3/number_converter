import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ConverterTest {

    private static Converter converter;

    @BeforeClass
    public static void createConverter(){
        converter = new Converter();
    }

    @Test
    public void testConvertWithWrongMethod(){
        String wrongConvertMethod = "hexx";
        String numberToConvert = "10";
        String convertResult = converter.convert(wrongConvertMethod, numberToConvert);

        assertEquals(convertResult, Converter.ERROR_NO_SUCH_METHOD);
    }

    @Test
    public void testConvertWithNotNumber(){
        String convertMethod = "hex";
        String notNumber = "ddddd";
        String convertResult = converter.convert(convertMethod, notNumber);

        assertEquals(convertResult, Converter.ERROR_NOT_A_NUMBER);
    }

    @Test
    public void testConvertWithNotPositiveNumber(){
        String convertMethod = "roman";
        String notPositiveNumber = "0";
        String convertResult = converter.convert(convertMethod, notPositiveNumber);

        assertEquals(convertResult, Converter.ERROR_NOT_POSITIVE_NUMBER);
    }

    @Test
    public void testConvertWithNegativeNumber(){
        String convertMethod = "roman";
        String notPositiveNumber = "-10";
        String convertResult = converter.convert(convertMethod, notPositiveNumber);

        assertEquals(convertResult, Converter.ERROR_NOT_POSITIVE_NUMBER);
    }

    @Test
    public void testConvertWithBiggerThanIntNumber(){
        String convertMethod = "hex";
        String biggerThanIntNumber = "12354687900";
        String converterResult = converter.convert(convertMethod, biggerThanIntNumber);

        assertEquals(converterResult, Converter.ERROR_NOT_A_NUMBER);
    }

    @Test
    public void testConvertWithCorrectRomanData(){
        String convertMethod = "roman";
        String numberToConvert = "15";
        String romanNumberToCompare = "XV";
        String convertResult = converter.convert(convertMethod, numberToConvert);

        assertEquals(convertResult, romanNumberToCompare);
    }

    @Test
    public void testConvertWithCorrectHexData(){
        String convertMethod = "hex";
        String numberToConvert = "15";
        String hexNumberToCompare = "f";
        String convertResult = converter.convert(convertMethod, numberToConvert);

        assertEquals(convertResult, hexNumberToCompare);
    }
}
