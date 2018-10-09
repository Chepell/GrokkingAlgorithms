import java.util.Arrays;
import java.util.Random;

public class Tests {

    static int[] array = {77, 79, -45, 63, 4, 9, 1, -50};

    public static void main(String[] args) {



        Algos.quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }
}
