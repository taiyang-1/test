import Interface.USB;
import impl.UsbKeyboardImpl;
import impl.UsbMouseImpl;

/**
 * @author lyf
 */
public class Main {
    public static void main(String[] args) {
        Person stu = new Student("lyf", 20, "1");
        Person[] p = new Person[5];
        p[0] = stu;
        p[1] = new Teacher("ll", 12, 5000);
        for (int i = 0; i < p.length; i++) {
            if (p[i] != null) {
                p[i].show();
                if (p[i] instanceof Student) {
                    Student s = (Student) p[i];
                    System.out.println(s.getStuId());
                } else if (p[i] instanceof Teacher) {
                    Teacher t = (Teacher) p[i];
                    System.out.println(t.getSalary());
                }
            }
        }
        USB[] u = new USB[3];
        u[0] = new UsbKeyboardImpl();
        u[1] = new UsbMouseImpl();
        u[2] = new USB() {
            @Override
            public void start() { System.out.println("U盘连接"); }
            @Override
            public void stop() { System.out.println("U盘断开"); }
        };
        for (int i = 0; i < u.length; i++) {
            u[i].start();
            u[i].stop();
        }
    }
}