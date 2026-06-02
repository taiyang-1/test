import java.util.concurrent.atomic.AtomicInteger;

/**
 * 卖票任务（乐观锁版）— 三个线程共享这同一个对象
 */
public class TicketRunnable implements Runnable {

    private AtomicInteger tickets = new AtomicInteger(10);
    @Override
    public void run() {
        while (true) {
            int ticketNum = tickets.getAndDecrement();  // 原子取值+减1
            if (ticketNum <= 0) {
                System.out.println(Thread.currentThread().getName() + " 票卖完了");
                break;
            }
            System.out.println(Thread.currentThread().getName()
                    + " 卖出第" + ticketNum + "张票");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
