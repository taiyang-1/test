package Oop;

/**
 * @author lyf
 */
public class Main {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager(5);
        sm.add(new Student("1","z",13,50));
        sm.add(new Student("2","w",14,60));
        sm.add(new Student("3","q",15,70));
        sm.showAll();
        System.out.println(sm.getSize());
        System.out.println(Student.getCount());
    }
}
