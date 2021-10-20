package Ex01.TEST;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class Singleton{
    private static Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        return (null != instance) ? (instance) : (instance = new Singleton());
    }
    // 편의상 합쳤어요~
    // Singleton singleton = null;
    @Test
    public void testGetInstance() {

        // 케이스 1. singleton 객체가 만들어졌는지 시험
        Singleton singleton = Singleton.getInstance();
        assertNotNull(singleton);
        // 케이스 2. singleton 객체가 하나만 만들어지는지 시험
        Singleton singleton2 = Singleton.getInstance();
        assertSame(singleton, singleton2); // Singleton은 하나의 객체만 반환한다!
    }
}
