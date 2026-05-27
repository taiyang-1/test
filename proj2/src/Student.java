/**
 * @author lyf
 */
public class Student extends Person {
    private String stuId;
    final String SCHOOL = "xx大学";
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
     System.out.println(getName() + " " + getAge() + " " +stuId + "来自 "+SCHOOL);
    }
}