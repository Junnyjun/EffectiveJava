package Ex01.TEST;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class test {

    @Test
    public void testGetInstance() {

        // 케이스 1. singleton 객체가 만들어졌는지 시험
        SingleTonSerial singleton = SingleTonSerial.getInstance();
        assertNotNull(singleton);

        // 케이스 2. singleton 객체가 하나만 만들어지는지 시험
        SingleTonSerial singleton2 = SingleTonSerial.getInstance();
        assertSame(singleton, singleton2);
        // Singleton은 하나의 객체만 반환한다!
        System.out.println("singleton = " + singleton);
        System.out.println("singleton2 = " + singleton2);
    }
}
