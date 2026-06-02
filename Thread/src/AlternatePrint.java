/**
 * 交替打印 1~10 — 两个线程一个打奇数一个打偶数
 */
public class AlternatePrint {
    private int num = 1;
    private final Object lock = new Object();

    public void printOdd() {
        synchronized (lock) {
            while (num <= 10) {
                if (num % 2 == 1) {
                    System.out.println("奇数:" + num);
                    num++;
                    lock.notify();   // 叫醒偶数线程
                } else {
                    try {
                        lock.wait(); // 不该我，等着
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            lock.notify();  // 退出前叫醒对方
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (num <= 10) {
                if (num % 2 == 0) {
                    System.out.println("偶数:" + num);
                    num++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            lock.notify();
        }
    }
}
