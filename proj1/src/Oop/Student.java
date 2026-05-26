package Oop;

/**
 * @author lyf
 */
public class Student {
    private String id ;
    private String name;
    private int age;
    private double score;
    public Student(){

    }
    public Student(String id,String name,int age,double score){
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        if(age < 0 || age > 120){
            System.out.println("年龄不合法");
            return;
        }
        this.age = age;
    }
    public void setScore(double score){
        this.score = score;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getScore(){
        return  score;
        }

     public void show(){
         System.out.println("学号："+id+"姓名："+name+"年龄："+age+"成绩："+score);
     }

    }

