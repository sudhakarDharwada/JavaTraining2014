package sud.ex1;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

public class Test {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        Response res = client.target("http://localhost:8080/ex1/rest/hello").request("text/plain").get();
        System.out.println(res.toString());
    }
}
