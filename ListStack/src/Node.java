
public class Node<T> {
	
	private T data;
	private Node<T> next;
	
	public Node(T data){
		this(data, null);
	}
	
	public Node(T data, Node<T> n){
		this.data = data;
		next = n;
	}

}
