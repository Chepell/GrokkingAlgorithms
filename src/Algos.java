import java.util.*;

/**
 * В классе собраны реализации различных алгоритмов и нетипичных методов
 */
public class Algos {

	/**
	 * Метод возвращает индекс искомого элемента в массиве
	 *
	 * @param array   отсортированный массив
	 * @param element значение элемента для поиска
	 * @return возвращает индекс искомого элемента в массиве, либо -1 если такого элемента нет
	 */
	protected static int binarySearch(int[] array, int element) {
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
		return -1;
	}

	/**
	 * Сортировка выбором. медленная O(n^2), такая же как и пузырьковая
	 *
	 * @param array массив для сортировки
	 * @return отсортированный массив
	 */
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
		return sortArray;
	}

	/**
	 * Метод для поиска индекса минимального элемента в массиве
	 *
	 * @param array массив для поиска
	 * @return индекс минимального элемента
	 */
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

	/**
	 * Метод возвращает новый массив с удаленным по индексу элементом
	 *
	 * @param array         массив для удаления элемента
	 * @param indexToDelete индекс элемента, который нужно удалить
	 * @return новыцй массив без удаленного элемента
	 */
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

	/**
	 * Рекурсивное определение является ли слово палиндромом.
	 * Палиндром (от греч. palindromos – бегущий обратно) – слово,
	 * которое читается одинаково слева направо и справа налево (например, ротор).
	 *
	 * @param word слово для проверки
	 * @return true/false
	 */
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

	/**
	 * Рекурсивное определение значение числа фибоначчи по номеру
	 *
	 * @param n номер числа в последовательности фибоначчи
	 * @return число фибоначчи
	 */
	public static long recursiveFibonacci(int n) {
		if (n < 3) return 1; // базовый случай, когда всего два первых числа в последовательности
		return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
	}

	/**
	 * Рекурсивный метод расчета факториала
	 *
	 * @param x факториал Х
	 * @return значение
	 */
	public static long recursiveFactorial(int x) {
		if (x <= 1) { // когда параметр 1 или меньше
			return 1;
		} else {
			return x * recursiveFactorial(x - 1); // рекурсивный случай
		}
	}

	/**
	 * Рекурсивное разложения числа на множители
	 *
	 * @param number число для разложения
	 */
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

	/**
	 * Обратный отсчет с помощью рекурсии
	 *
	 * @param x начало отсчета
	 */
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

	/**
	 * Рекурсивный метод расчета количества элементов в массиве
	 * @param array Массив для расчета
	 * @return Количество элементов в массиве
	 */
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

	/**
	 * Рекурсивный метод поиска максимального значения в массиве
	 * @param array Массив для поиска
	 * @return Найденный максимальный элемент в массиве
	 */
	public static int recursiveMax(int[] array) {
		if (array.length == 2) { // базовый случай, массив из двух элементов
			return array[0] > array[1] ? array[0] : array[1];
		}
		// у массива отрезаю один элемент и вызываю рекурсивно метод
		int subMax = recursiveMax(Arrays.copyOfRange(array, 1, array.length));
		return array[0] > subMax ? array[0] : subMax;
	}

	/**
	 * Алгоритм евклида, наибольший общий делитель
	 * @param a Первое число
	 * @param b Второе число
	 * @return НОД
	 */
	public static int nod(int a, int b) {
		if (b == 0) return a; // базовый случай, если b стал 0, то a - нод
		int x = a % b;
		return nod(b, x);
	}

	/**
	 * Рекурсивный алгоритм быстрой сортировки, сложность O(n * log n)
	 * @param array Массив для сортировки
	 * @param beginInd Начальный индекс массива
	 * @param endInd Конечный индекс массива
	 */
	//
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

	/**
	 * Расчет двоичного логорифма с использованием базовой библиотеки java.lang.Math
	 * @param number Число для которого нужно рассчитать двоичный логарифм
	 * @return Результат рассчета двоичного логарифма
	 */
	public static int binaryLog(int number) {
		return (int) Math.round(Math.log(number) / Math.log(2));
	}
}