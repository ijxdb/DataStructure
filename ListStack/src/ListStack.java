
public class ListStack<T> implements StackInterface<T>{
	
	private Node<T> top;
	
	public ListStack(){
		top = null;
	}
	
	public boolean isEmpty(){
		if(top == null)
			return true;
		return false;
	}
	
	public T pop() throws StackException{
		if(isEmpty()) throw new StackException("Stack is empty.");
		T data = top.getData(top);
		top = top.getNext(top);
		return data;
	}
	
	public T peek() throws StackException{
		if(isEmpty()) throw new StackException("Stack is empty.");
		return top.getData(top);
	}
	
	public void push(T e) throws StackException{
		top = new Node<T>(e, top);
	}
	
	public void clear(){
		top = null;
	}
	
	public String displayStack(){
		if(isEmpty())
			return "[ ]";
		StringBuffer stackElements = new StringBuffer("[");
		Node<T> temp = top;
		while(temp != null){
			stackElements.append(temp.getData(temp)+"->");
			temp = temp.getNext(temp);
		}
		stackElements.append("\b"+"\b"+"]");
		return stackElements.toString();
	}
	
	public void printStack(){
		 String stack = displayStack();
		 System.out.println(stack);
	}
	
	public static void main(String[] args){
		ListStack<Integer> s = new ListStack<Integer>();
	      try
	      {

	         for(int i = 0; i < 6; i++) s.push(i);

	         //s.clear();
	         //System.out.println(s);
	         s.printStack();
	         
	         s.pop();
	         
	         s.printStack();
	         
	         s.peek();
	      }
	      catch (StackException e)
	      {
	         System.err.println(e);
	      }
	}

}
