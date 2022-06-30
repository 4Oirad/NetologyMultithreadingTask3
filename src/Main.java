import java.util.Random;
import java.util.concurrent.RecursiveTask;

public class Main {

    final static int ARRAY_CAPACITY = 10000;
    final static int R = 100;

    public static void main(String[] args) {

        int[] array = generateArray(ARRAY_CAPACITY);

        long start1 = System.currentTimeMillis();

        System.out.println("Однопоточный результат...");
        System.out.println("Сумма элементов массива: " + sum(array));
        System.out.println("Среднее арифметическое значение массива: " + sum(array)/ARRAY_CAPACITY);

        long finish1 = System.currentTimeMillis();
        long elapsed1 = finish1 - start1;
        System.out.println("Прошло времени, мс: " + elapsed1);

        System.out.println();

        long start2 = System.currentTimeMillis();

        System.out.println("Многопоточный результат...");
        ArraySumTask arraySumTask = new ArraySumTask(0, ARRAY_CAPACITY, array);
        System.out.println("Сумма элементов массива: " + arraySumTask.compute());
        System.out.println("Среднее арифметическое значение массива: " + arraySumTask.compute()/ARRAY_CAPACITY);

        long finish2 = System.currentTimeMillis();
        long elapsed2 = finish2 - start2;
        System.out.println("Прошло времени, мс: " + elapsed2);
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

    static int subSum(int[] array, int start, int end) {
        int s = 0;
        for (int i = start; i < end; i++) {
            s = s + array[i];
        }
        return s;
    }
}