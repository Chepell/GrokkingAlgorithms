import java.util.*;

public class Algos {

	// метод возвращает индекс искомого элемнта в массиве
	public static int binarySearch(int[] array, int element) {
		// макс/мин индексы элементов в массиве
		int high = array.length - 1;
		int low = 0;
		int mid; // индекс среднего элемента
		int medium; // значение среднего элемента

		// цикл продолжается пока выбранный подмассив состоит хотя бы из одного элемента
		while (low <= high) {
			mid = (high + low) / 2;
			medium = array[mid];
			// если искомый элемент больше среднего
			if (medium < element) {
				low = mid + 1; // то отбрасываю левую часть массива
				// если искомый элемент меньше среднего
			} else if (element < medium) {
				high = mid - 1; // то отбрасываю правую часть
			} else {
				return mid; // цикл продолжается пока не попадаю сюда или не соблюдается условие (тогда элемента нет)
			}
		}
		return -1; // если из цикла дошли сюда, значит элемента в массиве не оказалось, возвращаю -1
		// значение несуществующего индекса
	}

	// сортировка выбором. медленная O(n^2), такая же как и пузырьковая
	public static int[] selectionSort(int[] array) {
		int length = array.length; // длина массива
		int[] sortArray = new int[length]; // создание нового массива для сортированных символов
		// цикл по продолжительности равный длине массива
		for (int i = 0; i < length; i++) {
			int smallestIndex = findSmallest(array); // нахожу индекс минимального объекта
			sortArray[i] = array[smallestIndex]; // помещаю найденный объект в новый массив
//            quickSort[smallestIndex] = Integer.MAX_VALUE; // даный вариант работает намного быстрее
			array = withoutElement(array, smallestIndex); // удаляю из массива элемент с найденный минимумом
		}
		return sortArray; // в конце возвращаю
	}

	// метод для поиска индекса минимального элемента в массиве
	private static int findSmallest(int[] array) {
		int smallestIndex = 0;
		int smallest = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < smallest) {
				smallest = array[i];
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}

	// метод возвращает новый массив с удаленным по индексу элементом
	private static int[] withoutElement(int[] array, int indexToDelete) {
		int[] newArray = new int[array.length - 1];
		for (int i = 0; i < array.length; i++) {
			if (i < indexToDelete) {
				newArray[i] = array[i];
			} else if (i > indexToDelete) {
				newArray[i - 1] = array[i];
			}
		}
		return newArray;
	}

	// рекурсивное определение является ли слово палиндромом
	public static boolean isPalindrome(String word) {
		// базовый выход, когда слово всего один символ
		if (word.length() <= 1) {
			return true;
		}
		// проверяю крайние буквы слова
		if (word.charAt(0) != word.charAt(word.length() - 1)) {
			return false;
		}
		// обрезаю у слова крайние буквы, которые совпали
		String cutWord = word.substring(1, word.length() - 1);
		// рекурсивно вызываю метод с новым словом у которого отрезаны крайние буквы
		return isPalindrome(cutWord);
	}

	// рекурсивный метод расчета факториала
	public static long recursiveFactorial(int x) {
		if (x <= 1) { // когда параметр 1 или меньше
			return 1;
		} else {
			return x * recursiveFactorial(x - 1); // рекурсивный случай
		}
	}

	// рекурсивное разложения числа на множители
	public static void recursivePrimeFactorDecomposition(int number) {
		int diveder = 2;
		while (number >= diveder) {
			if (number % diveder == 0) {
				if (diveder != number) {
					System.out.print(diveder + " ");
					recursivePrimeFactorDecomposition(number / diveder);
				} else {
					System.out.print(diveder); // вывод последнего делителя
				}
				return; // и прерывание цикла
			}
			diveder++;
		}
	}

	// обратный отсчет с помощью рекурсии
	public static void recursiveCountDown(int x) {
		if (x < 0) return; // базовый случай, прекратить выполнение
		System.out.println(x);
		recursiveCountDown(x - 1); // рекурсивный случай
	}

	// сумма элементов массива в цикле
	public static int loopSum(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum;
	}

	// сумма элементов в массиве рекурсией
	public static int recursiveSum(int[] array) {
		if (array.length == 0) { // базовый случай, когда в массиве нет элементов
			return 0;
		} else { // иначе
			int firstElement = array[0]; // сохраняю первый элемент в переменную
			// удаляю из массива первый элемент используя приватный метод
//            quickSort = withoutElement(quickSort, 0);
			// или используя встроенный метод
			array = Arrays.copyOfRange(array, 1, array.length);
			// возвращаю сумму элемента и рекурсивного вызова метода с новым массивом
			return firstElement + recursiveSum(array); // в итоге все разложится на сумму из еденичных элементов массива
		}
	}

	// рекурсивный метод расчета количества элементов в массиве
	public static int recursiveCount(int[] array) {
		if (array.length == 0) { // базовый случай, массив не содержит элементов
			return 0;
		} else {
			// иначе отрезаю первый элемент у массива
			array = Arrays.copyOfRange(array, 1, array.length);
			// возвращаю 1 плюс рекурсивный вызов метода с новым массивом
			return 1 + recursiveCount(array);
		}
	}

	// рекурсивный метод поиска максимального значения в массиве
	public static int recursiveMax(int[] array) {
		if (array.length == 2) { // базовый случай, массив из двух элементов
			return array[0] > array[1] ? array[0] : array[1];
		}
		// у массива отрезаю один элемент и вызываю рекурсивно метод
		int subMax = recursiveMax(Arrays.copyOfRange(array, 1, array.length));
		return array[0] > subMax ? array[0] : subMax;
	}


	// алгоритм евклида, наибольший общий делитель
	public static int nod(int a, int b) {
		if (b == 0) return a; // базовый случай, если b стал 0, то a - нод
		int x = a % b;
		return nod(b, x);
	}

	// алгоритм быстрой сортировки, O(n * log n)
	public static void quickSort(int[] array, int beginInd, int endInd) {
		// базовый случай, массив состоит из одного элемента или пустой
		// или начальный индекс стал больше либо равен конечному
		if (array.length <= 1 || beginInd >= endInd) {
			return;
		}

		// определяю индекс среднего элемента массива
		int middle = (endInd + beginInd) / 2;
		// сам элемент
		int pivot = array[middle];

		// переменные для циклов по правому и левому подмассиву
		int i = beginInd;
		int j = endInd;

		// внешний цикл продолжается пока начальный индекс не больше конечного
		while (i <= j) {
			// пока элемент в правом подмассиве меньше центрального двигаюсь вправо по элементам
			while (array[i] < pivot) {
				i++;
			}
			// пока элемент в левом подмассиве больше центрального двигаюсь влево по элементам
			while (array[j] > pivot) {
				j--;
			}
			// вышли из двух циклов, когда максимально сильно продвинулись
			// к центру и имеем индексы элементов, которые нужно менять местами
			if (i <= j) {
				// меняю элементы местами
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				// и индексы итерирую, т.к. элементы поменял местами
				i++;
				j--;
			}
		}
		// условия для рекурсивного вызова
		// левый подмассив
		if (beginInd < j) {
			quickSort(array, beginInd, j);
		}
		// правый полмассив
		if (endInd > i) {
			quickSort(array, i, endInd);
		}
	}
}