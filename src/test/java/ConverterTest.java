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

        assert convertResult.equals(Converter.ERROR_NO_SUCH_METHOD);
    }

    @Test
    public void testConvertWithNotNumber(){
        String convertMethod = "hex";
        String notNumber = "ddddd";
        String convertResult = converter.convert(convertMethod, notNumber);

        assert convertResult.equals(Converter.ERROR_NOT_A_NUMBER);
    }

    @Test
    public void testConvertWithNotPositiveNumber(){
        String convertMethod = "roman";
        String notPositiveNumber = "0";
        String convertResult = converter.convert(convertMethod, notPositiveNumber);

        assert convertResult.equals(Converter.ERROR_NOT_POSITIVE_NUMBER);
    }

    @Test
    public void testConvertWithNegativeNumber(){
        String convertMethod = "roman";
        String notPositiveNumber = "-10";
        String convertResult = converter.convert(convertMethod, notPositiveNumber);

        assert convertResult.equals(Converter.ERROR_NOT_POSITIVE_NUMBER);
    }

    @Test
    public void testConvertWithCorrectRomanData(){
        String convertMethod = "roman";
        String numberToConvert = "15";
        String convertResult = converter.convert(convertMethod, numberToConvert);

        assert convertResult.equals("XV");
    }

    @Test
    public void testConvertWithCorrectHexData(){
        String convertMethod = "hex";
        String numberToConvert = "15";
        String convertResult = converter.convert(convertMethod, numberToConvert);

        assert convertResult.equals("f");
    }
}
