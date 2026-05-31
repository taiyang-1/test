package Day5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * HashSet（无序去重） + TreeSet（自动排序）
 */
public class HashSetTreeSetDemo {
    public static void main(String[] args) {
        // ===== HashSet：去重，无序 =====
        System.out.println("=== HashSet 演示 ===");
        HashSet<String> hs = new HashSet<>();
        hs.add("apple");
        hs.add("banana");
        hs.add("cherry");
        hs.add("apple");  // 重复，不会加入
        hs.add("date");

        System.out.println("Set 内容（无序）：" + hs);
        System.out.println("包含 banana？" + hs.contains("banana"));
        System.out.println("大小：" + hs.size());

        // 三种遍历方式
        System.out.print("增强 for：");
        for (String s : hs) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.print("迭代器：");
        Iterator<String> it = hs.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.print("forEach：");
        hs.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // ===== TreeSet：自动排序 =====
        System.out.println("\n=== TreeSet 默认排序（字典序）===");
        TreeSet<String> ts = new TreeSet<>();
        ts.add("python");
        ts.add("java");
        ts.add("c++");
        ts.add("javascript");
        ts.add("go");
        System.out.println("TreeSet：" + ts);
        System.out.println("第一个：" + ts.first());
        System.out.println("最后一个：" + ts.last());

        // ===== TreeSet 自定义排序（按字符串长度）=====
        System.out.println("\n=== TreeSet 自定义排序（按长度）===");
        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int lenDiff = o1.length() - o2.length();
                if (lenDiff == 0) {
                    return o1.compareTo(o2); // 长度相同按字典序
                }
                return lenDiff;
            }
        });
        ts2.add("aaa");
        ts2.add("bb");
        ts2.add("c");
        ts2.add("dddd");
        ts2.add("eee");
        System.out.println("按长度排序：" + ts2);

        // ===== 存储自定义对象到 HashSet =====
        System.out.println("\n=== HashSet 存储整数 ===");
        HashSet<Integer> nums = new HashSet<>();
        nums.add(10);
        nums.add(30);
        nums.add(20);
        nums.add(10);  // 重复
        nums.add(40);
        System.out.println("去重整数：" + nums);

        // 交集、并集、差集
        HashSet<Integer> setA = new HashSet<>();
        setA.add(1); setA.add(2); setA.add(3); setA.add(4);

        HashSet<Integer> setB = new HashSet<>();
        setB.add(3); setB.add(4); setB.add(5); setB.add(6);

        // 并集
        HashSet<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("并集：" + union);

        // 交集
        HashSet<Integer> inter = new HashSet<>(setA);
        inter.retainAll(setB);
        System.out.println("交集：" + inter);

        // 差集（A - B）
        HashSet<Integer> diff = new HashSet<>(setA);
        diff.removeAll(setB);
        System.out.println("差集 A-B：" + diff);
    }
}
