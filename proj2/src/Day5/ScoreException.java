package Day5;

/**
 * 自定义异常：成绩相关异常
 */
public class ScoreException extends Exception {
    public ScoreException(String message) {
        super(message);
    }
}
