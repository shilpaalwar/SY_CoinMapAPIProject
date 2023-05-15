#Author: shilpagpt.com
#Feature: This file contains Filter and extract information scenarios on Coin Market Cap Application

Feature: Price Conversion 

  @GTQTOGBP_PriceConversion
  Scenario Outline: Price Convert from GTQ to GBP
    Given User calls priceConvert API with <3541> and <10000000> and <convert>
    When user call API with GET Request
    Then API Call return Success Code <statuscode>
    And verify price in GBP in API repsonse
    
  Examples: 
     | convert  | statuscode | 
     | "GBP"      |     200 |
     
  
  @GBPTODOGE_PriceConversion
  Scenario Outline: Price Convert from GTQ to GBP
    Given User calls priceConvert API with <2791> and <convert>
    When user call API with GET Request
    Then API Call return Success Code <statuscode>
    And Verify price in DOGE in API repsonse
    
  Examples: 
     | convert  | statuscode | 
     | "DOGE"      |     200 |