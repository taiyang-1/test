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
    }
}