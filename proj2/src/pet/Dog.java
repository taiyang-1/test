package pet;

/**
 * @author lyf
 */
public class Dog extends Animal implements Trainable{
    private String breed;

  public Dog(){}

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    @Override
    public void makeSound() {
        System.out.println("汪汪汪");
    }

    @Override
    public void doTrick() {
        System.out.println("摇尾巴");
    }
}
