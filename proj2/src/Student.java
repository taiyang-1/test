/**
 * @author lyf
 */
public class Student extends Person {
    private String stuId;

    public Student() {
    }

    public Student(String name, int age, String stuId) {
        super(name, age);
        this.stuId = stuId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Override
    public void show() {
     super.show();
     System.out.println("学号：" + stuId);
    }
}