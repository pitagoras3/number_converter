public class Converter {

    private static final String NO_SUCH_METHOD_MESSAGE = "No such method.";
    private static final String WRONG_NUMBER_FORMAT_MESSAGE = "Wrong number format.";

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
        StringBuilder builder = new StringBuilder();
        builder.append(numberToConvert);
        builder.append(" -> ");
        builder.append("XXV");
        builder.append(" [ROMAN]");
        return builder.toString();
    }

    private String convertToHex(int numberToConvert) {
        StringBuilder builder = new StringBuilder();
        builder.append(numberToConvert);
        builder.append(" -> ");
        builder.append("x0239840234");
        builder.append(" [HEX]");
        return builder.toString();
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
