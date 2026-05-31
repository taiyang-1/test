package Day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生分数管理系统 — 综合 HashMap + 自定义异常
 */
public class ScoreManager {
    //    private HashMap<String, Integer> scores = new HashMap<>();
//
//    public void addScore(String name, int score) throws ScoreException {
//        if (score < 0 || score > 100) {
//            throw new ScoreException("分数必须在 0~100 之间，输入值：" + score);
//        }
//        scores.put(name, score);
//        System.out.println("添加成功：" + name + " -> " + score);
//    }
//
//    public void removeStudent(String name) throws ScoreException {
//        if (!scores.containsKey(name)) {
//            throw new ScoreException("学生 " + name + " 不存在，无法删除");
//        }
//        scores.remove(name);
//        System.out.println("删除成功：" + name);
//    }
//
//    public void updateScore(String name, int newScore) throws ScoreException {
//        if (!scores.containsKey(name)) {
//            throw new ScoreException("学生 " + name + " 不存在，无法修改");
//        }
//        if (newScore < 0 || newScore > 100) {
//            throw new ScoreException("分数必须在 0~100 之间");
//        }
//        scores.put(name, newScore);
//        System.out.println("修改成功：" + name + " -> " + newScore);
//    }
//
//    public int getScore(String name) throws ScoreException {
//        Integer score = scores.get(name);
//        if (score == null) {
//            throw new ScoreException("学生 " + name + " 不存在");
//        }
//        return score;
//    }
//
//    public void listAll() {
//        if (scores.isEmpty()) {
//            System.out.println("暂无学生数据");
//            return;
//        }
//        System.out.println("=== 全部学生（按分数降序）===");
//        List<Map.Entry<String, Integer>> list = new ArrayList<>(scores.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o2.getValue() - o1.getValue();
//            }
//        });
//        for (Map.Entry<String, Integer> entry : list) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//    }
//
//    public double average() {
//        if (scores.isEmpty()) return 0;
//        int sum = 0;
//        for (int s : scores.values()) {
//            sum += s;
//        }
//        return (double) sum / scores.size();
//    }
//
//    public String maxScore() {
//        if (scores.isEmpty()) return "无数据";
//        String top = null;
//        int max = -1;
//        for (Map.Entry<String, Integer> e : scores.entrySet()) {
//            if (e.getValue() > max) {
//                max = e.getValue();
//                top = e.getKey();
//            }
//        }
//        return top + " (" + max + "分)";
//    }
//
//    public String minScore() {
//        if (scores.isEmpty()) return "无数据";
//        String bot = null;
//        int min = 101;
//        for (Map.Entry<String, Integer> e : scores.entrySet()) {
//            if (e.getValue() < min) {
//                min = e.getValue();
//                bot = e.getKey();
//            }
//        }
//        return bot + " (" + min + "分)";
//    }
//
//    public int count() {
//        return scores.size();
//    }
    HashMap<String, Integer> scores = new HashMap<>();
//    添加分数 分数 0~100 校验，不合法抛异常

    public void addScore(String name, Integer score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("分数必须在0~100之间，输入值：" + score);
        }
        scores.put(name, score);
        System.out.println("添加成功：" + name + "->" + score);
    }

    //学生不存在抛异常
    public void removeStudent(String name) throws ScoreException {
        if (!scores.containsKey(name)) {
            throw new ScoreException("学生" + name + "不存在，无法删除");
        }
        scores.remove(name);
        System.out.println("删除成功：" + name);
    }


    //学生不存在 + 分数不合法均抛异常
    public void updateScore(String name, int newScore) throws ScoreException {
if(!scores.containsKey(name)){
    throw new ScoreException("学生" + name + "不存在，无法修改");
        }
if(newScore < 0 || newScore > 100){
    throw new ScoreException("分数必须在0~100之间");

}
scores.put(name,newScore);
System.out.println("修改成功：" + name + "->" + newScore);
    }
//学生不存在抛异常

public int getScore(String name) throws ScoreException {
        if(!scores.containsKey(name)){
            throw new ScoreException("学生" + name + "不存在");


        }
  return scores.get(name);
}

//    按分数降序输出全部学生
    public void listAll(){
        if (scores.isEmpty()) {
            System.out.println("暂无学生数据");
            return;
        }
        System.out.println("=== 全部学生（按分数降序）===");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(scores.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
//    返回平均数
    public double average(){
        if(scores.isEmpty()) return 0;
        int sum =0;
         for (int s : scores.values()) {
             sum+=s;
         }
         return(double)sum/scores.size();
    }


// 返回最高分姓名+分数
    public String maxScore(){
        if (scores.isEmpty()) return "无数据";
        String top = null;
        int max = -1;
        for (Map.Entry<String, Integer> e : scores.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                top = e.getKey();
            }
        }
        return top + " (" + max + "分)";

    }

//    返回最低分姓名+分数
    public String minScore(){
      if(scores.isEmpty()) return "无数据";
      String bot = null;
      int min = 101;
        for(HashMap.Entry<String ,Integer> e: scores.entrySet()){
            if(e.getValue()<min){
                min = e.getValue();
                bot = e.getKey();
            }
        }
        return bot + " (" + min + "分)";
    }

//    返回总人数
    public int count(){
        return scores.size();
    }

}