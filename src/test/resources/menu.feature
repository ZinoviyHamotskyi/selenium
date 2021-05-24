Feature: Menu
  # 2
  Scenario Outline: Display menu
    Given User is on <Page>
    Then Menu is visible
    Examples:
      | Page           |
      | "Careers"     |
      | "Main"     |
      | "About"     |