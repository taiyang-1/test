import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1. 创建固定 3 个线程的池子
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 2. 提交 5 个 Runnable 任务
        for (int i = 1; i <= 5; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    int sum = 0;
                    for (int j = 1; j <= 100; j++) {
                        sum += j;
                    }
                    System.out.println(Thread.currentThread().getName()
                            + " [Runnable] 1~100 的和 = " + sum);
                }
            });
        }

        // 3. 提交 2 个 Callable 任务，用 Future 拿返回值
        Future<Integer> future1 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int j = 1; j <= 100; j++) {
                    sum += j;
                }
                return sum;
            }
        });

        Future<Integer> future2 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int j = 1; j <= 100; j++) {
                    sum += j;
                }
                return sum;
            }
        });

        // 拿到返回值并打印
        System.out.println("[Callable1] 1~100 的和 = " + future1.get());
        System.out.println("[Callable2] 1~100 的和 = " + future2.get());

        // 4. 关闭线程池
        pool.shutdown();
    }
}
