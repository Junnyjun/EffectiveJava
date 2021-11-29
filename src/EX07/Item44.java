package EX07;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Item44 {
    /**
     * 표준 함수형 인터페이스를 사용하라
     *  UnaryOperator - String.~
     *  BinaryOperator - BigInteger.~
     *  Predicate - Collection.~
     *  Function - Arrays.~
     *  Supplier - Instant.~
     *  Consumer - System.out.~
     *
     *  기본 함수형 인터페이스에 박싱된 기본타입을 넣어 사용은 금지
     *  직접 만든 함수형 인터페이스에는 항상 @FunctionalInterface 를 사용하라
     */
    public static void main(String[] args) {
        String a = "test";
        a.toLowerCase(Locale.ROOT);

        BigInteger b = BigInteger.valueOf(1);
        b.add(BigInteger.valueOf(2));

        Collection c = Collections.singleton("test");
        c.clear();

        Supplier<String> d = () -> "test";
        d.get();

        Consumer<String> e = s -> System.out.println(s.toLowerCase(Locale.ROOT));
        e.accept("Hello");
    }
}

