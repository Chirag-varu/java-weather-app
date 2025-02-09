package mypackage.java_weather_app.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.*;
import jakarta.ws.rs.QueryParam;
import org.glassfish.jersey.client.JerseyClientBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.ResponseProcessingException;
import jakarta.ws.rs.core.Response;

@Path("/weather")
public class JakartaEE10Resource {

    private static final String API_KEY = "YOUR_OPENWEATHERMAP_API_KEY";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, Object>> getWeatherData(@QueryParam("city") String city) {
        if (city == null || city.isEmpty()) {
            city = "Mumbai"; // Default city
        }

        String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + API_KEY + "&units=metric";

        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(apiUrl);
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

        try {
            Response response = invocationBuilder.get();
            if (response.getStatus() != 200) {
                throw new RuntimeException("HTTP Error: " + response.getStatus());
            }

            Map<String, Object> jsonResponse = response.readEntity(Map.class);
            List<Map<String, Object>> forecastList = (List<Map<String, Object>>) jsonResponse.get("list");
            List<Map<String, Object>> result = new ArrayList<>();

            for (int i = 0; i < 7; i++) {
                Map<String, Object> dayData = new HashMap<>();
                Map<String, Object> mainData = (Map<String, Object>) forecastList.get(i).get("main");
                dayData.put("date", forecastList.get(i).get("dt_txt"));
                dayData.put("temp", mainData.get("temp"));
                result.add(dayData);
            }
            return result;
        } catch (ResponseProcessingException e) {
            throw new RuntimeException("Error processing response: " + e.getMessage());
        }
    }
}
