Meta: Reverse Geo Coding API for Google Maps

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Get reversed geocode for Bedford Avenue
Given I have an longitude and latitude 40.714224,-73.961452
When I request google api for geocode with lontitude and latitude
Then I should get response status code 200
And I should get address 277 Bedford Ave, Brooklyn, NY 11211, USA