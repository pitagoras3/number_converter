import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class API {

    public static void main(String[] args){
        BasicConfigurator.configure();
        get("/hello", (req, res) -> "Hello World");

    }
}
