
interface StackInterface<T> {

	public boolean isEmpty();
	
	public T pop() throws StackException;
	
	public T peek() throws StackException;
	
	public void push(T e) throws StackException;
	
	public void clear();
	
	public String displayStack();
	
}
