package Day5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyf
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("南昌","江西");
        map.put("武汉","湖北");
        map.put("长沙","湖南");
        map.put("南京","江苏");
        map.put("杭州","浙江");
        System.out.println(map);
        System.out.println(map.get("南昌"));

        System.out.println(map.containsKey("杭州"));
        System.out.println(map.size());
        System.out.println(map.keySet());
        System.out.println(map.values());
        map.forEach((key,value)-> System.out.println(key+"-"+value));
//        第一种遍历
        for(String key:map.keySet()){
            System.out.println(key+"-"+map.get(key));
        }
        //        第二种遍历
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
        //        JDK8 forEach
        map.forEach((k, v) -> System.out.println(k + "->" + v));
    }
}
