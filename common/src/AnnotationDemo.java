import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @author lyf
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        Method[] methods = Robot.class.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Log.class)) {
                Log lg = m.getAnnotation(Log.class);
                System.out.println(lg.value());
            }
        }

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Log{
        String value();
    }

}
class Robot{
    @AnnotationDemo.Log("正在吃饭")
    public void eat(){}
    @AnnotationDemo.Log("正在跑步")
    public void run(){}
    @AnnotationDemo.Log("正在睡觉")
    public void sleep(){}
}
