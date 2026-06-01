/**
 * 卖票任务 — 三个线程共享这同一个对象
 */
public class TicketRunnable implements Runnable {
    private int tickets = 10;   // 不加 static，靠共享同一个对象

    @Override
    public void run() {
        while (true) {
            synchronized (this) {        // this 就是锁
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName()
                            + " 卖出第" + tickets + "张票");
                    tickets--;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;               // 没票了，退出
                }
            }
        }
    }
}
