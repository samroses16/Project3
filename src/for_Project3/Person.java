package for_Project3;

import java.io.Serializable;
import java.util.Objects;


//implements Comparable<Person>
public class Person implements Comparable<Person>, Serializable {
	
	//instance variables 
	private Name name;
	private Date date;
	private static int numPeople = 0;
	
	//constructor 1 
	public Person(Name name, Date date) {
		this.name = name;
		this.date = date;
		numPeople++;
	}
	
	//constructor 2 
	public Person(String first, String last, Month month, int day, int year) {
		this.name = new Name(first, last);
		this.date = new Date(month, day, year);
		numPeople++;
	}
	
	//getters 
	public int getNumPpl() {
		return numPeople;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Name getName() {
		return name;
	}

	//equals, hashcode 
	@Override
	public int hashCode() {
		return Objects.hash(date, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(date, other.date) && Objects.equals(name, other.name);
	}
	
	//toString 
	@Override
	public String toString() {
		//inherited from object class
		return name.toString() + ", " + date.toString() + "\n"; 
	}
	
	//comparable 
	public int compareTo(Person other) {
		return name.compareTo(other.getName());
	}
	
	
	//serializable 

}
