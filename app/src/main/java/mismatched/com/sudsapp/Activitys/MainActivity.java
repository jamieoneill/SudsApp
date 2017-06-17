package mismatched.com.sudsapp.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mismatched.com.sudsapp.Adapters.BeerAdapter;
import mismatched.com.sudsapp.Models.Beer;
import mismatched.com.sudsapp.Models.BeerResponse;
import mismatched.com.sudsapp.R;
import mismatched.com.sudsapp.Rest.ApiClient;
import mismatched.com.sudsapp.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jamie on 15/06/2017.
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private final static String API_KEY = "83230df1b6332c9d277703e64ef0d5f2";
    private final static String YES = "Y";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set client
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        //set recycler view
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.beers_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

                //get data and add it to the view
                List<Beer> beers = response.body().getData();
                recyclerView.setAdapter(new BeerAdapter(beers, R.layout.list_item_beer, getApplicationContext()));

                //logs
                Log.d(TAG, "Success: " + response.isSuccessful());
                Log.d(TAG, "Url: " + response.raw());
                Log.d(TAG, "Size: " + beers.size());
            }

            @Override
            public void onFailure(Call<BeerResponse>call, Throwable t) {
                // Print error
                Log.d(TAG, t.toString());
            }
        });
    }
}