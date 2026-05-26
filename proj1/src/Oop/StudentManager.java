package Oop;

/**
 * @author lyf
 */
public class StudentManager {
    private Student[] students;
    private int size;
//传入数组的初始化参数
    StudentManager(int capacity){
        students = new Student[capacity];
    }
public void add(Student s){
        if(size == students.length){
            System.out.println("数组已满");
        }
    students[size] = s;
    size++;
}
public void delete(String id){

    int index = -1;
    // 先找到要删的位置
    for (int i = 0; i < size; i++) {
        if (students[i].getId().equals(id)) {
            index = i;
            break;
        }
    }

    if (index == -1) {
        System.out.println("未找到该学生");
        return;
    }

    // 后面的元素往前移
    for (int i = index; i < size - 1; i++) {
        students[i] = students[i + 1];
    }
    students[size - 1] = null;
    size--;
    System.out.println("删除成功");



}
public void update(Student s){
    for (int i = 0; i < size; i++) {
        if (students[i].getId().equals(s.getId())) {
            students[i] = s;
            System.out.println("更新成功");
            return;
        }
    }
    System.out.println("未找到该学生");
}
public void showAll(){
    for (int i = 0; i < size; i++) {
        System.out.println("学号" + students[i].getId() + "姓名" + students[i].getName() + "年龄" + students[i].getAge() +"成绩" + students[i].getScore());
    }
}
public int getSize(){
        return size;
}

}
