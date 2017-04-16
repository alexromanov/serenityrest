package serenityrest.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import serenityrest.serenity.GeoApiActions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GeoApiStepDefinitions {
    @Steps
    private GeoApiActions geoApiActions;

    @Given("I have an address $adr")
    public void givenIHaveAnAddress(String adr) {
        geoApiActions.saveAddress(adr);
    }

    @Given("I have an longitude and latitude $lnglat")
    public void givenIHaveLngLat(String lnglat){
        geoApiActions.saveLongitudeLatitude(lnglat);
    }

    @When("I request google api for geocode with address")
    public void whenIRequestGeoCodeApiWithAddress(){
        geoApiActions.requestGeoCodeWithAddress();
    }

    @When("I request google api for geocode with lontitude and latitude")
    public void whenIRequestGeoCodeWithLatLng(){
        geoApiActions.requestGeoCodeWithLngLat();
    }

    @Then("I should get longitude $lng and latitude $lat")
    public void thenIShouldHaveLongAndLat(float lng, float lat){
        assertThat("Wrong longitude in response", geoApiActions.getResponseLongitude(), equalTo(lng));
        assertThat("Wrong latitude in response", geoApiActions.getResponseLatitude(), equalTo(lat));
    }

    @Then("I should get address $address")
    public void thenIShouldHaveAddress(String address){
        assertThat("Wrong address in response", geoApiActions.getAddress(), equalTo(address));
    }

    @Then("I should get response status code $expectedStatusCode")
    public void verifyStatusCode(int expectedStatusCode){
        assertThat("Wrong response status code", geoApiActions.getStatusCode() ,equalTo(expectedStatusCode));
    }
}
