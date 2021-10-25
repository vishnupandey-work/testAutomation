Feature: Landing page
 
  Scenario Outline: Booking a flights
    Given user is on landing page of Indigo
	When user wants to book a One-way ticket from "<source>" to "<destination>"
	And Departure Date is "<date>" "<month>" "<year>"
	Then user can search for flight
	
	Examples:
    | source 	| destination 	| date 	| month 	| year |
    | Delhi 	| chennai 		|  7 	| November 	| 2021 |
    | Chennai	| Bengaluru		|  15 	| January 	| 2022 |
    | Mumbai	| Nainital 		|  10 	| December 	| 2021 |
    
    
