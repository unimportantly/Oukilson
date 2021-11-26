package fr.oukilson.app.entity;

public class LocationTest {


    //Testing for invalid addresses
        //Valid format + valid input
            //Valid input in the proper fields
        //Invalid format + valid input
            //Incomplete address(test all fields)
        //Valid format + invalid input
            //Invalid input(numbers in the city field, etc... test all fields)
    //Testing for connection issues
        //No exceptions
            //valid query + valid response
        //Upstream problems
            //invalid query(test address, test query's nature, ??)
        //Downstream problems
            //invalid answer(how to even get that?), but implement checks for the data recieved?
            //check if event's location has been logged in the db?
    //Testing for display issues
        //Valid data + valid display
            //event's location appears properly(in event info, on the map, in the list of events in that area)
        //Invalid display
            //event's location doesn't appear properly(in event info, on the map, in the list of events in that area)
}
