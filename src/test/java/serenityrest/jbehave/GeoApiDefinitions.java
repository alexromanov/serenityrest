package serenityrest.jbehave;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import serenityrest.serenity.GeoApiSteps;

import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleksandr on 11.02.17.
 */
public class GeoApiDefinitions {

    @Steps
    private GeoApiSteps geoCodeSteps;

    @Given("I have an address $adr")
    public void givenIHaveAnAddress(String adr) {
        geoCodeSteps.saveAddress(adr);

    }

    @Given("I have an longitude and latitude $lnglat")
    public void givenIHaveLngLat(String lnglat){
        geoCodeSteps.saveLongitudeLatitude(lnglat);
    }

    @When("I request google api for geocode with address")
    public void whenIRequestGeoCodeApiWithAddress(){
        geoCodeSteps.requestGeoCodeWithAddress();
    }

    @When("I request google api for geocode with lontitude and latitude")
    public void whenIRequestGeoCodeWithLatLng(){
        geoCodeSteps.requestGeoCodeWithLngLat();
    }

    @Then("I should get longitude $lng and latitude $lat")
    public void thenIShouldHaveLongAndLat(float lng, float lat){
        geoCodeSteps.verifyLongitudeAndLatitude(lng,lat);
    }

    @Then("I should get address $address")
    public void thenIShouldHaveAddress(String address){
        geoCodeSteps.verifyAddress(address);
    }
}
