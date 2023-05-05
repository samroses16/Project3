package for_Project3;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable{
	
	//month(enum), day, year 
	private Month month; 
	private int day;
	private int year; 
	
	//three argument constructor 
	public Date(Month themonth, int theday, int theyear) {
		if (theyear > 0 && Month.isValidDay(themonth, theday)) {
			this.month = themonth;
			this.day = theday;
			this.year = theyear;
		}else {
			throw new IllegalArgumentException();
		}
	}

	//getters and setters
	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		if (Month.isValidDay(month, this.day)) {
			this.month = month;
		}else {
			throw new IllegalArgumentException();
		}
		
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (Month.isValidDay(this.month, day)) {
			this.day = day;
		}else {
			throw new IllegalArgumentException();
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		}else {
			throw new IllegalArgumentException();
		}
	}

	//equals and hashcode
	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}	
	
	//toString
	public String toString() {
		return this.month.getName() + " " + day  + ", " + year;
	}
	
	//serializable 

}
