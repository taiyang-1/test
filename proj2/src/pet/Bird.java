package pet;

/**
 * @author lyf
 */
public class Bird extends Animal implements Flyable,Trainable{
    private double wingspan;
    public Bird(){}
    public Bird(String name, int age, double wingspan){
        super(name,age);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public void makeSound(){
        System.out.println("叽叽喳喳");
    }

    @Override
    public void fly() {
        System.out.println("正在飞...");
    }

    @Override
    public void doTrick() {
        System.out.println("转圈");
    }
}

