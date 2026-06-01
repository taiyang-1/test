/**
 * @author lyf
 */
public class PrintEven extends  Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            if(i%2!=0){
                System.out.println("奇数"+i);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
