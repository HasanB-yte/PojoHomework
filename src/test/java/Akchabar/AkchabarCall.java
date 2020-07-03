package Akchabar;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AkchabarCall {

    @Test

    public void getRates() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        // http://rates.akchabar.kg/get.json
        uriBuilder.setScheme("http");
        uriBuilder.setHost("rates.akchabar.kg");
        uriBuilder.setPath("get.json");

        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader("Accept", "application/json");

        HttpResponse response = client.execute(get);

        ObjectMapper objectMapper = new ObjectMapper();

        AkchabarPojo deserializedRates = objectMapper.readValue(response.getEntity().getContent(), AkchabarPojo.class);
        System.out.println(deserializedRates.getDate());
        System.out.println(deserializedRates.getUpdated_at());
        System.out.println(deserializedRates.getRates().getUsd());


    }
}
