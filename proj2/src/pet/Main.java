package pet;

/**
 * @author lyf
 */
public class Main {
    public static void main(String[] args) {
        Animal[] a = new Animal[3];
        a[0] = new Dog("wangcai",2,"male");
        a[1] = new Cat("mimi",1,"female");
        a[2] = new Bird("xiaozhao",1,2);
        Trainable[] t = new Trainable[3];
        t[0] = new Dog("二哈",2,"male");
        t[1] = new Bird("biqi",1,2);
        t[2] = new Trainable() {
            @Override
            public void doTrick() {
                System.out.println("I can do tricks");
            }
        };
//        验证PetUtil
        for (int i = 0; i < a.length; i++) {
            PetUtil.printInfo(a[i]);
        }
        PetUtil.makeThemSound(a);


            PetUtil.trainAll(t);

    }
}
