
public class ListStack<T> implements StackInterface<T>{
	
	private Node<T> top;
	
	public ListStack(){
		top = null;
	}
	
	public boolean isEmpty(){
		if(top == null)
			return true;
		else
			return false;
	}
	
	public T pop() throws StackException{
		return null;
	}
	
	public T peek() throws StackException{
		if(isEmpty()) throw new StackException("Stack is empty.");
		return top.getData(top);
	}
	
	public void push(T e) throws StackException{
		
	}
	
	public void clear(){
		top = null;
		
	}
	
	public String display(){
		return null;
	}
	
	public static void main(String[] args){
		
	}

}
