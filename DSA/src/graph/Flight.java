package graph;

public class Flight {

	Airport origin, destination;
	
	public Flight(Airport o, Airport d) {
		origin = o;
		destination = d;
	}
	
	public String toString() {
		return origin + "->" + destination;
	}
}
