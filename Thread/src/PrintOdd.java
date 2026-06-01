/**
 * @author lyf
 */
public class PrintOdd extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(i%2==0){
                System.out.println("偶数"+i);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
