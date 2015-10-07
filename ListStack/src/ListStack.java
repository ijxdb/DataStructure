
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
		T data = top.getData(top); // can use peek()
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
	
	// Not used as of now....
	public void displayElement(Node<T> e) throws StackException{
		if(isEmpty()) throw new StackException("Stack is empty");
		StringBuffer element = new StringBuffer();
		Node<T> temp = e;
		element.append(temp.getData(temp));
		System.out.println(element.toString());
	}

	
	public static void main(String[] args){
		ListStack<Integer> s = new ListStack<Integer>();
		//ListStack<String> s1 = new ListStack<String>();
	      try
	      {

	         for(int i = 0; i < 6; i++) s.push(i);//s1.push(String.valueOf(i));

	         //s.clear();
	         //System.out.println(s);
	         s.printStack();//s1.printStack();
	         
	         System.out.println(s.pop());//System.out.println(s1.pop());
	         
	         s.printStack(); // s1.printStack();
	         
	         System.out.println(s.peek());//System.out.println(s1.peek());
	      }
	      catch (StackException e)
	      {
	         System.err.println(e);
	      }
	}

}
