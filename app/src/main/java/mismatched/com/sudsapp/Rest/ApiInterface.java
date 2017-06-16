package mismatched.com.sudsapp.Rest;

/**
 * Created by jamie on 15/06/2017.
 */

import java.util.Map;

import mismatched.com.sudsapp.Models.BeerResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    @GET("beers")
    Call<BeerResponse> getAllBeers(@Query("key") String apiKey);

    @GET("beer/{id}")
    Call<BeerResponse> getOneBeer(@Path("id") String id, @Query("key") String apiKey);

    @GET("beers")
    Call<BeerResponse> getRandomBeers(@QueryMap(encoded=true) Map<String, String> options);
}
