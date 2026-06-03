import java.util.Date;

/**
 * @author lyf
 */
public class GenericDemo1 {
    public static void main(String[] args) {
    Box<String> box = new Box<>();
    box.put("hello");
    System.out.println(box.take());
    box.printType();

    Box<Integer> box2 = new Box<>();
    box2.put(100);
        System.out.println(box2.take());
    box2.printType();

    Box<Date> box3 = new Box<>();
    box3.put(new Date());
    System.out.println(box3.take());
    box3.printType();
    }
    static class Box<T>{
        private T content;//存放内容

       public void put(T content){
           this.content = content;
       }
       public T take(){
           return content;
       }

       public boolean isEmpty(){
           return content == null;
       }

       public void printType(){
           System.out.println(content.getClass());
       }

    }

}
