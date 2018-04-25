Feature: This tests are created for weather testing

Scenario: Testing coordinates
    When we are requesting weather
    Then LON should be -0.13
    And LAT should be 51.51
