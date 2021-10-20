package Ex01.TEST;

import java.io.Serializable;

public class SingleTonSerial implements Serializable {

    private static SingleTonSerial instance = null;
    private SingleTonSerial() {
    }
    public static SingleTonSerial getInstance() {
        return (null != instance) ? (instance) : (instance = new SingleTonSerial());
    }
}

