
/**
 * interface for list
 * @author Jay
 * @param <T> object of any class; can be int, character, Integer, String.
 */
public interface ListInterface<T> {
	
	/**
	 * Adds an item (of any class) to the list.
	 * @param item is an object to be added to the list.
	 */
	public void add(T item);

	/**
	 * Gets an item based on its location from the list.
	 * @param location The position of an item in the list.
	 * @return the location of the requested item.
	 * @throws RuntimeException if an item does not exist at that location.
	 */
	public T getByLocation(Integer location) throws RuntimeException;

	/**
	 * Gets an item based on its value from the list.
	 * @param data The value of an item in the list.
	 * @return the data of the requested item.
	 * @throws RuntimeException if an item does not exist.
	 */
	public T getByData(T data) throws RuntimeException;

	/**
	 * Removes an item based on the location from the list.
	 * @param location The position of an item in the list.
	 * @throws RuntimeException if an item does not exist at that location.
	 */
	public void removeByLocation(Integer location) throws RuntimeException;

	/**
	 * Removes an item based on the value from the list.
	 * @param data The value of an item in the list.
	 * @throws RuntimeException if an item does not exist at that location.
	 */
	public void removeByData(T data) throws RuntimeException;

	/**
	 * Provides the size of the List
	 * @return current size of the list.
	 */
	public Integer getSize();
}
