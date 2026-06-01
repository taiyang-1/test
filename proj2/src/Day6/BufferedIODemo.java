package Day6;

import java.io.*;

/**
 * @author lyf
 */
public class BufferedIODemo {
    public static void main(String[] args) throws IOException {
        //创建缓冲流
        BufferedWriter bw = new BufferedWriter(new FileWriter("story.txt"));
        bw.write("春眠不觉晓");
        bw.newLine();
        bw.write("处处闻啼鸟");
        bw.newLine();
        bw.write("夜来风雨声");
        bw.newLine();
        bw.write("花落知多少");
        bw.close();
        //读文件

        BufferedReader br = new BufferedReader(new FileReader("story.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);

        }br.close();

        System.out.println("--------------------------");

        BufferedReader br1 = new BufferedReader(new FileReader("story.txt"));
        BufferedWriter bw1 = new BufferedWriter(new FileWriter("story_copy.txt"));
        String line1;
        while ((line1 = br1.readLine()) != null) {
            System.out.println(line1);   // 打印
            bw1.write(line1);            // 复制
            bw1.newLine();
        }
        bw1.close();
        br1.close();
    }
}
