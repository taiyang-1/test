package employee;

/**
 * @author lyf
 */
public final class CompanyUtil {
    public static void printAll(Employee[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].showInfo();
//            if(arr[i]instanceof Manager){
//                Manager m = (Manager) arr[i];
//                m.showInfo();
//            }else if (arr[i] instanceof Programmer){
//                Programmer p = (Programmer) arr[i];
//                p.showInfo();
//            }else if(arr[i] instanceof Salesperson){
//                Salesperson s = (Salesperson) arr[i];
//                s.showInfo();
//            }
        }
    }
    public static double totalBonus(Employee[] arr){
       double sunBonus = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof Bonus) {
                sunBonus += ((Bonus) arr[i]).calcBonus();
            }
        }
        return sunBonus;
    }
public static void trainAll(Trainable[] arr){
    for (int i = 0; i < arr.length; i++) {

            arr[i].train();
        }

}
//按照baseSalary降序排序
public static Employee[] sortBySalary(Employee[] arr){
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length - 1 - i; j++) {
            if (arr[j].getBaseSalary() < arr[j+1].getBaseSalary()){
                Employee temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    return arr;
}
}
