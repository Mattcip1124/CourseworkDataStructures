package hashdriver;

import hash.*;

/**
 * @author Matthew Cipriotti
 */
public class Date {

	int day;
	int month;
	int year;
	
	public Date(int month, int day, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Date))
			return false;
		Date d = (Date) obj;
		return day == d.getDay() && month == d.getMonth() && year == d.getYear();
	}
	
	@Override
	public int hashCode() {
		int result = 31;
		
		result = 31 * result + day;
		result = 31 * result + month;
		result = 31 * result + year;
		
		return result;
	}
}
