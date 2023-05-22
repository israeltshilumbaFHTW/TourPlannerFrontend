package at.fhtw.app.backendApi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import at.fhtw.app.model.Tour;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import org.json.JSONArray;
import org.json.JSONObject;

public class TourApi {
    private HttpClient client = HttpClientBuilder.create().build();
    private String END_POINT = "http://localhost:8080/tours";

    public List <Tour> getAllTours() {
        HttpGet request = new HttpGet(this.END_POINT);
        List<Tour> tourList = new ArrayList<>();

        //jackspi client, jersey client, springboot client
        try {
            HttpResponse response = client.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());

            JSONArray toursArray = new JSONArray(responseBody);

            for (int i = 0; i < toursArray.length(); i++) {
                JSONObject tourObject = toursArray.getJSONObject(i);
                Tour tour = new Tour(
                        tourObject.getInt("id"),
                        tourObject.getString("name"),
                        tourObject.getString("description"),
                        tourObject.getString("fromLocation"),
                        tourObject.getString("toLocation"),
                        tourObject.getString("transportType"),
                        tourObject.getDouble("distance"),
                        tourObject.getDouble("estimatedTime"),
                        tourObject.getString("date")
                );
                tourList.add(tour);
            }
        } catch (IOException e) {
            //do stuff
        }
        return tourList;
    }

}
