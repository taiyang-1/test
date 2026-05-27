package pet;

/**
 * @author lyf
 */
public abstract class Animal {
    private String name;
    private int age;
    private static final String TYPE = "Animal";

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

   public void show(){
       System.out.println("Name: " + name + ", Age: " + age + ", Type: " + TYPE);
   }
   public abstract void makeSound();
}
