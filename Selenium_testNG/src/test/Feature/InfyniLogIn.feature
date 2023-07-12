Feature: To open Infyni website and navigating to some options
  Scenario Outline: Launch Infyni website and validate logo ,check box
    Given user launch Infyni Website  "<url>"
    Then user validate Infyni logo
    When user click on LogIn button
    Then user navigate to LogIn page
    And Validate remember me check box is not checked by default
    Then user input incorrect "<userID>" and "<password>"
    And user see error message  says invalid credentials
    Then user clicks on Dont have a account SignUp link
    And user successfully navigated to signUp page

    Examples:
    |url|userID|password|
    |https://infyni.com/|abc@gmail.com|1234|
