package queue;


/**
 * An Airplane has a flight number, an arrival time, and a fuel level.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class Airplane implements Comparable  
{  int flight;
   int arrivalTime;
   int fuelLevel;       // gallons of jet fuel remaining
   
   public Airplane (int arrival, int fuel, int flight)
   {    arrivalTime = arrival;
        fuelLevel = fuel;
        this.flight = flight;
        System.out.println (this + " has arrived at time " + arrival);
        
    }
   
   public String toString() {
	   return "flight " + flight + ": fuel=" + fuelLevel + " gallon(s)";
   }
   
   public int compareTo(Object obj) {
	   Airplane plane = (Airplane) obj;
	   int fuelDif = plane.fuelLevel - fuelLevel;
	   int arrivDif = plane.arrivalTime - arrivalTime;
	   if(fuelLevel < 4 || plane.fuelLevel < 4) {
		   if(fuelDif == 0)
			   return arrivDif;
		   return fuelDif;
	   }
	   return arrivDif;
   }
}
