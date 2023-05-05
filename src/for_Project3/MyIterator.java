package for_Project3;

import java.util.Iterator;
public class MyIterator<E extends Comparable<E>> implements Iterator<E> {

	private LinkedList<E> ll;
	private Object element;
	private int index; 
	private boolean removeGotCalled;
	
	public MyIterator(LinkedList<E> thelist) {
		ll = thelist;
		element = ll.get(0);
		index = 0;
		removeGotCalled = false;
	}
	
	
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return element != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		// TODO Auto-generated method stub
		Object toReturn = element;
		index++;
		try {
			element = ll.get(index);
		}catch(IndexOutOfBoundsException e) {
			element = null;
		}
		removeGotCalled = false;
		return (E)toReturn;
	
	}
	
	@Override
	public void remove() {
		if (index == 0 || removeGotCalled) {
			throw new IllegalStateException();
		}
		ll.remove(ll.get(index-1));
		index--;
		removeGotCalled = true;
	}
	
	
	

}
