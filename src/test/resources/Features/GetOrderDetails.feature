
Feature: Get order details
  

Scenario:
  Given user is using the baseURI
  When User retrive order details "/store/order/123"
  And validate the details
  Then user need to get a response code: 200
