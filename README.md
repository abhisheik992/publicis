# publicis

#publicis 
 publicis app is a backend written in Java with Springbootusing H2 in memory DB. 
 EndPoints: 
 Add Card: 
 Endpoint: http://localhost:8080/api/v1/card
 Method: POST
 request:{
    "creditHolder":"Teju",
    "creditCardNumber":79927398733,
    "creditLimit": 2000
	}
 Get Existing Cards:
 Endpoint: http://localhost:8080/api/v1/cards
 Method: GET
#publicis-nodejs
 publicis-nodejs app is a backend written in Node with Express using Mongo DB. 
 EndPoints: 
 Add Card: 
 Endpoint: http://localhost:3002/cards
 Method: POST
 request:{
    "creditHolder":"Teju",
    "creditCardNumber":79927398733,
    "creditLimit": 2000
	}
 Get Existing Cards:
 Endpoint: http://localhost:3002/cards
 Method: GET

#publicis-ui
  publicis-ui app is a frontend written in Reacj Js with hooks and css.


#publicis-ui-angular
 publicis-ui-angular app is a frontend written in Angular with Material.