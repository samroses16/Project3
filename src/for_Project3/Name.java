package for_Project3;

import java.io.Serializable;
import java.util.Objects;

public class Name implements Comparable<Name>, Serializable{
	
	//instance variables 
	private String first;
	private String middle;
	private String last;
	
	//constructor 1
	//with middle name 
	public Name(String first, String middle, String last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
	}

	//constructor 2
	//without middle name 
	public Name(String first, String last) {
		this.first = first;
		this.middle = "";
		this.last = last;
	}

	//getters and setters 
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	//equals and hashcode
	@Override
	public int hashCode() {
		return Objects.hash(first, last, middle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		return Objects.equals(first, other.first) && Objects.equals(last, other.last)
				&& Objects.equals(middle, other.middle);
	}

	//toString
	@Override
	public String toString() {
		//return "Name [first=" + first + ", middle=" + middle + ", last=" + last + "]";
		
		if (middle.isEmpty()) {
			return  first + " " + last;
		}else {
			return first + middle + last;
		} 
	}

	@Override
	public int compareTo(Name o) {
		// TODO Auto-generated method stub
		int c = last.compareTo(o.last);
		if(c == 0) {
			c = first.compareTo(o.first);
		}
		return c;
	}
	
	//serializable
	

}
