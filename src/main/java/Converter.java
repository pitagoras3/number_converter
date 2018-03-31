public class Converter {

    private static final String ERROR_NO_SUCH_METHOD = "No such method error.";
    private static final String ERROR_NOT_A_NUMBER = "Not a number error.";
    private static final String ERROR_NOT_POSITIVE_NUMBER = "Not positive number error.";

    private static final String METHOD_ROMAN = "roman";
    private static final String METHOD_HEX = "hex";

    private final int[] ARABIC_VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private final String[] ROMAN_VALUES = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public Converter() {}

    public String convert(String convertMethod, String numberToConvert) {

        boolean isNumberParsable = checkIfCanParseNumber(numberToConvert);
        boolean isNumberPositive = false;

        if(isNumberParsable){
            isNumberPositive = checkIfIsNumberPositive(numberToConvert);
        }

        if(isNumberParsable && isNumberPositive){
            Integer intNumber = Integer.parseInt(numberToConvert);

            switch (convertMethod) {
                case METHOD_ROMAN:
                    return convertToRoman(intNumber);

                case METHOD_HEX:
                    return convertToHex(intNumber);

                default:
                    return ERROR_NO_SUCH_METHOD;
            }
        }
        else if(!isNumberParsable){
            return ERROR_NOT_A_NUMBER;
        }
        else{
            return ERROR_NOT_POSITIVE_NUMBER;
        }
    }

    private String convertToRoman(int numberToConvert) {
        StringBuilder romanNumberBuilder = new StringBuilder();
        for (int i = 0; i < ARABIC_VALUES.length; i++) {
            while (numberToConvert >= ARABIC_VALUES[i]) {
                romanNumberBuilder.append(ROMAN_VALUES[i]);
                numberToConvert -= ARABIC_VALUES[i];
            }
        }
        return romanNumberBuilder.toString();
    }

    private String convertToHex(int numberToConvert) {
        return Integer.toHexString(numberToConvert);
    }

    private boolean checkIfCanParseNumber(String numberToCheck){
        try{
            Integer.valueOf(numberToCheck);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    private boolean checkIfIsNumberPositive(String numberToCheck){
        return Integer.valueOf(numberToCheck) > 0;
    }
}
