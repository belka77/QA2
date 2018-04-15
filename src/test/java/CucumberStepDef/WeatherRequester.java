package CucumberStepDef;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

public class WeatherRequester {
    private String URL = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    public Response getWeather() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        String responsWeathertoParse = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responsWeathertoParse, Response.class);

    }
}
