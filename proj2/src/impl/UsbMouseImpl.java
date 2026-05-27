package impl;

import Interface.USB;

/**
 * @author lyf
 */
public class UsbMouseImpl implements USB {
    @Override
    public void start() {
        System.out.println("mouse start");
    }

    @Override
    public void stop() {
        System.out.println("mouse stop");
    }
}
