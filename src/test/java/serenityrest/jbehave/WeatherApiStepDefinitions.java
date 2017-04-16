package serenityrest.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import serenityrest.serenity.GeoApiSteps;
import serenityrest.serenity.WeatherApiSteps;

public class WeatherApiStepDefinitions {

    @Steps
    private WeatherApiSteps wheatherCodeSteps;

    @When("I call weather api for $city")
    public void callApiForCurrentWeather(String city){

    }

    @When("I call weather api for $city and country $country")
    public void callApiForCurrentWeather(String city, String country){

    }

    @When("I call weather api for city with $cityId id")
    public void callApiForCurrentWeatherByCityId(String cityId){
        wheatherCodeSteps.requestWheatherWithCityID(cityId);
    }

    @Then("weather data should be added")
    public void thenDataShouldBeReceived() {
        wheatherCodeSteps.verifyWheatherResponse();
    }
}
