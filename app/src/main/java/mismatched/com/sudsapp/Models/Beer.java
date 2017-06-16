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
    @SerializedName("brewery")
    private List<Brewery> brewery;
    @SerializedName("description")
    private String description;
    @SerializedName("label")
    private String label;

    // Empty constructor
    public Beer(){
    }

    // constructor
    public Beer(String name, List<Brewery> brewery, String description, String label){
        this.name= name;
        this.brewery = brewery;
        this.description = description;
        this.label = label;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public List<Brewery> getBrewery() {return brewery;}

    public void setBrewery(List<Brewery> brewery) {this.brewery = brewery;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getLabel() {return label;}

    public void setLabel(String label) {this.label = label;}
}