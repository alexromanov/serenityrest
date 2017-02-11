Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Get current weather data for Dnipro city
When I call weather api for Dnipro
Then weather data should be added

Scenario: Get current weather for city and country code
When I call weather api for Dnipro and country ua
Then weather data should be added

Scenario: Get current weather by city id
When I call weather api for city with 2172797 id
Then weather data should be added

