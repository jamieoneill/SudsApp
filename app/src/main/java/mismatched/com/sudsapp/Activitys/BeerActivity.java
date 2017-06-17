package mismatched.com.sudsapp.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import mismatched.com.sudsapp.R;

/**
 * Created by jamie on 17/06/2017.
 */

public class BeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String Name = getIntent().getStringExtra("Name");
        String Description = getIntent().getStringExtra("Description");
        String Image = getIntent().getStringExtra("Image");

        TextView beerName  = (TextView) findViewById(R.id.beer_name);
        TextView beerDescription  = (TextView) findViewById(R.id.beer_description);
        ImageView beerImage  = (ImageView) findViewById(R.id.beer_image);

        beerName.setText(Name);
        beerDescription.setText(Description);
        Picasso.with(this).load(Image).into(beerImage);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    }
