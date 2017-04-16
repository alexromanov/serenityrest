package serenityrest.serenity;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class GeoApiActions {

    @Step
    public void saveAddress(String adr){
        Serenity.getCurrentSession().put("address", adr);
    }

    @Step
    public void requestGeoCodeWithAddress(){
        Map<String, String> params = new HashMap<>();
        params.put("address", Serenity.getCurrentSession().get("address").toString());
        params.put("key", "AIzaSyA2fREIe1D2Y48aZ1QQiIcokpgrAHIZ8e0");
        SerenityRest.given().contentType("application/json")
                .and().params(params)
                .when().get("https://maps.googleapis.com/maps/api/geocode/json");
    }

    @Step
    public float getResponseLongitude(){
        return SerenityRest.then().extract().body().jsonPath().get("results.geometry.location.lng[0]");
    }

    @Step
    public float getResponseLatitude(){
        return SerenityRest.then().extract().body().jsonPath().get("results.geometry.location.lat[0]");
    }

    @Step
    public void saveLongitudeLatitude(String lngLat){
        Serenity.getCurrentSession().put("latlng", lngLat);
    }

    @Step
    public String getAddress(){
        return SerenityRest.then().extract().body().jsonPath().get("results.formatted_address[0]");
    }

    @Step
    public void requestGeoCodeWithLngLat(){
        Map<String, String> params = new HashMap<>();
        params.put("latlng", Serenity.getCurrentSession().get("latlng").toString());
        params.put("key", "AIzaSyB4PSrUP4QOqUmfHllvisriD1kntiNiExE");
        SerenityRest.given().contentType("application/json")
                .and().params(params)
                .when().get("https://maps.googleapis.com/maps/api/geocode/json");
    }

    @Step
    public int getStatusCode(){
        return SerenityRest.then().extract().statusCode();
    }
}
