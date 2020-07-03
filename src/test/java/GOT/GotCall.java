package GOT;

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
import java.util.ArrayList;
import java.util.List;

public class GotCall {

    @Test

    public void getGenderCount() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        // https://api.got.show/api/map/characters
        uriBuilder.setScheme("https");
        uriBuilder.setHost("api.got.show");
        uriBuilder.setPath("api/map/characters");

        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader("Accept", "application/json");

        HttpResponse response = client.execute(get);
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
         GotPojo gotPojo = objectMapper.readValue(response.getEntity().getContent(), GotPojo.class);


        int maleCount=0;
        int femaleCount=0;
        for(int i=0; i<gotPojo.getData().size(); i++){
            if(gotPojo.getData().get(i).isMale()){
                maleCount++;

            }else {
                femaleCount++;
            }

        }

        System.out.println("Total male count: "+maleCount);
        System.out.println("Total female count: "+femaleCount);


//        Count number of characters who appeared in the same books
        List<String> aGameOfThrones = new ArrayList<>();
        List<String> aClashOfKings = new ArrayList<>();
        List<String> aStormOfSwords = new ArrayList<>();
        List<String> aFeastForCrows = new ArrayList<>();
        List<String> aDanceWithDragons = new ArrayList<>();
        List<String> theRoguePrince = new ArrayList<>();
        List<String> theMysteryKnight = new ArrayList<>();
        List<String> thePrincessAndTheQueen = new ArrayList<>();
        List<String> theHedgeKnight = new ArrayList<>();
        List<String> theWindsOfWinter = new ArrayList<>();


        for (int i = 0; i < gotPojo.getData().size(); i++) {
            if (gotPojo.getData().get(i).getBooks().contains("A Game of Thrones")) {
                aGameOfThrones.add(gotPojo.getData().get(i).getName());
            } else if (gotPojo.getData().get(i).getBooks().contains("A Clash of Kings")) {
                aClashOfKings.add(gotPojo.getData().get(i).getName());
            } else if (gotPojo.getData().get(i).getBooks().contains("A Storm of Swords")) {
                aStormOfSwords.add(gotPojo.getData().get(i).getName());
            } else if (gotPojo.getData().get(i).getBooks().contains("A Feast for Crows")) {
                aFeastForCrows.add(gotPojo.getData().get(i).getName());
            } else if (gotPojo.getData().get(i).getBooks().contains("A Dance with Dragons")) {
                aDanceWithDragons.add(gotPojo.getData().get(i).getName());
            } else if (gotPojo.getData().get(i).getBooks().contains("The Rogue Prince")) {
                theRoguePrince.add(gotPojo.getData().get(i).getName());
            } else if (gotPojo.getData().get(i).getBooks().contains("The Mystery Knight")) {
                theMysteryKnight.add(gotPojo.getData().get(i).getName());
            } else if (gotPojo.getData().get(i).getBooks().contains("The Princess and the Queen")) {
                thePrincessAndTheQueen.add(gotPojo.getData().get(i).getName());
            } else if (gotPojo.getData().get(i).getBooks().contains("The Hedge Knight")) {
                theHedgeKnight.add(gotPojo.getData().get(i).getName());
            } else if (gotPojo.getData().get(i).getBooks().contains("The Winds of Winter")) {
                theWindsOfWinter.add(gotPojo.getData().get(i).getName());
            }
        }

        System.out.println("A Game of Thrones number of characters: " + aGameOfThrones.size());
        System.out.println("A Clash of Kings number of characters: " + aClashOfKings.size());
        System.out.println("A Storm of Swords number of characters: " + aStormOfSwords.size());
        System.out.println("A Feast for Crows number of characters: " + aFeastForCrows.size());
        System.out.println("A Dance with Dragons number of characters: " + aDanceWithDragons.size());
        System.out.println("The Rogue Prince number of characters: " + theRoguePrince.size());
        System.out.println("The Mystery Knight number of characters: " + theMysteryKnight.size());
        System.out.println("The Princess and The Queen number of characters: " + thePrincessAndTheQueen.size());
        System.out.println("The Hedge Knight number of characters: " + theHedgeKnight.size());
        System.out.println("The Winds of Winter number of characters: " + theWindsOfWinter.size());

     }
}
