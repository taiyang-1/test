package Day5;

import java.util.ArrayList;

/**
 * @author lyf
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("a");
        al.add("b");
        al.add("c");
        al.add("d");
        al.add("e");
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i));
        }
        System.out.println();
        for(String s:al){//增强for循环
            System.out.print(s);

        }
        System.out.println();
        System.out.println(al.get(2));
        al.add(2,"2");
        al.set(0,"1");
        al.remove(4);
        al.remove("e");
        System.out.println(al.contains("c"));
        System.out.println(al.size());
        al.forEach(item -> System.out.print(item));

        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i));
        }
    }
}
