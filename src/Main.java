import java.util.Random;

public class Main {

    final static int ARRAY_CAPACITY = 10;

    public static void main(String[] args) {
       // int[] array = generateArray(ARRAY_CAPACITY);
        System.out.println(array.length);
        System.out.println(sum(array));
    }

    static int[] generateArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(150);      }
        return new int[length];
    }

    static int sum(int[] array) {
        int s = 0;
        for (int i = 0; i < array.length; i++) {
            s = s + array[i];
        }
        return s;
    }
}