package puzzles;

/**
 * Artem Voytenko
 * 06.12.2018
 * Дан блок кода. Дополните его так, чтобы цикл стал бесконечным.
 *
 */

public class InfinityLoop {
	public static void main(String[] args) {

		// впишите код сюда
		int start = Integer.MAX_VALUE - 1;

		for (int i = start; i <= start + 1; i++) {
			/* тут должен быть бесконечный цикл, менять ничего нельзя */
			System.out.println(i);
		}
	}
}
