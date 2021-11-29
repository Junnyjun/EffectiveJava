package EX06;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Item39 {
    /**
     * 명명 패턴보다 어노테이션을 사용
     *
     * @Annotation({ value1, value2 ... }) 배열 형식으로 받을 수 있다.
     *
     * 어노테이션이 할 수 있는 일을 명명패턴으로 처리하지 않는다.
     *
     */
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ExceptionTest {
    Class<? extends Exception>[] value();
}

class Sample3 {
    // 이 변형은 원소 하나짜리 매개변수를 받는 애너테이션도 처리할 수 있다. (241쪽 Sample2와 같음)
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {  // 성공해야 한다.
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {  // 실패해야 한다. (다른 예외 발생)
        int[] a = new int[0];
        int i = a[1];
    }
}
