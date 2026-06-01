package Day6;

import java.io.*;

/**
 * @author lyf
 */
public class BufferedStream {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream("C:\\Users\\86132\\Pictures\\wallhaven-exywxo_2560x1080.png"));
            bos = new BufferedOutputStream(new FileOutputStream("copy.png"));
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        } finally {
            if (bis != null) bis.close();
            if (bos != null) bos.close();
        }

    }
}
