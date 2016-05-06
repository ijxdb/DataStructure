
public interface ListInterface<T> {

	public void add(T item);
	
	public T getByLocation(Integer location) throws RuntimeException;
	
	public T getByData(T data) throws RuntimeException;
	
	public void removeByLocation(Integer location) throws RuntimeException;
	
	public void removeByData(T data) throws RuntimeException;
	
	public Integer getSize();
}
