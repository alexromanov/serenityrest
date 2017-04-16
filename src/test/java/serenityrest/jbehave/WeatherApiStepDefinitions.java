package serenityrest.jbehave;

import org.jbehave.core.annotations.When;

public class WeatherApiStepDefinitions {

    @When("I call weather api for $city")
    public void callApiForCurrentWeather(String city){

    }

    @When("I call weather api for $city and country $country")
    public void callApiForCurrentWeather(String city, String country){

    }

    @When("I call weather api for city with $cityId id")
    public void callApiForCurrentWeatherByCityId(String cityId){

    }
}
