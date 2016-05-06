
/**
 * Node class: Defines a node of the list
 * @author Jay
 * @param <T> object of any class; can be int, character, Integer, String.
 */
public class Node<T> {

	/**
	 * data stores the value as an object of any class; data is a reference variable.
	 * next is an pointer to the next node in the list.
	 */
	private T data;
	private Node<T> next;
	
	/**
	 * Constructor: Initializes the data and next pointer.
	 * 
	 * @param data value for the node.
	 * @param next pointer to next node, can be null.
	 */
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	/** 
	 * Used to display the data stored in each node.
	 */
	public String toString() {
		return data.toString();
	}
	
	/**
	 * "Accessor" Method Used to get a data field.
	 * @return data: the value of the node.
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * "Accessor" Method Used to get the pointer to next node in the list.
	 * @return next: the next pointer.
	 */
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * "Mutator" Method Used to set a data field.
	 * @param data.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * "Mutator" Method Used to set the pointer field of current node.
	 * @param next.
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
