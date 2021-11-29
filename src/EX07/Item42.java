package EX07;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

import static java.util.Comparator.comparingInt;

public class Item42 {

    /**
     * 익명 클래스보다 람다를 사용하라
     *
     * 타입을 명시해야 코드가 명확할 경우를 제외하면 람다의 모든 매개변수 타입을 생략하라.
     *
     *
     * 람다는 이름이 없고 문서화를 하지 못한다
     * 코드 자체의 동작이 설명되지 않거나 코드 줄 수가 많아지면 람다를 자제해야 한다
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList(args);
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(words);
        Collections.shuffle(words);

        Collections.sort(words, comparingInt(String::length));
        System.out.println(words);
        Collections.shuffle(words);

        words.sort(comparingInt(String::length));
        System.out.println(words);
    }
}

enum Operation {
    PLUS  ("+", (x, y) -> x + y),
    MINUS ("-", (x, y) -> x - y),
    TIMES ("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override public String toString() { return symbol; }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }
}