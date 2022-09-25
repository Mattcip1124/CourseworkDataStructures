package graph;

public class Airport implements Comparable {

	String name;
	boolean visited = false;
	boolean hub;
	
	public Airport(String name) {
		this.name = name;
		hub = false;
	}
	public Airport(String name, boolean hub) {
		this.name = name;
		this.hub = hub;
	}
	
	public String toString() {
		if(hub == true)
			return name + "(hub)";
		return name;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Airport))
			return false;
		Airport other = (Airport) obj;
		if(other.name.equals(name))
			return true;
		return false;
	}
	
	public void ChangeHubStatus() {
		if(hub == true)
			hub = false;
		else
			hub = true;
	}
	
	public int compareTo(Object o) {
		if(!(o instanceof Airport))
			return 1;
		Airport port = (Airport) o;
		if(port.hub == true && hub == true)
			return 0;
		if(port.hub == true && hub == false)
			return -1;
		return 1;
	}
}
