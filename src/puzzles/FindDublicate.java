package puzzles;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Artem Voytenko
 * 06.12.2018
 * Есть два массива (или ArrayList, как вам больше нравится) целых чисел,
 * котрые идентичны за иключением одного элемента
 * Нужно найти этот элемент
 */

public class FindDublicate {
	public static void main(String[] args) {

		Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] array2 = {1, 2, 3, 4, 5, 6, 1, 8, 9, 10};

		System.out.println(findDublicate(array2, array1));
	}

	private static Integer findDublicate(Integer[] fullArray, Integer[] testArray) {
		Set<Integer> set = new HashSet<>();
		Collections.addAll(set, fullArray);

		for (int i : testArray) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return null;
	}
}
