package Day6;

import java.io.*;

/**
 * IO 流入门 — 文件读写
 *
 * 题目：
 * 1. 用 FileWriter 把 "Hello IO流\n今天天气不错\n" 写入 data.txt
 * 2. 用 FileReader 逐字符读出来，打印到控制台
 *
 * 注意：写完要 close()
 */
public class FileIODemo {
    public static void main(String[] args)  {
        write();
        read();



    }

    // 写文件
    public static void write()  {
        FileWriter fw = null;
        try {
            fw = new FileWriter("data.txt");
            fw.write("Hello IO流\n");
            fw.write("今天天气不错\n");
            System.out.println("写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {        // 判空，防止 fw 创建失败时空指针
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 读文件
    public static void read() {
        FileReader fr = null;
        try {
            fr = new FileReader("data.txt");
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
