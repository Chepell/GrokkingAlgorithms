// демонстрация обмена значений
public class Pair {
    private int x;
    private int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // без временной переменной с использованием побитового XOR
    void swap() {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }

    @Override
    public String toString() {
        return "Pair{" + "x=" + x + ", y=" + y + '}';
    }
}
