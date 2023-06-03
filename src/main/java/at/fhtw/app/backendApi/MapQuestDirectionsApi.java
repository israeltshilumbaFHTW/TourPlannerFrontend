package at.fhtw.app.backendApi;

import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.MapQuest.Directions;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class MapQuestDirectionsApi {
    private final FormTour formTour;
    private static final String API_KEY = "nathu9TckDPtj5j4LKlMMv2Zh0nxDlYg";
    private final HttpClient client = HttpClientBuilder.create().build();
    private final Directions directions = new Directions();
    HttpGet request;

    public MapQuestDirectionsApi(FormTour formTour) {
        this.formTour = formTour;
        this.request = new HttpGet(buildRequestUrl(this.formTour));

    }

    public Directions getDirection() {
        // Build the API request URL
        System.out.println("getDirection");

        try {

            HttpResponse response = client.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject directionsJSON = new JSONObject(responseBody);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            this.directions.setDistance(directionsJSON.getJSONObject("route").getDouble("distance"));
            this.directions.setTime(directionsJSON.getJSONObject("route").getInt("formattedTime"));
            this.directions.setMapUrl(directionsJSON
                    .getJSONObject("route")
                    .getJSONArray("legs").getJSONObject(0)
                    .getJSONArray("maneuvers")
                    .getJSONObject(0)
                    .getString("mapUrl"));
            System.out.println("Directions:" + directions.toString());


            System.out.println(directionsJSON.toString());
            return this.directions;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String buildRequestUrl(FormTour formTour) {
        // Construct the API request URL using the provided formTour data and API key
        // Replace placeholders with the actual values

        String baseUrl = "https://www.mapquestapi.com/directions/v2/route";
        String from = formTour.getFromLocation();
        String to = formTour.getToLocation();
        String apiKey = API_KEY;

        return String.format("%s?key=%s&from=%s&to=%s", baseUrl, apiKey, from, to);
    }
}
