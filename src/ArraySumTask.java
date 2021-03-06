import java.util.concurrent.RecursiveTask;

public class ArraySumTask extends RecursiveTask<Integer> {

    private int start;
    private int end;
    private int[] array;

    public ArraySumTask(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    protected Integer compute() {
        final int diff = end - start;
        if (diff > Main.R) {
            return forkTasksAndGetResult();
        } else {
            return Main.subSum(array, start, end);
        }
    }

    private int forkTasksAndGetResult() {
        final int middle = (end - start) / 2 + start;
        ArraySumTask task1 = new ArraySumTask(start, middle, array);
        ArraySumTask task2 = new ArraySumTask(middle, end, array);
        invokeAll(task1, task2);
        return task1.join() + task2.join();
    }
}