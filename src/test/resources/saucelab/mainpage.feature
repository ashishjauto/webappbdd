
Feature: Sauce Lab login page
  have login and password field to login to web

  Scenario Outline: Navigate to saucelab page and username and password text box should display
    Given When i navigate to sauce lab login page should display
    And i can view username and password for the dummy app
    Then <userName> and <password> field should be enabled with login button:
    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |
  #    | locked_out_user | secret_sauce |
  #    | problem_user  | secret_sauce |

