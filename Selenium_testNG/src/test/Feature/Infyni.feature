Feature: To validate Infyni SignIn scenario

 Scenario Outline: signup scenario with multiple data combination
   Given user launch Infyni application with URL as "<url>"
   Then user navigate to signup page
   And user see Header as All fields are mandatory
   And user fill First Name as "<Fname>"
   And user fill Last Name as "<Lname>"
   And user fill email address as "<EmailAddress>"
   And user fill password as "<Pword>"
   And user fill confirm password as "<CPword>"

   Examples:
   |url|Fname|Lname|EmailAddress|Pword|CPword|
   |https://infyni.com/|john|khan|abc@gmail.com|1234|1234|
   |https://infyni.com/|sai|kalifa|xyz@gmail.com|5678|5678|
   |https://infyni.com/|josh|kabul|mno@gmail.com|1357|1357|
   |https://infyni.com/|imran|davudh|sdf@gmail.com|0987|0987|
   |https://infyni.com/|murali|josh|opl@gmail.com|5432|5432|


