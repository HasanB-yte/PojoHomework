package BreakingBad;

import Utils.PayLoadUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class BreakingBadCall {

    @Test

    public void getRandomCharacter() throws URISyntaxException, IOException {

        // https://breakingbadapi.com/api/characters/1
        HttpClient client = HttpClientBuilder.create().build();
        int randomId = PayLoadUtil.generateRandomId();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("breakingbadapi.com").setPath("api/characters/" + randomId + "");

        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader("Accept", "application/json");
        HttpResponse response = client.execute(get);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        List<BreakingBadPojo> breakingBadPojos = objectMapper.readValue(response.getEntity().getContent(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, BreakingBadPojo.class));

        System.out.println("Id: " + breakingBadPojos.get(0).getChar_id() + "-> " + breakingBadPojos.get(0).getName()+" and the nickname is: "
                +breakingBadPojos.get(0).getNickname());
    }
}
