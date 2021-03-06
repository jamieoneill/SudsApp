package mismatched.com.sudsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mismatched.com.sudsapp.Activitys.BeerActivity;
import mismatched.com.sudsapp.R;
import mismatched.com.sudsapp.Models.Beer;

/**
 * Created by jamie on 17/06/2017.
 */

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.BeerViewHolder> {

    private List<Beer> beers;
    private int rowLayout;
    private Context context;

    static class BeerViewHolder extends RecyclerView.ViewHolder  {
        LinearLayout beersLayout;
        TextView beerName;
        TextView beerBrewery;
        ImageView beerImage;

        BeerViewHolder(View v) {
            super(v);
            beersLayout = (LinearLayout) v.findViewById(R.id.beers_layout);
            beerName = (TextView) v.findViewById(R.id.beer_name);
            beerBrewery = (TextView) v.findViewById(R.id.beer_brewery);
            beerImage = (ImageView) v.findViewById(R.id.beer_image);
        }
    }

    public BeerAdapter(List<Beer> beers, int rowLayout, Context context) {
        this.beers = beers;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public BeerAdapter.BeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new BeerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeerViewHolder holder, final int position) {
        //set text and image on view
        holder.beerName.setText(beers.get(position).getName());
        holder.beerBrewery.setText(beers.get(position).getBrewery().get(0).getName());
        Picasso.with(context).load(beers.get(position).getLabels().getMedium()).into(holder.beerImage);

        final View.OnClickListener makeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), BeerActivity.class);
                intent.putExtra("Name", beers.get(position).getName());
                intent.putExtra("Image", beers.get(position).getLabels().getLarge());
                intent.putExtra("Description", beers.get(position).getDescription());
                v.getContext().startActivity(intent);

            }
        };

        holder.itemView.setOnClickListener(makeListener);
    }

    @Override
    public int getItemCount() {
        return beers.size();
    }
}