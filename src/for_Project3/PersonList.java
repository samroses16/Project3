package for_Project3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.io.*;

public class PersonList<E> {
	
	//instance variables 
	LinkedList<Person> list = new LinkedList<>();
	
	//add
	public boolean add(Person p) {
		if (!list.contains(p)) {
			list.add(p);
			return true;
		}
		return false; 
	}
	
	// addAlpha
	public boolean addAlpha(Person P) {
		if (!list.contains(P)) {
			list.addAlpha(P);
			return true;
		}
		return false; 
	}
	
	//search
	public Person search(Person p) {
		if (list.contains(p)) {
			return p;
		}
		return null;
	}
	
	//two methods
	public String saveToFile(String fileName) {
		 String messageFromSave = "";
		 try {
		   ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
		   for(int i = 0; i < list.size(); i++) {
		    oOS.writeObject(list.get(i));
		   }
		   oOS.flush();
		   oOS.close();
		 }catch(Exception e) {
		   messageFromSave = e.toString();
		 }
		  return messageFromSave;
		}

		public String loadFromFile(String fileName) {
		  String toReturn = ""; 
		  try{
		     ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
		     while(oIS.available() > -1) {
		       Person fromFile = (Person)(oIS.readObject());
		       Person found = search(fromFile);
		       if(found == null) {
		         if(add(fromFile)) {
		             toReturn += fromFile + "\n";
		        }else {
		             toReturn += fromFile + " not successfully added to DB.\n";
		        }
		      }else {
		        toReturn += found + " already in the DB.\n";
		      }
		   }
		   oIS.close();
		   }catch (EOFException eOF){
		   }
		   catch(Exception e) {
		      toReturn += e;
		   }
		   return toReturn;
		}
	

	//delete 
	public boolean delete(Name n) {
		MyIterator iter = new  MyIterator(list);
		while (iter.hasNext()) {
			Person iter2 = (Person) iter.next();
			if(iter2.getName().equals(n)) {
				iter.remove();
				return true;	
			}
		}
		return false;
	}
		
	//hasBirthday
	public String hasBirthdayOn(Date data) {
		String toReturn = "Nobody has a birthday on that date.";
		for (Person p : list) {
			if (p.getDate().equals(data)) {
				toReturn = p.toString();
			}
		}
		return toReturn;
	}
	
	//printlist
	public String printList() {
		String toReturn = "";
		for (Person p : list) {
			toReturn += p.toString();
		}
		return toReturn;
	}
	
	//sortAlhab
	public String sortAlphab() {
		return printList();
	}
	
	//sortChrono
	public String sortChronol() {
		LinkedList<Person> list2 = new LinkedList<>(new ChronoComparator());
		for (Person p : list) {
			list2.add(p);
		}
		list2.sort();
		String toReturn = "";
		for (Person p : list2) {
			toReturn += p.toString();
		}
		return toReturn;
		
	}
	
	//findPerson
	public String findPersonByName(Name name) {
		String toReturn = "Nobody has the same name.";
		for (Person p : list) {
			if (p.getName().equals(name)) {
				toReturn = p.toString();
			}
		}
		return toReturn;
	}
	
	
	
	
	
	
	

}
