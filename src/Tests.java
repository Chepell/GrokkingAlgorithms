import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tests {
    static int[] array = {77, 79, -45, 63, 4, 9, 1, -50};

    public static void main(String[] args) {

//        Algos.quickSort(array, 0, array.length - 1);
//        System.out.println("Отсортированный массив:");
//        System.out.println(Arrays.toString(array));
//
//        int x = 15;
//        int y = 36;
//        Pair pair = new Pair(x, y);
//        System.out.println(pair);
//        pair.swap();
//        System.out.println("Метод меняет местами значения в полях объекта не используя временную переменную");
//        System.out.println(pair);

//		Algos.recursivePrimeFactorDecomposition(132);



		int i = Algos.binaryLog(1_000_000);
		System.out.println(i);

		ArrayList<String> objects = new ArrayList<>();

		List<Integer> list = new LinkedList<>();

		Thread thread = new Thread();


	}
}
