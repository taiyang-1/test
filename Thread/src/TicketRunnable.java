/**
 * 卖票任务 — 三个线程共享这同一个对象
 */
public class TicketRunnable implements Runnable {
    private int tickets = 10;   // 不加 static，靠共享同一个对象

    @Override
    public void run() {
        while (tickets > 0) {
            try {
                Thread.sleep(100);    // 放大线程安全问题
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 票号可能重复或出现负数 ← 这就是线程安全问题
            System.out.println(Thread.currentThread().getName() + " 卖出第" + tickets + "张票");
            tickets--;
        }
    }
}
