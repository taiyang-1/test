package Oop;

/**
 * @author lyf
 */
public class StudentManager {
    private Student[] students;
    private int size;
//传入数组的初始化参数
   public StudentManager(int capacity){
        students = new Student[capacity];
    }
public void add(Student s){
        if(size == students.length){
            System.out.println("数组已满");
            return;
        }
    students[size] = s;
    size++;
}
public void delete(String id){

    int index = findById(id);


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
    int index = findById(s.getId());
    if(index == -1){
        System.out.println("未找到该学生");
        return;
    }else{
        students[index] = s;
        System.out.println("修改成功");
    }
    }

public void showAll(){
    for (int i = 0; i < size; i++) {
        students[i].show();
    }
}
public int getSize(){
        return size;
}
 public int findById(String id){
     if(id == null){
         return -1;
     }
     for (int i = 0; i < size; i++) {
         if(id.equals(students[i].getId())){
             return i;
         }
     }
     return -1;
 }
}
