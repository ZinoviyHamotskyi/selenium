Feature: Careers Search
  #3
  Scenario: find existing job offer in default locations
    Given User is on "Careers"
    When User select keyword "Data Analyst"
    And User clicks Search Button
    Then User see "WE FOUND 4 JOB OPENINGS RELATED TO \"DATA ANALYST\""
  #4
  Scenario: find existing job offer in special locations
    Given User is on "Careers"
    When User select location "Kharkiv"
    And User select keyword "Data Analyst"
    And User clicks Search Button
    And User see "WE FOUND 1 JOB OPENINGS RELATED TO \"DATA ANALYST\""
  #5
  Scenario: find all existing job offers
    Given User is on "Careers"
    When User select location "All Locations"
    And User clicks Search Button
    And User see "WE FOUND 3939 JOB OPENINGS FOR YOU"
  #6
  Scenario: find all job offers in default locations
    Given User is on "Careers"
    When  User clicks Search Button
    And User see "WE FOUND 214 JOB OPENINGS FOR YOU"
  #7
  Scenario: find existing job offer in default locations with incorrect keyword
    Given User is on "Careers"
    When User select keyword "Data Anallyst"
    And User clicks Search Button
    Then User see "Sorry, your search returned no results. Please try another combination."
  #8
  Scenario: trying to find job in Tashkent
    Given User is on "Careers"
    When User select location "Tashkent"
    And User select keyword "Data Analyst"
    And User clicks Search Button
    And User see "Sorry, your search returned no results. Please try another combination."