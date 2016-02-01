public class IterativeFibonacci {

    public static int iterativeFibonacci(int n) {
        int x = 0, y = 1, z = 1;
        for (int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return x;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println(iterativeFibonacci(i));
        }
    }

}
