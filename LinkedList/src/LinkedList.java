
/**
 * Defines the functions of the List Interface Class creates nodes of list
 * 
 * @author Jay
 * @param <T>
 *            object of any class; can be int, character, Integer, String.
 */
public class LinkedList<T> implements ListInterface<T> {

	/**
	 * head - First node of the list size - size of the List
	 */
	private Node<T> head;
	private Integer size;

	/**
	 * Constructor - Initializes the first node and size of the list
	 */
	public LinkedList() {
		head = null;
		size = new Integer(0);
	}

	/**
	 * Adds an item (of any class) to the list
	 * 
	 * @param item
	 *            is an object of any class
	 */
	public void add(T item) {
		if (head == null) {
			head = new Node<T>(item, null);
		} else {
			// Node<T> previous = head;
			Node<T> current = head;// .getNext();
			/*
			 * while (current != null) { previous = current; current =
			 * current.getNext(); }
			 * 
			 * // last node is always null. Node<T> node = new Node<T>(item,
			 * null); previous.setNext(node);
			 */
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new Node<T>(item, null));
		}
		size++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ListInterface#getByLocation(java.lang.Integer)
	 */
	public T getByLocation(Integer location) {
		if (head == null) {
			throw new RuntimeException("List is empty!!!");
		}
		if (location < 1 || location > size) {
			throw new RuntimeException("No such index!!!");
		}
		Integer counter = 1;
		Node<T> current = head;
		while (!counter.equals(location)) {
			current = current.getNext();
			counter++;
		}
		return current.getData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ListInterface#getByData(java.lang.Object)
	 */
	public T getByData(T data) {
		if (head == null) {
			throw new RuntimeException("List is empty!!!");
		}
		Node<T> current = head;
		while (!current.getData().equals(data)) {
			current = current.getNext();
		}
		return current.getData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ListInterface#removeByLocation(java.lang.Integer)
	 */
	public void removeByLocation(Integer location) {
		if (head == null) {
			throw new RuntimeException("List is empty!!!");
		}
		if (location < 1 || location > size) {
			throw new RuntimeException("No such location!!!");
		}
		if (location == 1) {
			head = head.getNext();
		} else {
			Integer counter = 2;
			Node<T> previous = head;
			Node<T> current = head.getNext();
			// for (int i = 2; i < location; i++) {
			// goto next node for previous and current
			// previous = current;
			// current = current.getNext();
			// }
			while (counter < location) {
				previous = current;
				current = current.getNext();
				counter += 1;
			}
			previous.setNext(current.getNext());
		}
		size--;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ListInterface#removeByData(java.lang.Object)
	 */
	public void removeByData(T data) {
		if (head == null) {
			throw new RuntimeException("List is empty!!!");
		}
		if (head.getData().equals(data)) {
			head = head.getNext();
		} else {
			Node<T> previous = head;
			Node<T> current = head.getNext();
			while (!current.getData().equals(data)) {
				previous = current;
				current = current.getNext();
			}
			previous.setNext(current.getNext());
		}
		size--;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ListInterface#getSize()
	 */
	public Integer getSize() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String csvformat = new String("");// ="";
		Integer location = 1;
		Node<T> current = head;
		// for(Node<T> current = head; current != null; current =
		// current.getNext()){
		// csvformat = csvformat + location + "," + current.getData() + "\n";
		// location++;
		// }
		if (current == null) {
			csvformat = "The LinkedList is empty!!!";
		}
		while (current != null) {
			csvformat = csvformat + location + " , " + current.getData() + "\n";
			current = current.getNext();
			location++;
		}
		return csvformat;
	}

	/**
	 * Displays the items of list Can be used instead of System.out.println()
	 */
	public void displayList() {
		Node<T> current = head;
		if (current == null) {
			System.out.println("List is empty!!!");
		}
		while (current != null) {
			System.out.println(current.getData() + " ");
			current = current.getNext();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {

		// If the object is compared with itself then return true
		if (this == obj) {
			return true;
		}

		// use instanceof instead of getClass here for two reasons
		// 1. if need be, it can match any supertype, and not just one class;
		// 2. it renders an explicit check for "that == null" redundant, since
		// it does the check for null already - "null instanceof [type]" always
		// returns false. (See Effective Java by Joshua Bloch.)

		// if ( !(aThat instanceof Car) ) return false;

		// Alternative to the above line :
		// if ( aThat == null || aThat.getClass() != this.getClass() ) return
		// false;
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}

		LinkedList<T> other = (LinkedList<T>) obj;
		return equals(head, other.head);
	}

	/**
	 * Recursive method to determine if two LinkedListRec objects are equal.
	 * 
	 * @param node1
	 *            The current node in this list
	 * @param node2
	 *            The current node in the other list
	 */
	private boolean equals(Node<T> node1, Node<T> node2) {
		if (node1 == null & node2 == null) {
			return true;
		}
		if (node1 == null) {
			return false;
		}
		if (node2 == null) {
			return false;
		}
		if (node1.getData().equals(node2.getData())) {
			return equals(node1.getNext(), node2.getNext());
		}
		return false;
	}

	public void insert(T obj, int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			head = new Node<T>(obj, head);
		} else {
			insert(obj, head, index-1);
		}
	}

	/**
	 * Method to insert an object at a specified index
	 * 
	 * @param obj
	 *            The object to be inserted
	 * @param pred
	 *            the node preceding the node at the current indes
	 * @param index
	 *            the current index
	 */
	private void insert(T obj, Node<T> pred, int index) {
		if (pred == null) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			pred.setNext(new Node<T>(obj, pred.getNext()));
		} else {
			insert(obj, pred.getNext(), index - 1);
		}
	}

}
