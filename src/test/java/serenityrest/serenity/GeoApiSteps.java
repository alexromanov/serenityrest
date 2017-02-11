package serenityrest.serenity;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

/**
 * Created by aleksandr on 11.02.17.
 */
public class GeoApiSteps {

    @Step
    public void saveAddress(String adr){
        Serenity.getCurrentSession().put("address", adr);
    }

    @Step
    public void requestGeoCodeWithAddress(){
        Map<String, String> params = new HashMap<>();
        params.put("address", Serenity.getCurrentSession().get("address").toString());
        params.put("key", "AIzaSyB4PSrUP4QOqUmfHllvisriD1kntiNiExE");
        SerenityRest.given().contentType("application/json")
                .and().params(params)
                .when().get("https://maps.googleapis.com/maps/api/geocode/json");
    }

    @Step
    public void verifyLongitudeAndLatitude(float longitude, float latitude){
        SerenityRest.then().
                statusCode(200).
                body("results.geometry.location.lat[0]", equalTo(latitude)).
                body("results.geometry.location.lng[0]", equalTo(longitude));
    }

    @Step
    public void saveLongitudeLatitude(String lngLat){
        Serenity.getCurrentSession().put("latlng", lngLat);
    }

    @Step
    public void verifyAddress(String address){
        SerenityRest.then().
                statusCode(200).
                body("results.formatted_address[0]", equalTo(address));
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
}
