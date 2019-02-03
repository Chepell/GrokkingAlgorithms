package list;

/**
 * Artem Voytenko
 * 03.02.2019
 */

public class LinkedListTest {
	public static void main(String[] args) {
		MyLinkedList<Double> list = new MyLinkedList<>();
		list.add(56.6);
		list.add(0D);
		list.add(-50D);
		list.add(0, -65.555);
		list.add(1, 9999.555);

		System.out.println(list);

		System.out.println();

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(4));

		System.out.println(list.remove(4));

		System.out.println(list.get(0));



		System.out.println(list);

	}
}
