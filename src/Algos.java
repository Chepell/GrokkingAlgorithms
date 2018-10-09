import java.util.*;

public class Algos {

    public static int binarySearch(int[] array, int element) {
        // макс/мин индексы элементов в массиве
        int high = array.length - 1;
        int low = 0;
        int mid; // индекс среднего элемента
        int guess; // значение среднего элемента

        // цикл продолжается пока выбранный подмассив состоит хотя бы из одного элемента
        while (low <= high) {
            mid = (high + low) / 2;
            guess = array[mid];
            // если средний элемент меньше чем искомый
            if (guess < element) {
                low = mid + 1; // то отбрасываю левую часть массива
                // если средний элемент больше чем искомый
            } else if (guess > element) {
                high = mid - 1; // то отбрасываю правую часть
            } else {
                return mid; // иначе нашли элемени
            }
        }
        return -1; // если из цикла дошли сюда, значит элемента в массиве не оказалось, возвращаю -1
        // значение несуществующего индекса
    }

    // сортровка выбором. медленная O(n^2), такая же как и пузырьковая
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

    // рекурсивный метод расчета факториала
    public static long recursiveFactorial(int x) {
        if (x > 1) { // базовый случай пока значение аргумента больше 1
            return 1;
        } else {
            return x * recursiveFactorial(x - 1); // рекурсивный случай
        }
    }

    public static void countDown(int x) {
        if (x < 0) return; // базовый случай
        System.out.println(x);
        countDown(x - 1); // рекурсивный случай
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
            return 0; // возвращаю ноль
        } else { // иначе
            int firstElement = array[0]; // сохраняю первый элемент в переменную
            // удаляю из массива первый элемент используя приватный метод
//            quickSort = withoutElement(quickSort, 0);
            // или используя встроенный метод
            array = Arrays.copyOfRange(array, 1, array.length);
            // возвращаю сумму элемента и рекурсивного вызова метода с новым массивом
            return firstElement + recursiveSum(array);
        }
    }

    // рекурсивный метод расчета количества элементов в массиве
    public static int recursiveCount(int[] array) {
        if (array.length == 0) { // базовый случай, массив пуст
            return 0; // возвращаю ноль
        } else {
            // иначе отчезаю один элемент у массива
            array = Arrays.copyOfRange(array, 0, array.length - 1);
            // возвращаю 1 плюс рекурсивный вызов метода с новым массивом
            return 1 + recursiveCount(array);
        }
    }

    // рекурсивный метод поиска минимального значения в массиве
    public static int recursiveMax(int[] list) {
        if (list.length == 2) { // базовый случай, массив из двух элементов
            return list[0] > list[1] ? list[0] : list[1];
        }
        // у массива отрезаю один элемент и вызываю рекурсивно метод
        int subMax = recursiveMax(Arrays.copyOfRange(list, 1, list.length));
        return list[0] > subMax ? list[0] : subMax;
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