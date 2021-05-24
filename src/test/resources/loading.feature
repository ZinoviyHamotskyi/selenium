Feature: WebSite loading
  # 1
  Scenario Outline: load the page
    Given User is connected to the Internet
    When User is on "<Page>"
    Then Page title is "<Title>"
    Examples:
    |Page|Title                                                       |
    |Main|EPAM \| Enterprise Software Development, Design & Consulting|
    |Careers|Explore Professional Growth Opportunities \| EPAM Careers|
