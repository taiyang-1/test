import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lyf
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = () ->{
            int sum = 0;
            for (int i = 0; i <= 50; i++) sum += i;
            return sum;
        };

        Callable<Integer> task2 = () ->{
            int sum = 0;
            for (int i = 0; i <= 100; i++) sum += i;
            return sum;
        };

        FutureTask<Integer> ft = new FutureTask<>(task);
        Thread t = new Thread(ft);
        t.start();

        FutureTask<Integer> ft1 = new FutureTask<>(task2);
        Thread t2 = new Thread(ft1);
        t2.start();

        Integer result = ft.get();
        System.out.println(result);
        Integer result2 = ft1.get();
        System.out.println(result2);


    }


}