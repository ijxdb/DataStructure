
/**
 * Test class: to test the functionality
 * @author Jay
 *
 */
public class LinkedListTest {

	/**
	 * Create a List of String and Integer to test the functionality
	 * @param args currently not used
	 */
	public static void main(String[] args) {
		System.out.println("\n\n\n************TEST-1***************");
		// Test list of Strings:
		System.out.println("Testing List of Strings");
		// test construtor
		System.out.println("test construtor");
		LinkedList<String> list = new LinkedList<String>();
		// test toString() for empty list
		// list.displayList();
		System.out.println("empty list: " + list.toString());
		String letter = new String("A");
		// test add
		System.out.println("test add() 1 node");
		list.add(letter);
		// list.displayList();
		// test toString() for list of 1
		System.out.println("list of 1:\n" + list.toString());
		// test add() for several nodes
		System.out.println("test add() several nodes");
		letter = new String("B");
		list.add(letter);
		letter = new String("C");
		list.add(letter);
		letter = new String("D");
		list.add(letter);
		// list.displayList();
		// test toString() for empty list of many
		System.out.println("list of many:\n" + list.toString());
		// test get
		Integer currentSize = list.getSize();
		letter = list.getByLocation(currentSize);
		System.out.println("test getByLocation(), letter: " + letter);
		System.out.println("test getByData(A): " + list.getByData("A"));
		System.out.println("test getByData(D): " + list.getByData("D"));
		// test remove
		System.out.println("remove #1, 3: ");
		list.removeByLocation(3);
		list.removeByData("A");
		// list.displayList();
		System.out.println(list.toString());
		// test remove
		System.out.println("remove #2, 1: ");
		list.removeByLocation(2);
		list.removeByLocation(1);
		System.out.println(list.toString());
		// list.displayList();

		// Test list of Strings:
		System.out.println("\n\n\n************TEST-2***************");
		System.out.println("Testing List of Integers");
		// test construtor
		System.out.println("test construtor");
		LinkedList<Integer> listInteger = new LinkedList<Integer>();
		// test toString() for empty list
		// list.displayList();
		System.out.println("empty list: " + listInteger.toString());
		// test add
		System.out.println("test add() 1 node");
		listInteger.add(10);
		// list.displayList();
		// test toString() for list of 1
		System.out.println("list of 1:\n" + listInteger.toString());
		// test add() for several nodes
		System.out.println("test add() several nodes");
		listInteger.add(20);
		listInteger.add(30);
		listInteger.add(40);
		// list.displayList();
		// test toString() for empty list of many
		System.out.println("list of many:\n" + listInteger.toString());
		// test get
		System.out.println("test get(), letter: " + listInteger.getByLocation(listInteger.getSize()));
		System.out.println("test getByData(10): " + listInteger.getByData(10));
		System.out.println("test getByData(30): " + listInteger.getByData(30));
		// test remove
		System.out.println("remove #1, 3: ");
		listInteger.removeByLocation(3);
		listInteger.removeByLocation(1);
		// list.displayList();
		System.out.println(listInteger.toString());
		// test remove
		System.out.println("remove #2, 1: ");
		listInteger.removeByLocation(2);
		listInteger.removeByLocation(1);
		System.out.println(listInteger.toString());
		// list.displayList();
		
		
		System.out.println("\n\n\n************TEST-3***************");
		System.out.println("Testing two list are equal or not");
		LinkedList<Integer> listInteger1 = new LinkedList<Integer>();
		LinkedList<Integer> listInteger2 = new LinkedList<Integer>();
		listInteger1.add(5);
		listInteger1.add(2);
		listInteger1.add(3);
		listInteger2.add(1);
		listInteger2.add(2);
		System.out.println(listInteger1.equals(listInteger2));
		listInteger1.insert(4, 1);
		System.out.println(listInteger1);

	}
}
