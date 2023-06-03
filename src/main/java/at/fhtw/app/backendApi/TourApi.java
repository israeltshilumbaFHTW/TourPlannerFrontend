package at.fhtw.app.backendApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import at.fhtw.app.helperServices.Enums.ApiEndpoints;
import at.fhtw.app.helperServices.Enums.ApiResponse;
import at.fhtw.app.model.Tour;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import org.json.JSONArray;
import org.json.JSONObject;

public class TourApi {
    private final HttpClient client = HttpClientBuilder.create().build();

    public List <Tour> getAllTours() {
        System.out.println("getAllTours");
        HttpGet request = new HttpGet(ApiEndpoints.GET_TOURS.getEndPoint());
        List<Tour> tourList;

        //jackspi client, jersey client, springboot client
        try {
            HttpResponse response = client.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());

            JSONArray toursArray = new JSONArray(responseBody);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            tourList = objectMapper.readValue(toursArray.toString(), new TypeReference<List<Tour>>() {
            });

            return tourList;
        } catch (IOException e) {
            //do stuff
            return new ArrayList<>();
        }
    }

    public String postTour(Tour Tour) {
        HttpPost request = new HttpPost(ApiEndpoints.POST_TOUR.getEndPoint());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String tourJson = objectMapper.writeValueAsString(Tour);
            StringEntity requestEntity = new StringEntity(tourJson);

            request.setEntity(requestEntity);
            request.setHeader("Content-type", "application/json");
            System.out.println(Arrays.toString(request.getAllHeaders()));

            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                JSONObject responseJson = new JSONObject(responseBody);
                String message = responseJson.getString("message");
                System.out.println("Response: " + message);
                return ApiResponse.SUCCESS.getResponseMessage();
            } else {
                return ApiResponse.FAIL.getResponseMessage();
            }
        } catch (IOException e) {
            // Handle the exception
            return null;
        }
    }

}
