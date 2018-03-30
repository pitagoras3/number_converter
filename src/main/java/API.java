import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class API {

    public static void main(String[] args){
        BasicConfigurator.configure();
        Converter converter = new Converter();

        get("/hello", (req, res) -> "Hello World");

        get("/convert/:method/:number", (request, response) -> {
            String method = request.params(":method");
            String number = request.params(":number");

            return converter.convert(method, number);
        });
    }
}
