package mismatched.com.sudsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mismatched.com.sudsapp.Models.Beer;
import mismatched.com.sudsapp.Models.BeerResponse;
import mismatched.com.sudsapp.Rest.ApiClient;
import mismatched.com.sudsapp.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private final static String API_KEY = "83230df1b6332c9d277703e64ef0d5f2";
    private final static String YES = "Y";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set client
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        //Call<BeerResponse> call = apiService.getAllBeers(API_KEY);
        //Call<BeerResponse> call = apiService.getOneBeer("oeGSxs",API_KEY);

        //set attributes to make sure we always have a brewery & image.
        //we need a required param to use the api for free so availableId is set
        //make results random and limit to 5
        Map<String, String> attributes = new HashMap<>();
        attributes.put("key", API_KEY);
        attributes.put("withBreweries", YES);
        attributes.put("hasLabels", YES);
        attributes.put("availableId", "1");
        attributes.put("order", "random");
        attributes.put("randomCount", "5");

        //get the beers
        Call<BeerResponse> call = apiService.getRandomBeers(attributes);

        call.enqueue(new Callback<BeerResponse>() {
            @Override
            public void onResponse(Call<BeerResponse>call, Response<BeerResponse> response) {
                //String beerName = response.body().getData().getName();
                //Brewery beerBrewery = (Brewery) response.body().getData().getBrewery();
                //String beerBreweryName = beerBrewery.getName();
                //Beer newBeer = response.body().getData();

                List<Beer> movies = response.body().getData();
                Log.d(TAG, "Size: " + movies.size());

               // Log.d(TAG, "Name: " + beerName);

                //Log.d(TAG, "Brewery: " + beerBrewery);
                Log.d(TAG, "Number of beers received: " + response.isSuccessful());
                Log.d(TAG, "why: " + response.raw());

            }

            @Override
            public void onFailure(Call<BeerResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}