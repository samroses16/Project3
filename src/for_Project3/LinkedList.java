package for_Project3;

import java.util.Comparator;
import java.util.Iterator;
public class LinkedList<E extends Comparable<E>> implements Iterable<E> {
	
	private Node<E> head;
	private int size;
	private Comparator<E> comparator;
	
	public LinkedList(Comparator<E> comparator) {
		head = null;
		size = 0;
		this.comparator = comparator;
	}
	
	
	public LinkedList() {
		head = null;
		size = 0;
		this.comparator = null;
	}
	
	public void add(E data) {
		Node<E> n = new Node<>(data);
		if(head == null) {
			head = n;
			size++;
			return;
		}
		Node<E> mover = head;
		while( mover.getLink() != null) {
			mover = mover.getLink();
		}
		mover.setLink(n);
		size++;
	}
	
	public void addFirst(E data) {
		Node<E> n = new Node<>(data);
		n.setLink(head);
		head = n; 
		size++;
	}

	public String toString() {
		String toReturn = "";
		Node<E> mover = head;
		while(mover != null) {
			toReturn += mover.getData() + " - ";
			mover = mover.getLink();
		}
		if (size == 0 ) {
			toReturn = "Empty list";
		}
		return toReturn;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> mover = head;
		for (int i = 0; i < index; i++) {
			mover = mover.getLink();
		}
		return mover.getData();
	}
	
	public void set(int index, E data) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> mover = head;
		for (int i = 0; i < index; i++) {
			mover = mover.getLink();
		}
		mover.setData(data);
	}
	public boolean remove(E data) {
		if (head == null) {
			return false;
			
		}
		if (head.getData().equals(data)) {
			head = head.getLink();
			size--;
			return true; 
		}
		
		Node<E> mover1 = head;
		Node<E> mover2 = head.getLink();
		
		while (mover2 != null) {
			if (mover2.getData().equals(data)) {
				mover1.setLink(mover2.getLink());
				size--;
				return true;
				
			}else {
				mover1 = mover1.getLink();
				mover2 = mover2.getLink();
			}
		}
		return false;	

	}
	
	public int size() {
		return size;
	}
	
	public void addAlpha(E data) {
		//insert a new node 
		Node<E> n = new Node<>(data);
		if(head == null) {
			head = n;
			size++;
			return;
		}else { 
			Node<E> curr = head;
			while(curr.getLink() != null && myCompare(data, curr.getData()) > 0 ) {
				curr = curr.getLink();
			}
			n.setLink(curr.getLink());
			curr.setLink(n);
			size++;
		}
	}
	
	public boolean contains(E data) {
		if(head == null) {
			return false;
		}

		Node<E> mover = head;
		while(mover!= null) {
			if(mover.getData().equals(data)) {
				return true;
			}else {
				mover = mover.getLink(); // move mover along
			}
		}
		return false;
	}
	
	
	
	public int myCompare(E one, E two) {
		if (comparator == null) {
			return one.compareTo(two);
		}
		return comparator.compare(one, two);
	}

	//merge sort 
	public Node<E> getMiddle(Node<E> head){
		Node<E> slow = head;
		Node<E> fast = head;
		while(fast.getLink() != null && fast.getLink().getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
		}
		return slow;
	}

	public Node<E> merge(Node<E> a, Node<E> b){
		Node<E> result = null;
		if (a == null) {
			return b;
		}
		if(b == null) {
			return a;
		}
		if (myCompare(a.getData(), b.getData()) <= 0) {
			result = a;
			result.setLink(merge(a.getLink(), b));
		}else {
			result = b;
			result.setLink(merge(a, b.getLink()));
		}
		return result;
	}

	public Node<E> mergeSort(Node<E> h){
		if (h == null || h.getLink() == null) {
			return h;
		}
		Node<E> middle = getMiddle(h);
		Node<E> nexttomiddle = middle.getLink();
		middle.setLink(null);
		Node<E> left = mergeSort(h);
		Node<E> right = mergeSort(nexttomiddle);
		Node<E> sortedlist = merge(left, right);
		return sortedlist;
	}
	
	public void sort() {
		head = this.mergeSort(head);
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator<E>(this);
	}
		
	

}
