package standard.ch13.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx1 {
    static final ForkJoinPool pool = new ForkJoinPool(); // 쓰레드 풀 생성

    public static void main(String[] args) {
        long from = 1L, to = 100_000_000L;

        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis();
        Long result = pool.invoke(task);
        System.out.println("Elapsed time(4 Core):" + (System.currentTimeMillis() - start));

        System.out.printf("sum of %d~%d=%d%n", from, to, result);
        System.out.println();

        result = 0L;
        start = System.currentTimeMillis();
        for (long i = from; i <= to; i++) {
            result += i;
        }
        System.out.println("Elapsed time(1 Core):" + (System.currentTimeMillis() - start));

        System.out.printf("sum of %d~%d=%d%n", from, to, result);
    }
}

class SumTask extends RecursiveTask<Long> {
    long from;
    long to;

    public SumTask(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        long size = to - from + 1; // from ~ to 까지의 합을 구하는 것이므로 +1을 해준다.
        if(size <= 5) { // from ~ to 까지의 합을 구하는 것이므로 +1을 해준다.
            return sum();
        }
        long half = (from + to) / 2;
        SumTask leftSum = new SumTask(from, half);
        SumTask rightSum = new SumTask(half + 1, to);

        leftSum.fork();

        return rightSum.compute() + leftSum.join();
    }
    private Long sum() {
        long tmp = 0L;
        for (long i = from; i <= to; i++) {
            tmp += i;
        }
        return tmp;
    }
}
