package at.fhtw.app.backendApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import at.fhtw.app.helperServices.Enums.ApiEndpoints;
import at.fhtw.app.helperServices.Enums.ApiResponse;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.model.TourLogPostModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import static at.fhtw.app.Application.logger;

public class TourApi {
    private final HttpClient client = HttpClientBuilder.create().build();

    public List<Tour> getAllTours() {
        logger.debug("getAllTours");
        HttpGet request = new HttpGet(ApiEndpoints.GET_TOURS.getEndPoint());
        List<Tour> tourList;

        //jackspi client, jersey client, springboot client
        try {
            HttpResponse response = client.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());

            JSONArray toursArray = new JSONArray(responseBody);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            logger.debug(toursArray);
            tourList = objectMapper.readValue(toursArray.toString(), new TypeReference<List<Tour>>() {
            });

            return tourList;
        } catch (IOException e) {
            //do stuff
            return new ArrayList<>();
        }
    }

    public String postTour(Tour tour) {
        HttpPost request = new HttpPost(ApiEndpoints.POST_TOUR.getEndPoint());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String tourJson = objectMapper.writeValueAsString(tour);
            StringEntity requestEntity = new StringEntity(tourJson);

            request.setEntity(requestEntity);
            request.setHeader("Content-type", "application/json");
            logger.debug(Arrays.toString(request.getAllHeaders()));

            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                JSONObject responseJson = new JSONObject(responseBody);
                String message = responseJson.getString("message");
                logger.debug("Response: " + message);
                return ApiResponse.POST_SUCCESS.getResponseMessage();
            } else {
                logger.fatal("TourAPI: status code: " + statusCode);
                return ApiResponse.POST_FAIL.getResponseMessage();
            }
        } catch (IOException e) {
            // Handle the exception
            return null;
        }
    }

    public String deleteTour(int tourId) {
        HttpDelete request = new HttpDelete(ApiEndpoints.DELETE_TOUR.getEndPoint() + tourId);

        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                return ApiResponse.DELETE_SUCCESS.getResponseMessage();
            } else {
                logger.fatal("TourAPI: status code: " + statusCode);
                return ApiResponse.DELETE_FAIL.getResponseMessage();
            }
        } catch (IOException e) {
            // Handle the exception
            return null;
        }
    }

    public String deleteTourLog(int tourLogId) {
        HttpDelete request = new HttpDelete(ApiEndpoints.DELETE_TOUR_LOG.getEndPoint() + tourLogId);
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                return ApiResponse.DELETE_SUCCESS.getResponseMessage();
            } else {
                logger.fatal("TourAPI: status code: " + statusCode);
                return ApiResponse.DELETE_FAIL.getResponseMessage();
            }
        } catch (IOException e) {
            // Handle the exception
            return null;
        }
    }


    // TODO: getTourLogsWithId() besserer Name?
    public List<TourLog> getAllTourLogs(int tourId) {
        HttpGet request = new HttpGet(ApiEndpoints.GET_TOUR_LOGS.getEndPoint() + tourId);
        List<TourLog> tourLogList = new ArrayList<>();


        try {
            HttpResponse response = client.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());

            JSONArray tourLogArray = new JSONArray(responseBody);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            logger.debug(tourLogArray);
            tourLogList = objectMapper.readValue(tourLogArray.toString(), new TypeReference<List<TourLog>>() {
            });

            return tourLogList;
        } catch (IOException e) {
            logger.fatal("TourApi: Could not load all Tours");
            //do stuff
            return new ArrayList<>();
        }
    }

    public Tour getTourWithIndex(int tourId) {
        HttpGet request = new HttpGet(ApiEndpoints.GET_TOUR.getEndPoint() + tourId);
        Tour tour = new Tour();

        try {
            HttpResponse response = client.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());

            JSONObject tourJSONObject = new JSONObject(responseBody);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            tour = objectMapper.readValue(tourJSONObject.toString(), Tour.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tour;
    }

    public String postTourLog(TourLog tourLog, int tourId) {
        HttpPost request = new HttpPost(ApiEndpoints.POST_TOUR_LOGS.getEndPoint() + tourId);
        try {
            TourLogPostModel tourLogPostModel = new TourLogPostModel(tourLog.getDate(), tourLog.getComment(), tourLog.getDifficulty(), tourLog.getTotalTime(), tourLog.getRating());
            ObjectMapper objectMapper = new ObjectMapper();
            String tourLogJson = objectMapper.writeValueAsString(tourLogPostModel);
            StringEntity requestEntity = new StringEntity(tourLogJson);

            request.setEntity(requestEntity);
            request.setHeader("Content-type", "application/json");
            logger.debug(Arrays.toString(request.getAllHeaders()));

            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            logger.debug("POST Tour Log Status Code: " + statusCode);

            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                //JSONObject responseJson = new JSONObject(responseBody);
                //String message = responseJson.getString("message");
                logger.debug(ApiResponse.POST_SUCCESS.getResponseMessage());
                return ApiResponse.POST_SUCCESS.getResponseMessage();
            } else {
                logger.error(ApiResponse.POST_FAIL.getResponseMessage());
                return ApiResponse.POST_FAIL.getResponseMessage();
            }
        } catch (IOException e) {
            // Handle the exception
            return null;
        }
    }

    public JSONArray getAllToursInfoJson(String info) {
        HttpGet request;
        if (info == "tours") {
            request = new HttpGet(ApiEndpoints.GET_TOURS.getEndPoint());
        } else if (info == "logs") {
            request = new HttpGet(ApiEndpoints.GET_TOUR_LOGS.getEndPoint());
        } else
            return null;
        JSONArray tourJSONArray = null;

        try {
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == 404)
            {
                System.err.println("No Logs available (404)");
                return null;
            }
            String responseBody = EntityUtils.toString(response.getEntity());

            tourJSONArray = new JSONArray(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tourJSONArray;
    }
}
