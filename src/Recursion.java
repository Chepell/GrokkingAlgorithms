public class Recursion {
    public static void main(String[] args) {


        countDown(10);


    }

    public static void countDown(int i) {
        System.out.println(i);
        if (i <= 0) return; // базовый случай
        countDown(i - 1); // рекурсивный случай
    }



}
