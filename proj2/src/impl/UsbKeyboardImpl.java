package impl;

import Interface.USB;

/**
 * @author lyf
 */
public class UsbKeyboardImpl implements USB {

    @Override
    public void start() {
        System.out.println("键盘启动");
    }

    @Override
    public void stop() {
        System.out.println("键盘停止");
    }
}
