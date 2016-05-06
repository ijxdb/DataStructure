
public class LinkedList<T> implements ListInterface<T>{

	private Node<T> head;
	private Integer size;

	public LinkedList(){
		head = null;
		size = new Integer(0);
	}
	
	public void add(T item){
		if(head == null){
			head = new Node<T>(item, null);
		}
		else{
			Node<T> previous = head;
			Node<T> current = head.getNext();
			while(current != null){
				previous = current;
				current = current.getNext();
			}
			
			//last node is always null.
			Node<T> node = new Node<T>(item, null);
			previous.setNext(node);
		}
		size++;
	}
	
	public T getByLocation(Integer location){
		if(head == null){
			throw new RuntimeException("List is empty!!!");
		}
		if(location < 1 || location > size){
			throw new RuntimeException("No such index!!!");
		}
		Integer counter = 1;
		Node<T> current = head;
		while(!counter.equals(location)){
			current = current.getNext();
			counter++;
		}
		return current.getData();
	}
	
	public T getByData(T data){
		if(head == null){
			throw new RuntimeException("List is empty!!!");
		}
		Node<T> current = head;
		while(!current.getData().equals(data)){
			current = current.getNext();
		}
		return current.getData();
	}
	
	public void removeByLocation(Integer location){
		if(head == null){
			throw new RuntimeException("List is empty!!!");
		}
		if(location < 1 || location > size){
			throw new RuntimeException("No such location!!!");
		}
		if(location == 1){
			head = head.getNext();
		}
		else{
			Integer counter = 2;
			Node<T> previous = head;
			Node<T> current = head.getNext();
			//for (int i = 2; i < location; i++) {
				// goto next node for previous and current
			//	previous = current;
			//	current = current.getNext();
			//}
			while(counter < location){
				previous = current;
				current = current.getNext();
			}
			previous.setNext(current.getNext());
		}
		size--;
	}
				
	public void removeByData(T data){
		if(head == null){
			throw new RuntimeException("List is empty!!!");
		}
		if(head.getData().equals(data)){
			head = head.getNext();
		}
		else{
			Node<T> previous = head;
			Node<T> current = head.getNext();
			while(!current.getData().equals(data)){
				previous = current;
				current = current.getNext();
			}
			previous.setNext(current.getNext());
		}
		size--;
	}
	
	public Integer getSize(){
		return size;
	}

}
