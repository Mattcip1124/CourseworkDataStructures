package graph;
import java.io.File;
import queue.*;
import java.io.IOException;
import java.util.Scanner;

import list.*;
import map.*;

public class Airline {

	static List<Flight> flights;	//Direct Flights
	static Map<String, Airport> map;	//Keys are airport names, Values are airports.
	
	public static void main(String[] args) {
		Airline airline = new Airline();
		
		//read direct flights from a text file
		airline.getFlights();
		System.out.println(airline);
		System.out.println(map);
		//Find a path from PHL to SFO
		//System.out.println("Path from PHL to SFO:");
		//System.out.println(airline.path("PHL", "SFO"));
		//Lab 13
		System.out.println("Lab 13 non hub:");
		System.out.println(airline.path("CVG", "Paris"));
		System.out.println("Lab13 hub:");
		map.get("PHL").ChangeHubStatus();
		System.out.println(airline.path("CVG", "Paris"));
	}
	
	private List<Airport> path(String origin, String destination) {
		clearAirports();
		Airport o = map.get(origin);
		Airport d = map.get(destination);
		List<Airport> result = path(o,d);
		return result;
	}
	
	private List<Airport> path(Airport origin, Airport destination) {
		List<Airport> result = new LinkedList<Airport>();
		origin.visited = true;
		//Base Case
		if(origin.equals(destination)) {
			result.add(origin);
			return result;
		}
		//recursive case
		Airport port;
		QueueADT<Airport> ports = getDirect(origin);
		while(!ports.isEmpty()) {
			port = ports.remove();
			result = path(port, destination);
			if(result.size() > 0) {
				result.add(0, origin);
				return result;
			}
		}
		return result;
	}
	
	private QueueADT<Airport> getDirect(Airport from) {
		QueueADT<Airport> result = new PriorityQueue<Airport>();
		
		Flight flight;
		Iterator<Flight> itty = flights.iterator();
		while(itty.hasNext()) {
			flight = itty.next();
			if(flight.origin.equals(from) && !(flight.destination.visited))
				result.add(flight.destination);
		}
		return result;
	}
	
	private void getFlights() {
		File inFile = new File("flights.txt");
		map = new HashMap<String, Airport>();
		flights = new ArrayList<Flight>();
		
		try {
			Scanner scanner = new Scanner(inFile);
			String flight, origin, dest;
			Airport o, d;
			while(scanner.hasNextLine()) {
				flight = scanner.nextLine();
				origin = flight.split(" ")[0];
				dest = flight.split(" ")[1];
				
				if(map.containsKey(origin))
					o = map.get(origin);
				else {
					o = new Airport(origin);
					map.put(origin, o);
				}
				if(map.containsKey(dest))
					d = map.get(dest);
				else {
					d = new Airport(dest);
					map.put(dest, d);
				}
				flights.add(new Flight(o, d));
			}
			scanner.close();
		}
		catch(IOException ioe) {
			System.out.println("File not found");
		}
	}
	
	   /** Clear the visited flags in all airports */    
	private void clearAirports()    
	{  Flight flight;       
	   Iterator<Flight> itty = flights.iterator();          
	   
	   while (itty.hasNext()) { 
		   flight = itty.next();        
		   flight.origin.visited = false;  
	       flight.destination.visited = false;
	   }
	}
	
	public String toString() {
		return "Flights: " + flights;
	}
}
