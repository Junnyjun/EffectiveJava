package EX09;

import java.util.Comparator;

public class Item61 {
    /**
     * 박싱된 기본 타입보다는 기본 타입을 사용하라.
     *
     * 박싱된 타입과 기본타입의 차이는 세가지다.
     * 기본타입은 값만 가지고 이;ㅆ으나 박싱된 기본타입은 식별성이란 속성을 갖는다.
     * 박싱된 타입은 null을 가질수 있다.
     * 기본타입이 박싱된 기본타입보다 시간과 메모리사용면에서 더 효율적이다.
     *
     * 기본타입을 다루는 비교자는 Comparator, naturalOrder를 사용하라
     *
     * 박싱된 기본 타입을 쓰는 경우
     * 컬렉션의 원소, 키, 값 을 담는경우
     * 리플렉션을 통해 메서드를 호출할 때
     *
     * 언박싱떄 NPE를 조심하라
     *
     */

    public static void main(String[] args) {
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed; // 오토박싱
            return i < j ? -1 : (i == j ? 0 : 1);
        };

        int result = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result);
    }
}
