package for_Project3;

import java.util.Comparator;

public class ChronoComparator implements Comparator<Person> {
	
	//checking years 
	public int compare(Person d1, Person d2) {
		Date date1 = d1.getDate();
		Date date2 = d2.getDate();
		if(date1.getYear() == date1.getYear()) {
			if (date1.getMonth().getNum() == date2.getMonth().getNum()) {
				return Integer.compare(date1.getDay(), date2.getDay());
			}
		}else {
			return Integer.compare(date1.getMonth().getNum(), date2.getMonth().getNum());
		}
		return Integer.compare(date1.getYear(), date2.getYear());
	}

}
