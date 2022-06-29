import java.util.Random;
import java.util.concurrent.RecursiveTask;

public class Main {

    final static int ARRAY_CAPACITY = 10;
    final static int R = 2;

    public static void main(String[] args) {
        int[] array = generateArray(ARRAY_CAPACITY);
        System.out.println("Массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        System.out.println("Однопоточный результат...");
        System.out.println("Сумма элементов массива: " + sum(array));
        System.out.println("Среднее арифметическое значение массива: " + sum(array)/ARRAY_CAPACITY);

        System.out.println("Многопоточный результат...");
        ArraySumTask arraySumTask = new ArraySumTask(0, ARRAY_CAPACITY, array);
        System.out.println("Сумма элементов массива: " + arraySumTask.compute());
        System.out.println("Среднее арифметическое значение массива: " + arraySumTask.compute()/ARRAY_CAPACITY);
    }

    static int[] generateArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    static int sum(int[] array) {
        int s = 0;
        for (int i = 0; i < array.length; i++) {
            s = s + array[i];
        }
        return s;
    }
}