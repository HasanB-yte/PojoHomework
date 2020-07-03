package Species;

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
import java.util.ArrayList;
import java.util.List;

public class SpeciesCall {

    @Test
    public void test3() throws URISyntaxException, IOException {

        // https://swapi.dev/api/species
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("swapi.dev").setPath("api/species");

        HttpGet get = new HttpGet(uriBuilder.build());

        get.setHeader("Accept", "application/json");

        HttpResponse response = client.execute(get);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        SpeciesPojo speciesPojos = objectMapper.readValue(response.getEntity().getContent(), SpeciesPojo.class);


        List<String> mammals = new ArrayList<>();
        List<String> artificials = new ArrayList<>();
        List<String> sentients = new ArrayList<>();
        List<String> gastropods = new ArrayList<>();
        List<String> reptiles = new ArrayList<>();
        List<String> amphibians = new ArrayList<>();

        for (int i=0; i< speciesPojos.getResults().size(); i++){

            if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("mammal")){
                mammals.add(speciesPojos.getResults().get(i).getName());
            }else if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("artificial")) {
                artificials.add(speciesPojos.getResults().get(i).getName());
            }else if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("sentient")) {
                sentients.add(speciesPojos.getResults().get(i).getName());
            }else if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("gastropod")) {
                gastropods.add(speciesPojos.getResults().get(i).getName());
            }else if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("reptile")) {
                reptiles.add(speciesPojos.getResults().get(i).getName());
            }else if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("amphibian")) {
                amphibians.add(speciesPojos.getResults().get(i).getName());
            }
        }

        System.out.println("Mammals: "+ mammals);
        System.out.println("Artificials: "+ artificials);
        System.out.println("Sentients: "+ sentients);
        System.out.println("Gastropods: "+ gastropods);
        System.out.println("Reptiles: "+ reptiles);
        System.out.println("Amphibians: "+ amphibians);

    }



}
