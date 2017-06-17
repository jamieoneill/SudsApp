package mismatched.com.sudsapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jamie on 15/06/2017.
 */

public class Beer {

    //private variables
    @SerializedName("name")
    private String name;
    @SerializedName("breweries")
    private List<Brewery> breweries;
    @SerializedName("description")
    private String description;
    @SerializedName("labels")
    private Labels labels;

    // Empty constructor
    public Beer(){
    }

    // constructor
    public Beer(String name, List<Brewery> breweries, String description, Labels labels){
        this.name= name;
        this.breweries = breweries;
        this.description = description;
        this.labels = labels;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public List<Brewery> getBrewery() {return breweries;}

    public void setBrewery(List<Brewery> brewery) {this.breweries = breweries;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Labels getLabels() {return labels;}

    public void setLabels(Labels labels) {this.labels = labels;}
}