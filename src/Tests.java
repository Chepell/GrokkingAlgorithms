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


        Algos.recursiveSum(array);
        System.out.println(Algos.recursiveCount(array));

    }
}
