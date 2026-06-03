import java.io.File;
import java.io.IOException;

/**
 * File 类基础操作
 * @author lyf
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        // 1. 创建 test 目录
        File dir = new File("D:/pro/p1/Generic/test");
        if (dir.mkdir()) {
            System.out.println("创建目录成功: " + dir.getAbsolutePath());
        }

        // 2. 创建 a.txt 和 b.txt
        File aFile = new File(dir, "a.txt");
        File bFile = new File(dir, "b.txt");
        if (aFile.createNewFile()) {
            System.out.println("创建文件成功: " + aFile.getName());
        }
        if (bFile.createNewFile()) {
            System.out.println("创建文件成功: " + bFile.getName());
        }

        // 3. 列出 test 目录下所有文件
        System.out.println("\ntest 目录下的文件：");
        File[] files = dir.listFiles();
        for (File f : files) {
            System.out.println("  " + f.getName());
        }

        // 4. 打印 a.txt 的详细信息
        System.out.println("\na.txt 详细信息：");
        System.out.println("  绝对路径: " + aFile.getAbsolutePath());
        System.out.println("  大小: " + aFile.length() + " 字节");

        // 5. 删除 b.txt
        if (bFile.delete()) {
            System.out.println("\n删除 b.txt 成功");
        }

        // 6. 验证删除
        System.out.println("\n删除后 test 目录：");
        files = dir.listFiles();
        for (File f : files) {
            System.out.println("  " + f.getName());
        }
    }
}
