Feature: To Print all the links in  Flipkart  website
  Scenario Outline: check the flipkart logo ,  validate it and print all links
    Given user generate report using Extent report
    Then user launch flipkart website with URL as "<url>"
    And user validate flipkart logo
    And user print all the links in flipkart website


    Examples:
    |url|
    |https://www.flipkart.com/|


