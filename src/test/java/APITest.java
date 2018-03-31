import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APITest {

    private static final String GET_REQUEST_METHOD = "GET";
    private static final String BASIC_URL_FORMAT = "http://localhost:4567/convert/%s/%s";

    @Test(expected = IOException.class)
    public void testWrongURLRequest() throws IOException {
        String wrongURL = "http://localhost:4567/converrt/%s/%s";
        String convertMethod = "hex";
        String numberToCheck = "100";
        String convertURL = String.format(wrongURL, convertMethod, numberToCheck);
        callURLRequest(GET_REQUEST_METHOD, convertURL);
    }

    @Test
    public void testWrongMethodRequest() throws IOException {
        String wrongConvertMethod = "hexx";
        String numberToCheck = "10";
        String convertURL = String.format(BASIC_URL_FORMAT, wrongConvertMethod, numberToCheck);
        String result = callURLRequest(GET_REQUEST_METHOD, convertURL);
        assertEquals(result, Converter.ERROR_NO_SUCH_METHOD);
    }

    @Test
    public void testNotNumberRequest() throws IOException {
        String convertMethod = "hex";
        String numberToCheck = "10xyz";
        String convertURL = String.format(BASIC_URL_FORMAT, convertMethod, numberToCheck);
        String result = callURLRequest(GET_REQUEST_METHOD, convertURL);
        assertEquals(result, Converter.ERROR_NOT_A_NUMBER);
    }

    @Test
    public void testNotPositiveNumberRequest() throws IOException {
        String convertMethod = "roman";
        String numberToCheck = "0";
        String convertURL = String.format(BASIC_URL_FORMAT, convertMethod, numberToCheck);
        String result = callURLRequest(GET_REQUEST_METHOD, convertURL);
        assertEquals(result, Converter.ERROR_NOT_POSITIVE_NUMBER);
    }

    @Test
    public void testConvertToRomanRequest() throws IOException {
        String convertMethod = "roman";
        String numberToConvert = "123";
        String romanNumberToCheck = "CXXIII";
        String convertURL = String.format(BASIC_URL_FORMAT, convertMethod, numberToConvert);

        String result = callURLRequest(GET_REQUEST_METHOD, convertURL);
        assertEquals(result, romanNumberToCheck);
    }

    @Test
    public void testConvertToHexRequest() throws IOException {
        String convertMethod = "hex";
        String numberToConvert = "123";
        String hexNumberToCheck = "7b";
        String convertURL = String.format(BASIC_URL_FORMAT, convertMethod, numberToConvert);

        String result = callURLRequest(GET_REQUEST_METHOD, convertURL);
        assertEquals(result, hexNumberToCheck);
    }

    private String callURLRequest(String requestMethod, String URL) throws IOException {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestMethod);

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        return getBufferedReaderContent(reader);
    }

    private String getBufferedReaderContent(BufferedReader bufferedReader) throws IOException {
        String line;
        StringBuilder requestContentBuilder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            requestContentBuilder.append(line);
        }
        bufferedReader.close();

        return requestContentBuilder.toString();
    }
}
