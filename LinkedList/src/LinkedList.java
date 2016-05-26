
/**
 * Defines the functions of the List Interface Class
 * creates nodes of list
 * @author Jay
 * @param <T> object of any class; can be int, character, Integer, String.
 */
public class LinkedList<T> implements ListInterface<T> {

	
	/**
	 * head - First node of the list
	 * size - size of the List
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
	 * @param item is an object of any class
	 */
	public void add(T item) {
		if (head == null) {
			head = new Node<T>(item, null);
		} else {
			Node<T> previous = head;
			Node<T> current = head.getNext();
			while (current != null) {
				previous = current;
				current = current.getNext();
			}

			// last node is always null.
			Node<T> node = new Node<T>(item, null);
			previous.setNext(node);
		}
		size++;
	}

	/* (non-Javadoc)
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

	/* (non-Javadoc)
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

	/* (non-Javadoc)
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

	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see ListInterface#getSize()
	 */
	public Integer getSize() {
		return size;
	}

	/* (non-Javadoc)
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
	 * Displays the items of list
	 * Can be used instead of System.out.println()
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

}
