public class Converter {

    private static final String NO_SUCH_METHOD_MESSAGE = "No such method.";
    private static final String WRONG_NUMBER_FORMAT_MESSAGE = "Wrong number format.";

    public final int[] ARABIC_VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    public final String[] ROMAN_VALUES = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public Converter() {}

    public String convert(String convertMethod, String numberToConvert) {

        if(checkIfCanParseNumber(numberToConvert)){
            Integer intNumber = Integer.parseInt(numberToConvert);

            switch (convertMethod) {
                case "roman":
                    return convertToRoman(intNumber);

                case "hex":
                    return convertToHex(intNumber);

                default:
                    return NO_SUCH_METHOD_MESSAGE;
            }
        }
        else{
            return WRONG_NUMBER_FORMAT_MESSAGE;
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

    private boolean checkIfCanParseNumber(String numberToParse){
        try{
            Integer.valueOf(numberToParse);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
