package Day5;

/**
 * ScoreManager 测试入口
 */
public class ScoreManagerTest {
    public static void main(String[] args)  {
    ScoreManager sm = new ScoreManager();
        try {
            sm.addScore("张三", 90);
            sm.addScore("李四", 85);
            sm.addScore("王五", 95);
            sm.addScore("赵六", 103);
            sm.addScore("钱七", 80);
        } catch (ScoreException e) {
            System.out.println("添加成绩失败：" + e.getMessage());
        }
        sm.listAll();
        sm.maxScore();
        sm.minScore();
        System.out.println("平均成绩：" + sm.average());
        try {
            sm.updateScore("赵六", 100);
            sm.removeStudent("钱七");
            sm.getScore("老八");
        } catch (ScoreException e) {
            System.out.println("操作失败：" + e.getMessage());
        }
        sm.listAll();
    }
}
