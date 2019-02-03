package list;

/**
 * Artem Voytenko
 * 03.02.2019
 */

public class MyLinkedList<T> {
	private Node<T> head;
	private int size;

	// узел односвязанного списка
	private static class Node<T> {
		private T data;
		private Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	// метод добавляет элемент в конец списка
	public void add(T elem) {
		// если список пустой
		if (head == null) {
			// добавляем новый элемент в голову списка
			head = new Node<>(elem);
		} else {
			Node<T> tailNode = head;
			// циклом иду к хвосту списка используя next
			while (tailNode.next != null) {
				// если есть следующий элемент то
				// ссылку указываю на него и повторяю цикл
				tailNode = tailNode.next;
			}
			// цикл прервался, когда у очередного узла нет
			// ссылки на следующий элемент тогда устанавливаю ему каждо
			tailNode.next = new Node<>(elem);
		}
		size++;
	}

	// метод добавляет элемент в указанный индекс
	public void add(int index, T elem) {
		int currentIndex = 0;
		// добавление на нулевую позицию
		if (index == 0) {
			Node<T> newNode = new Node<>(elem);
			newNode.next = head;
			head = newNode;
		} else {
			Node<T> tmpNode = head;
			while (currentIndex < index - 1) {
				tmpNode = tmpNode.next;
				currentIndex++;
			}
			Node<T> newNode = new Node<>(elem);
			newNode.next = tmpNode.next;
			tmpNode.next = newNode;
		}
		size++;
	}

	// метод возвращает значение элемента по индексу
	public T get(int index) {
		int currentIndex = 0;

		Node<T> tmpNode = head;
		// циклом иду до искомого узла
		while (currentIndex < index) {
			tmpNode = tmpNode.next;
			currentIndex++;
		}
		// возвращаю значение узла
		return tmpNode.data;
	}

	// метод возвращает значение элемента по индексу и удаляет его из списка
	public T remove(int index) {
		T result;
		// если удаляется элемент из головы списка
		if (index == 0) {
			// беру значения
			result = head.data;
			// ссылку головы уазываю на следующий элемент
			head = head.next;
		} else {
			int currentIndex = 0;

			Node<T> tmpNode = head;
			// циклом иду до узла который находится перед искомым
			while (currentIndex < index - 1) {
				tmpNode = tmpNode.next;
				currentIndex++;
			}
			// беру значение из искомого узла
			result = tmpNode.next.data;
			// ссылку текущего узла на следующий заменяю на узел через один
			tmpNode.next = tmpNode.next.next;
		}
		// уменьшаю значение количества элементов в списке
		size--;
		// возвращаю значение удаленного узла
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> tailNode = head;
		for (int i = 0; i < size; i++) {
			sb.append(tailNode.data);
			if (i == size - 1) break;
			sb.append(" | ");
			tailNode = tailNode.next;
		}
		return sb.toString();
	}
}
