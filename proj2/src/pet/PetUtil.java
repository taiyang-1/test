package pet;

/**
 * @author lyf
 */
public final class PetUtil {
    public static void printInfo(Animal a){
        a.show();
        if (a instanceof Dog) {
            System.out.println("品种：" + ((Dog) a).getBreed());
        } else if (a instanceof Cat) {
            System.out.println("颜色：" + ((Cat) a).getColor());
        } else if (a instanceof Bird) {
            System.out.println("翼展：" + ((Bird) a).getWingspan());
        }

    }

    public static void makeThemSound(Animal[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].makeSound();
        }
    }
    public static void trainAll(Trainable[] arr){
        for (int i = 0; i < arr.length; i++)
            arr[i].doTrick();
    }
}
